package slaughterhouse.station3.server;

import io.grpc.stub.StreamObserver;
import slaughterhouse.Empty;
import slaughterhouse.GetPartRequest;
import slaughterhouse.Station3ServiceGrpc;

public class Station3ServiceImpl extends Station3ServiceGrpc.Station3ServiceImplBase
{
  @Override public void getPart(
      GetPartRequest request, StreamObserver<Empty> responseObserver) {
    System.out.println(String.format("Filling package with, %d", request.getType()));
    responseObserver.onNext(null);
    responseObserver.onCompleted();
  }
}
