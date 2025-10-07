package slaughterhouse.station3.server;

import io.grpc.stub.StreamObserver;
import slaughterhouse.Empty;
import slaughterhouse.HalfAnAnimalRequest;
import slaughterhouse.PackPartsRequest;
import slaughterhouse.Station3ServiceGrpc;

public class Station3ServiceImpl extends Station3ServiceGrpc.Station3ServiceImplBase
{
  Station3ServiceGrpc.Station3ServiceBlockingStub databaseStub;

  public Station3ServiceImpl(Station3ServiceGrpc.Station3ServiceBlockingStub databaseStub)
  {
    this.databaseStub = databaseStub;
  }

  @Override public void packParts(
      PackPartsRequest request, StreamObserver<Empty> responseObserver) {
    System.out.println(String.format("Product packed with: %d, amount: %d", request.getId(), request.getNumber()));
    databaseStub.packParts(request);
    responseObserver.onNext(null);
    responseObserver.onCompleted();
  }

  @Override public void halfAnAnimal(HalfAnAnimalRequest request, StreamObserver<Empty> responseObserver)
  {
    System.out.println("Half-An-Animal packed with the following IDs:");
    for(int i = 0; i < request.getIdCount(); i++)
    {
      System.out.println(request.getId(i));
    }
    databaseStub.halfAnAnimal(request);
    responseObserver.onNext(null);
    responseObserver.onCompleted();
  }
}
