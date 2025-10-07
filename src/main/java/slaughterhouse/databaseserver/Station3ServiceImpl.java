package slaughterhouse.databaseserver;

import io.grpc.stub.StreamObserver;
import slaughterhouse.Empty;
import slaughterhouse.HalfAnAnimalRequest;
import slaughterhouse.PackPartsRequest;
import slaughterhouse.Station3ServiceGrpc;
import slaughterhouse.domain.HalfAnAnimal;
import slaughterhouse.domain.Package;

public class Station3ServiceImpl extends Station3ServiceGrpc.Station3ServiceImplBase{
  private DatabaseDAO dao;

  public Station3ServiceImpl(DatabaseDAO dao){
    this.dao = dao;
  }

  @Override public void packParts(
      PackPartsRequest request, StreamObserver<Empty> responseObserver) {
    dao.addProduct(new Package(dao.getNextProductId(), request.getType(), request.getNumber()));
    responseObserver.onNext(null);
    responseObserver.onCompleted();
  }

  @Override public void halfAnAnimal(HalfAnAnimalRequest request, StreamObserver<Empty> responseObserver)
  {
    dao.addProduct(new HalfAnAnimal(dao.getNextProductId(), request.getIdList()));
    responseObserver.onNext(null);
    responseObserver.onCompleted();
  }
}
