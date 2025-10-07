package slaughterhouse.databaseserver;

import io.grpc.stub.StreamObserver;
import org.checkerframework.checker.units.qual.A;
import slaughterhouse.Empty;
import slaughterhouse.RegisterAnimalRequest;
import slaughterhouse.Station1ServiceGrpc;
import slaughterhouse.domain.Animal;

public class Station1ServiceImpl extends Station1ServiceGrpc.Station1ServiceImplBase{
  private DatabaseDAO dao;

  public Station1ServiceImpl(DatabaseDAO dao){
    this.dao = dao;
  }

  @Override
  public void registerAnimal(RegisterAnimalRequest request, StreamObserver<Empty> responseObserver) {
    Animal animal = new Animal(dao.getNextAnimalId(), request.getWeight());
    dao.addAnimal(animal);
    responseObserver.onNext(null);
    responseObserver.onCompleted();
  }
}
