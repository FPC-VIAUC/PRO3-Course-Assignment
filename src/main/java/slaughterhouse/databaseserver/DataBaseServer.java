package slaughterhouse.databaseserver;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class DataBaseServer{
  public static void main(String[] args) throws Exception{
    DatabaseDAO dao = new ArrayDatabase();

    Server server = ServerBuilder
        .forPort(9090)
        .addService(new Station1ServiceImpl(dao))
        .addService(new Station2ServiceImpl(dao))
        .addService(new Station3ServiceImpl(dao))
        .build();

    server.start();
    server.awaitTermination();
  }
}
