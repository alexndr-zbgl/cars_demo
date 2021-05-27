package net.proselyte.cars.rest;

public class CarNotFoundException extends RuntimeException {
    CarNotFoundException(Long id){
        super("Cannot find car with id = " + id);
    }
}
