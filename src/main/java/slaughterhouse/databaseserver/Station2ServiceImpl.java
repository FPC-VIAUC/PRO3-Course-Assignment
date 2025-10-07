package slaughterhouse.databaseserver;

import io.grpc.stub.StreamObserver;
import slaughterhouse.*;
import slaughterhouse.domain.*;

public class Station2ServiceImpl extends Station2ServiceGrpc.Station2ServiceImplBase{
  private DatabaseDAO dao;

  public Station2ServiceImpl(DatabaseDAO dao){
    this.dao = dao;
  }

  @Override public void registerAnimalPart(RegisterAnimalPartRequest request, StreamObserver<RegisterAnimalPartResponse> responseObserver) {
    int animalPartId = dao.getNextAnimalPartId();
    AnimalPart animalPart = new AnimalPart(animalPartId, request.getWeight(), request.getType(), request.getAnimalId());
    dao.addAnimalPart(animalPart);
    responseObserver.onNext(RegisterAnimalPartResponse.newBuilder().setId(animalPartId).build());
    responseObserver.onCompleted();
  }

  @Override public void createTray(CreateTrayRequest request, StreamObserver<CreateTrayResponse> responseObserver) {
    int trayId = dao.getNextTrayId();
    Tray tray = new Tray(trayId, request.getType(), request.getMaxWeight());
    dao.addTray(tray);
    responseObserver.onNext(CreateTrayResponse.newBuilder().setId(trayId).build());
    responseObserver.onCompleted();
  }

  @Override public void addAnimalPartToTray(AddAnimalPartToTrayRequest request, StreamObserver<AddAnimalPartToTrayResponse> responseObserver) {
    dao.addPartToTray(request.getAnimalPartId(), request.getTrayId());

    Tray tray = dao.getTrayId(request.getTrayId());
    int weight = 0;
    for(int animalPartId : tray.getAnimalPartIds()){
      AnimalPart animalPart = dao.getAnimalPart(animalPartId);
      weight += animalPart.getWeight();
    }
    boolean weightLimitReached = weight >= tray.getWeightCapacity();
    responseObserver.onNext(AddAnimalPartToTrayResponse.newBuilder().setWeightLimitReached(weightLimitReached).build());
    responseObserver.onCompleted();
  }
}
