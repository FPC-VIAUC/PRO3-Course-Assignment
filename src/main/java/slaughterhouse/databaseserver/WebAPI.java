package slaughterhouse.databaseserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import slaughterhouse.domain.Animal;

import java.util.ArrayList;
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

  @GetMapping("/animals")
  public ResponseEntity<List<Animal>> getAnimalsByOrigin(@RequestParam("origin") String origin){
    List<Animal> animals = new ArrayList<>();

    for (Animal animal : dao.getAnimals()) {
      if(animal.getOrigin().equalsIgnoreCase(origin)){
        animals.add(animal);
      }
    }
    return new ResponseEntity<List<Animal>> (animals, HttpStatus.OK);
  }

  @GetMapping("/animals")
  public ResponseEntity<List<Animal>> getAnimalsFromDate(@RequestParam("date") String date){
    List<Animal> animalsFromDate = new ArrayList<>();
    for (Animal animal : dao.getAnimals())
        {
          if (animal.getDate().toString().equals(date))
            animalsFromDate.add(animal);
        }
    return new ResponseEntity (animalsFromDate, HttpStatus.OK);
  }
}
