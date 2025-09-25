package slaughterhouse;

import io.grpc.stub.StreamObserver;

public class AnimalServiceImpl extends AnimalServiceGrpc.AnimalServiceImplBase{


  @Override
  public void getAnimalsInProduct(GetAnimalsInProductRequest request, StreamObserver<GetAnimalsInProductResponse> responseObserver) {
    responseObserver.onCompleted();
  }

  @Override
  public void getProductsFromAnimal(GetProductsFromAnimalRequest request, StreamObserver<GetProductsFromAnimalResponse> responseObserver) {
    responseObserver.onCompleted();
  }

  @Override
  public void registerAnimal(AnimalDTO request, StreamObserver<Empty> responseObserver) {
    System.out.println(String.format("Received animal with id, %d, and weight, %d", request.getId(), request.getWeight()));
    responseObserver.onNext(null);
    responseObserver.onCompleted();
  }
}
