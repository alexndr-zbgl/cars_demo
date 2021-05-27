package net.proselyte.cars.rest;

import net.proselyte.cars.model.Car;
import net.proselyte.cars.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarService carRepository;

    CarController(CarService carRepository){
        this.carRepository = carRepository;
    }

    @RequestMapping(value = {"/cars"}, method = RequestMethod.GET)
    public String homePage(){
        return "homePage";
    }

    @GetMapping("/cars/listOfCars")
    public String getListOfCars(Model model){
        model.addAttribute("listCars", carRepository.getAllCars());
        return "cars";
    }

    @GetMapping("/cars/newCarForm")
    public String showNewCarForm(Model model){
        Car car = new Car();
        model.addAttribute("car", car);
        return "newCar";
    }

    @PostMapping("/saveCar")
    public String saveCar(@ModelAttribute("car") Car car){
        carRepository.saveCar(car);
        return "savedSuccessfully";
    }

    @GetMapping("/updateForm/{id}")
    public String updateForm(@PathVariable(value = "id") long id, Model model){
        Car car = carRepository.getById(id);
        model.addAttribute("car", car);
        return "updateCar";
    }

    @GetMapping("/deleteCar/{id}")
    public String deleteCar(@PathVariable(value = "id") long id){
        this.carRepository.delete(id);
        return "deleted";
    }

    @GetMapping("/findById/{id}")
    public String findByIdForm(@PathVariable(value = "id") long id, Model model){
        Car car = carRepository.getById(id);
        model.addAttribute("car", car);
        return "findById";
    }

    @GetMapping("/cars/search")
    public String search(Model model, @Param("keyword") String keyword){
        List<Car> car = carRepository.getFilterCars(keyword);
        model.addAttribute("keyword", keyword);
        return "search";
    }
}
