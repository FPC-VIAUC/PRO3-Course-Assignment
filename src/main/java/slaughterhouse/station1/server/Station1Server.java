package slaughterhouse.station1.server;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import slaughterhouse.Station1ServiceGrpc;

public class Station1Server{
  public static void main(String[] args) throws Exception{
    ManagedChannel managedChannel = ManagedChannelBuilder
        .forAddress("localhost", 9090)
        .usePlaintext()
        .build();
    Station1ServiceGrpc.Station1ServiceBlockingStub databaseStub = Station1ServiceGrpc.newBlockingStub(managedChannel);

    Server server = ServerBuilder
        .forPort(9091)
        .addService(new Station1ServiceImpl(databaseStub))
        .build();

    server.start();
    server.awaitTermination();
    managedChannel.shutdown();
  }
}
