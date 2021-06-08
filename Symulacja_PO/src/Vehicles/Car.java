package Vehicles;

import java.awt.*;

public class Car extends Vehicle {

    private final int CAR_SIZE = 12;

    public Car(double[] position, double max_speed, int angle) {
        super(position, max_speed, angle);
    }

    public void paintVehicle(Graphics vehicle_model){
        vehicle_model.setColor(new Color(76, 18, 18));
        vehicle_model.fillRect((int) position[0]-CAR_SIZE/2,(int) position[1]-CAR_SIZE/2,CAR_SIZE,CAR_SIZE);
    }


}
