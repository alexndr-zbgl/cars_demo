package net.proselyte.cars.service;
import lombok.extern.slf4j.Slf4j;
import net.proselyte.cars.model.Car;
import net.proselyte.cars.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CarServiceImpl implements CarService{

    @Autowired
    CarRepository carRepository;

    @Override
    public Car getById(Long id) {
        Optional <Car> optional = carRepository.findById(id);

        Car car = null;

        if(optional.isPresent()){
            car = optional.get();
        }
        else{
            throw new RuntimeException(" Car not found for id : " + id);
        }

        return car;
    }


    @Override
    public void saveCar(Car car) {
        this.carRepository.save(car);
    }

    @Override
    public void delete(Long id) {
        this.carRepository.deleteById(id);
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public List<Car> getFilterCars(String keyword){
        List<Car> optionalCar = carRepository.findAll();

        List<Car> car = null;

        if(keyword!=null){
            car.add((Car) optionalCar.stream().filter(e -> e.getCarName().equals(keyword)));
            return car;
        }
        else{
            return carRepository.findAll();
        }
    }

}
