package slaughterhouse.station2.sever;

import io.grpc.stub.StreamObserver;
import slaughterhouse.Empty;
import slaughterhouse.RegisterAnimalRequest;
import slaughterhouse.Station2ServiceGrpc;

public class Station2ServiceImpl extends
    Station2ServiceGrpc.Station2ServiceImplBase{
  @Override
  public void registerAnimal(
      RegisterAnimalRequest request, StreamObserver<Empty> responseObserver) {
    System.out.println(String.format("Received animal with weight, %d", request.getWeight()));
    responseObserver.onNext(null);
    responseObserver.onCompleted();
  }
}
