package net.proselyte.cars.service;

import net.proselyte.cars.model.Car;

import java.util.List;

public interface CarService {
    Car getById(Long id);

    void saveCar(Car car);

    void delete(Long id);

    List<Car> getAllCars();

    List<Car> getFilterCars(String keyword);
}
