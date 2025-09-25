package slaughterhouse.station1.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import slaughterhouse.AnimalDTO;
import slaughterhouse.AnimalServiceGrpc;

public class Station1Client{
  public static void main(String[] args){
    ManagedChannel managedChannel = ManagedChannelBuilder
        .forAddress("localhost", 9090)
        .usePlaintext()
        .build();

    AnimalServiceGrpc.AnimalServiceBlockingStub animalStub =
        AnimalServiceGrpc.newBlockingStub(managedChannel);

    AnimalDTO request = AnimalDTO.newBuilder()
        .setId(0)
        .setWeight(2000)
        .build();

    animalStub.registerAnimal(request);

    managedChannel.shutdown();
  }
}
