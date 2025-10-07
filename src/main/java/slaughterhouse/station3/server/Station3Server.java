package slaughterhouse.station3.server;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import slaughterhouse.Station3ServiceGrpc;

public class Station3Server{
  public static void main(String[] args) throws Exception{
    ManagedChannel managedChannel = ManagedChannelBuilder.
        forAddress("localhost", 9090).
        usePlaintext().
        build();
    Station3ServiceGrpc.Station3ServiceBlockingStub databaseStub = Station3ServiceGrpc.newBlockingStub(managedChannel);

    Server server = ServerBuilder
        .forPort(9093)
        .addService(new Station3ServiceImpl(databaseStub))
        .build();

    server.start();
    server.awaitTermination();
    managedChannel.shutdown();
  }
}
