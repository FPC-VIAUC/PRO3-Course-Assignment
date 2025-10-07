package slaughterhouse.station2.sever;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import slaughterhouse.station2.sever.Station2ServiceImpl;

public class Station2Server
{
  public static void main(String[] args) throws Exception{
    Server server = ServerBuilder
        .forPort(9090)
        .addService(new Station2ServiceImpl())
        .build();

    server.start();
    server.awaitTermination();
  }

}
