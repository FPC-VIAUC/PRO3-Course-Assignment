package slaughterhouse.station1.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import slaughterhouse.AnimalServiceImpl;

public class Station1Server{
  public static void main(String[] args) throws Exception{
    Server server = ServerBuilder
        .forPort(9090)
        .addService(new AnimalServiceImpl())
        .build();

    server.start();
    server.awaitTermination();
  }
}
