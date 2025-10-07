package slaughterhouse.station3.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import slaughterhouse.GetPartRequest;
import slaughterhouse.RegisterAnimalRequest;
import slaughterhouse.Station1ServiceGrpc;
import slaughterhouse.Station3ServiceGrpc;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Station3Client{
  //A product can be in the same package as the same type
  public static void main(String[] args){
    ManagedChannel managedChannel = ManagedChannelBuilder
        .forAddress("localhost", 9093)
        .usePlaintext()
        .build();

    Station3ServiceGrpc.Station3ServiceBlockingStub station3Stub =
        Station3ServiceGrpc.newBlockingStub(managedChannel);

    Scanner keyboard = new Scanner(System.in);

    System.out.println("Type an empty line to exit the application.");
    boolean isRunning = true;
    while(isRunning){
      System.out.println();
      System.out.print("Enter the type of part: ");
      String type = keyboard.nextLine();
      System.out.print("Enter the number of parts: ");
      int times = keyboard.nextInt();

      if(type == null) continue; // Shouldn't happen, I think
      if(type.isEmpty()){
        isRunning = false;
        continue;
      }

      if (times == 0)
      {
        System.out.println("You will need at least one part!");
      }

      GetPartRequest request = GetPartRequest.newBuilder().setType(type).build();

      System.out.println("Packing the products, please wait...");
      station3Stub.getPart(request);
    }

    keyboard.close();
    managedChannel.shutdown();
  }

  //Half an animal - A lot of different parts
}
