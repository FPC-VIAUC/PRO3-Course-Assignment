package slaughterhouse.station1.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import slaughterhouse.RegisterAnimalRequest;
import slaughterhouse.Station1ServiceGrpc;

import java.util.Scanner;

public class Station1Client{
  public static void main(String[] args){
    ManagedChannel managedChannel = ManagedChannelBuilder
        .forAddress("localhost", 9091)
        .usePlaintext()
        .build();

    Station1ServiceGrpc.Station1ServiceBlockingStub station1Stub =
        Station1ServiceGrpc.newBlockingStub(managedChannel);

    Scanner keyboard = new Scanner(System.in);

    System.out.println("Type an empty line to exit the application.");
    boolean isRunning = true;
    while(isRunning){
      System.out.println();
      System.out.print("Enter the weight of the animal: ");
      String input = keyboard.nextLine();
      if(input == null) continue; // Shouldn't happen, I think
      if(input.isEmpty()){
        isRunning = false;
        continue;
      }

      int typedNumber;
      try{
        typedNumber = Integer.parseInt(input);
      } catch(NumberFormatException e){
        System.out.println("Not a valid number, try again.");
        continue;
      }
      if(typedNumber < 0){
        System.out.println("Weight cannot be a negative number, try again.");
        continue;
      }

      RegisterAnimalRequest request = RegisterAnimalRequest.newBuilder()
          .setWeight(typedNumber)
          .build();

      System.out.println("Registering animal, please wait...");
      station1Stub.registerAnimal(request);
    }

    keyboard.close();
    managedChannel.shutdown();
  }
}
