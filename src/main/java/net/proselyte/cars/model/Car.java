package net.proselyte.cars.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "car")
@Getter
@Setter
@ToString
public class Car extends BaseEntity{

    @Column(name = "name")
    private String carName;

    @Column(name = "model")
    private String model;

    @Column(name = "price")
    private int price;


    @Override
    public boolean equals(Object o){
        if(this==o){
            return true;
        }
        if(!(o instanceof Car)){
            return false;
        }

        Car car = (Car) o;

        return Objects.equals(this.carName, car.carName) && Objects.equals(this.model, car.model)
                &&Objects.equals(this.getId(), car.getId()) &&Objects.equals(this.price, car.price);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.getId(), this.carName, this.model, this.price);
    }

    @Override
    public String toString(){
        return "Car {"+"id="+this.getId() + ", name = " + this.carName + ", model= "
                + this.model + ", price= " + this.price + "}";
    }


}
