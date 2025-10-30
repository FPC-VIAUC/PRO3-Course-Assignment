package slaughterhouse.databaseserver;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DataBaseServer{
  private static DatabaseDAO dao = new ArrayDatabase();

  public static void main(String[] args) throws Exception{
    Thread grpcServer = new Thread(() -> {
      Server server = ServerBuilder
          .forPort(9090)
          .addService(new Station1ServiceImpl(dao))
          .addService(new Station2ServiceImpl(dao))
          .addService(new Station3ServiceImpl(dao))
          .addService(new SlaughterHouseServiceImpl(dao))
          .build();

      try{
        server.start();
        server.awaitTermination();
      } catch(Exception e){
        throw new RuntimeException(e.getMessage());
      }
    });
    grpcServer.start();

    SpringApplication.run(DataBaseServer.class, args);
  }

  @Bean
  public DatabaseDAO dao(){
    return dao;
  }
}
