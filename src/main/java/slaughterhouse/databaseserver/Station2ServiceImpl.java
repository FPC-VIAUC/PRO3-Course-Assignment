package slaughterhouse.databaseserver;

import io.grpc.stub.StreamObserver;
import slaughterhouse.Empty;
import slaughterhouse.RegisterAnimalPartRequest;
import slaughterhouse.Station2ServiceGrpc;
import slaughterhouse.domain.AnimalPart;

public class Station2ServiceImpl extends Station2ServiceGrpc.Station2ServiceImplBase{
  private DatabaseDAO dao;

  public Station2ServiceImpl(DatabaseDAO dao){
    this.dao = dao;
  }

  @Override public void registerAnimalPart(RegisterAnimalPartRequest request, StreamObserver<Empty> responseObserver) {
    int animalPartId = dao.getNextAnimalPartId();
    AnimalPart animalPart = new AnimalPart(animalPartId, request.getWeight(), request.getType(), request.getAnimalId());
    dao.addAnimalPart(animalPart);
    responseObserver.onNext(RegisterAnimalPartResponse().newBuilder().setId(animalPartId).build());
    responseObserver.onCompleted();
  }
}
