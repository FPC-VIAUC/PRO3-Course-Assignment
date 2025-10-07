package slaughterhouse.station2.sever;

import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import slaughterhouse.*;

public class Station2ServiceImpl extends Station2ServiceGrpc.Station2ServiceImplBase
{
  private Station2ServiceGrpc.Station2ServiceBlockingStub databaseStub;
  @Override public void registerAnimalPart(RegisterAnimalPartRequest request,
      StreamObserver<RegisterAnimalPartResponse> responseObserver)
  {
    System.out.println(
        String.format("Received animalpart with weight, %d, type, %s and source animal id: %d", request.getWeight(), request.getType(), request.getAnimalId()));
    databaseStub.registerAnimalPart(request);
    responseObserver.onNext(null);
    responseObserver.onCompleted();
  }

  @Override public void createTray(CreateTrayRequest request,
      StreamObserver<CreateTrayResponse> responseObserver)
  {
    databaseStub.createTray(request);
    responseObserver.onNext(null);
    responseObserver.onCompleted();
  }

  @Override public void addAnimalPartToTray(
      AddAnimalPartToTrayRequest request, StreamObserver<AddAnimalPartToTrayResponse> responseObserver)
  {
    databaseStub.addAnimalPartToTray(request);
    responseObserver.onNext(null);
    responseObserver.onCompleted();
  }

}


