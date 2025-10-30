package slaughterhouse.databaseserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import slaughterhouse.domain.Animal;

import java.util.List;

@RestController
public class WebAPI{
  @Autowired
  private DatabaseDAO dao;

  @GetMapping("/animals")
  public ResponseEntity<List<Animal>> getAnimals(){
    List<Animal> allAnimals = dao.getAnimals();
    return new ResponseEntity<List<Animal>>(allAnimals, HttpStatus.OK);
  }
}
