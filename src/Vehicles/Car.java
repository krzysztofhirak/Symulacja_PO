package Vehicles;

import java.awt.*;

public class Car extends Vehicles {

    private final int CAR_SIZE = 12;

    public Car(double[] position, double max_speed, int angle) {
        super.position=position;
        super.max_speed =max_speed;
        super.angle_degree=angle;
        angle_radian =Math.toRadians(angle_degree);
        vector_direction=(angle_degree%180==0)?0:1;
    }

    public void paintVehicle(Graphics vehicle_model){
        vehicle_model.setColor(new Color(76, 18, 18));
        vehicle_model.fillRect((int) position[0]-CAR_SIZE/2,(int) position[1]-CAR_SIZE/2,CAR_SIZE,CAR_SIZE);
    }

    public void paintView(Graphics field_of_view){
        field_of_view.setColor(new Color(255, 0, 0, 106));
        field_of_view.drawArc((int) position[0]-(CAR_SIZE /2)* FOV,(int) position[1]-(CAR_SIZE /2)* FOV, CAR_SIZE * FOV, CAR_SIZE * FOV, (angle_degree+45)%360,-90);
        field_of_view.fillArc((int) position[0]-(CAR_SIZE /2)* FOV,(int) position[1]-(CAR_SIZE /2)* FOV, CAR_SIZE * FOV, CAR_SIZE * FOV, (angle_degree+45)%360,-90);
    }





}
