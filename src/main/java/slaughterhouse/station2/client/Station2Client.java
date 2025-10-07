package slaughterhouse.station2.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import slaughterhouse.RegisterAnimalPartRequest;
import slaughterhouse.Station2ServiceGrpc;

import java.util.Scanner;

public class Station2Client
{

  public static void main(String[] args)
  {
    ManagedChannel managedChannel = ManagedChannelBuilder.forAddress(
        "localhost", 9090).usePlaintext().build();

    Station2ServiceGrpc.Station2ServiceBlockingStub station2Stub = Station2ServiceGrpc.newBlockingStub(managedChannel);

    Scanner keyboard = new Scanner(System.in);

    System.out.println("Type an empty line to exit the application.");
    boolean isRunning = true;
    while (isRunning)
    {
      System.out.println();
      System.out.print("Enter the weight of the animalpart: ");
      String input = keyboard.nextLine();
      if (input == null)
        continue; // Shouldn't happen, I think
      if (input.isEmpty())
      {
        isRunning = false;
        continue;
      }

      System.out.println();
      System.out.print("Enter the type of the animalpart");
      String input1 = keyboard.nextLine();
      if (input1 == null)
        continue; // Shouldn't happen, I think
      if (input1.isEmpty())
      {
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


      RegisterAnimalPartRequest request = RegisterAnimalPartRequest.newBuilder()
          .setWeight(typedNumber)
          .setType(input1)
          .build();

      System.out.println("Registering animal, please wait...");
      station2Stub.registerAnimalPart(request);
    }


    keyboard.close();
    managedChannel.shutdown();
  }
}
