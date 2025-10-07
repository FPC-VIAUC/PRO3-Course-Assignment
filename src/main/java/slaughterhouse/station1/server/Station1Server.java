package slaughterhouse.station1.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class Station1Server{
  public static void main(String[] args) throws Exception{
    Server server = ServerBuilder
        .forPort(9091)
        .addService(new Station1ServiceImpl())
        .build();

    server.start();
    server.awaitTermination();
  }
}
