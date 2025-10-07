package slaughterhouse.station2.sever;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class Station2Server{
  public static void main(String[] args) throws Exception{
    Server server = ServerBuilder
        .forPort(9092)
        .addService(new Station2ServiceImpl())
        .build();

    server.start();
    server.awaitTermination();
  }
}
