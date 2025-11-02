package slaughterhouse.databaseserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import slaughterhouse.domain.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class WebAPI{
  @Autowired
  private DatabaseDAO dao;


  @GetMapping("/animals")
  public ResponseEntity<List<Animal>> getAnimals(@RequestParam(value = "origin", required = false) String origin, @RequestParam(value = "date", required = false) String date){
    List<Animal> allAnimals = dao.getAnimals();

    List<Animal> filteredAnimals = allAnimals.stream()
        .filter(animal -> origin == null || animal.getOrigin().equalsIgnoreCase(origin))
        .filter(animal -> date == null || animal.getDate().toString().equals(date))
        .toList();
    return new ResponseEntity<List<Animal>>(filteredAnimals, HttpStatus.OK);
  }

  @GetMapping("/animals/{id}")
  public ResponseEntity<Animal> getAnimal(@PathVariable int id)
  {
    return new ResponseEntity<Animal> (dao.getAnimal(id), HttpStatus.OK);
  }
}
