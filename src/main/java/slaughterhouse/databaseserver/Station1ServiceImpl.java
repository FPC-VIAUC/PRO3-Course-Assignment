package slaughterhouse.databaseserver;

import io.grpc.stub.StreamObserver;
import slaughterhouse.Empty;
import slaughterhouse.RegisterAnimalRequest;
import slaughterhouse.Station1ServiceGrpc;
import slaughterhouse.domain.Animal;

import java.time.LocalDate;

public class Station1ServiceImpl extends Station1ServiceGrpc.Station1ServiceImplBase{
  private DatabaseDAO dao;

  public Station1ServiceImpl(DatabaseDAO dao){
    this.dao = dao;
  }

  @Override
  public void registerAnimal(RegisterAnimalRequest request, StreamObserver<Empty> responseObserver) {
    Animal animal = new Animal(dao.getNextAnimalId(), request.getWeight(), request.getOrigin(), LocalDate.now());
    dao.addAnimal(animal);
    responseObserver.onNext(null);
    responseObserver.onCompleted();
  }
}
