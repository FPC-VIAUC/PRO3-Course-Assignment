package slaughterhouse.station1.server;

import io.grpc.stub.StreamObserver;
import slaughterhouse.Empty;
import slaughterhouse.RegisterAnimalRequest;
import slaughterhouse.Station1ServiceGrpc;

public class Station1ServiceImpl extends Station1ServiceGrpc.Station1ServiceImplBase{
  private Station1ServiceGrpc.Station1ServiceBlockingStub databaseStub;

  public Station1ServiceImpl(Station1ServiceGrpc.Station1ServiceBlockingStub databaseStub){
    this.databaseStub = databaseStub;
  }

  @Override
  public void registerAnimal(RegisterAnimalRequest request, StreamObserver<Empty> responseObserver) {
    System.out.println(String.format("Received animal with weight, %d", request.getWeight()));
    databaseStub.registerAnimal(request);
    responseObserver.onNext(null);
    responseObserver.onCompleted();
  }
}
