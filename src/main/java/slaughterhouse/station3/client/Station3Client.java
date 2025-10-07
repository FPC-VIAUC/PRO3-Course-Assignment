package slaughterhouse.station3.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import slaughterhouse.HalfAnAnimalRequest;
import slaughterhouse.PackPartsRequest;
import slaughterhouse.Station3ServiceGrpc;
import slaughterhouse.domain.HalfAnAnimal;

import java.sql.SQLOutput;
import java.util.ArrayList;
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
      System.out.println("Do you want to: \n 1) Pack a product \n 2) Pack Half-An-Animal");
      int switchNumber = keyboard.nextInt();
      keyboard.nextLine();
      switch(switchNumber)
      {
        case 1:
          ArrayList<Integer> idsCase1 = new ArrayList<>();
          boolean addingCase1 = true;
          while (addingCase1)
          {
            System.out.print("Enter the ID of part: ");
            int idCase1 = keyboard.nextInt();
            if (idCase1 == -1)
            {
              addingCase1 = false;
              break;
            }
            idsCase1.add(idCase1);
          }
          System.out.print("Enter the type of the part: ");
          String animalPartTypeCase1 = keyboard.nextLine();

          PackPartsRequest packPartsRequest = PackPartsRequest.newBuilder().addAllId(idsCase1).setType(animalPartTypeCase1).setNumber(idsCase1.size()).build();

          System.out.println("Packing the products, please wait...");
          station3Stub.packParts(packPartsRequest);
          break;

        case 2:
          System.out.println("When you are done adding, please type -1");
          boolean addingCase2 = true;
          ArrayList<Integer> idsCase2 = new ArrayList<>();
          while (addingCase2)
          {
            System.out.print("Enter the ID of part: ");
            int idCase2 = keyboard.nextInt();
            if (idCase2 == -1)
            {
              addingCase2 = false;
              break;
            }
            idsCase2.add(idCase2);
          }
          HalfAnAnimalRequest halfAnAnimalRequest = HalfAnAnimalRequest.newBuilder().addAllId(idsCase2).build();
          System.out.println("Packing Half-An-Animal, please wait...");
          station3Stub.halfAnAnimal(halfAnAnimalRequest);
        }
      }
      keyboard.close();
      managedChannel.shutdown();

    }
}