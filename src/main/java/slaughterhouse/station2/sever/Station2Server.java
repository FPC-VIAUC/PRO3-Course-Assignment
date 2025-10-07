package slaughterhouse.station2.sever;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import slaughterhouse.Station2ServiceGrpc;

public class Station2Server{
  public static void main(String[] args) throws Exception{

    ManagedChannel managedChannel = ManagedChannelBuilder
        .forAddress("localhost", 9090)
        .usePlaintext()
        .build();
    Station2ServiceGrpc.Station2ServiceBlockingStub databaseStub = Station2ServiceGrpc.newBlockingStub(managedChannel);

    Server server = ServerBuilder
        .forPort(9092)
        .addService(new Station2ServiceImpl())
        .build();

    server.start();
    server.awaitTermination();
  }
}
