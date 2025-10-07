package slaughterhouse.databaseserver;

import io.grpc.stub.StreamObserver;
import slaughterhouse.*;
import slaughterhouse.domain.Animal;
import slaughterhouse.domain.Product;

import java.util.ArrayList;
import java.util.List;

public class SlaughterHouseServiceImpl extends SlaughterhouseServiceGrpc.SlaughterhouseServiceImplBase{
  private DatabaseDAO dao;

  public SlaughterHouseServiceImpl(DatabaseDAO dao){
    this.dao = dao;
  }

  @Override
  public void getAnimalsInProduct(GetAnimalsInProductRequest request, StreamObserver<GetAnimalsInProductResponse> responseObserver) {
    Product product = dao.getProduct(request.getProductId());
    List<AnimalDTO> animals = new ArrayList<>();
    for(int animalId : product.getAnimalPartIds()){
      Animal animal = dao.getAnimal(animalId);
      animals.add(AnimalDTO.newBuilder().setId(animal.getId()).setWeight(animal.getWeight()).build());
    }
    responseObserver.onNext(GetAnimalsInProductResponse.newBuilder().addAllAnimals(animals).build());
    responseObserver.onCompleted();
  }

  @Override
  public void getProductsFromAnimal(GetProductsFromAnimalRequest request, StreamObserver<GetProductsFromAnimalResponse> responseObserver){
    int id = request.getAnimalId();
    List<ProductDTO> products = new ArrayList<>();
    for(Product product : dao.getAllProducts()){
      if(product.getAnimalPartIds().contains(id))
        products.add(ProductDTO.newBuilder().setId(product.getId()).build());
    }
    responseObserver.onNext(GetProductsFromAnimalResponse.newBuilder().addAllProducts(products).build());
    responseObserver.onCompleted();
  }
}
