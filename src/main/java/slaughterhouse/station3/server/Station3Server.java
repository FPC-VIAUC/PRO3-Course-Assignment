package slaughterhouse.station3.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class Station3Server{
  public static void main(String[] args) throws Exception{
    Server server = ServerBuilder
        .forPort(9093)
        .addService(new Station3ServiceImpl())
        .build();

    server.start();
    server.awaitTermination();
  }
}
