package slaughterhouse.station1.server;

import io.grpc.stub.StreamObserver;
import slaughterhouse.Empty;
import slaughterhouse.RegisterAnimalRequest;
import slaughterhouse.Station1ServiceGrpc;

public class Station1ServiceImpl extends
    Station1ServiceGrpc.Station1ServiceImplBase{
  @Override
  public void registerAnimal(
      RegisterAnimalRequest request, StreamObserver<Empty> responseObserver) {
    System.out.println(String.format("Received animal with weight, %d", request.getWeight()));
    responseObserver.onNext(null);
    responseObserver.onCompleted();
  }
}
