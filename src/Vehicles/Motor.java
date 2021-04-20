package Vehicles;

import java.awt.*;

public class Motor extends Vehicles{

    private final int MOTOR_SIZE = 6;

    public Motor(double[] position, double max_speed, int angle) {
        super.position=position;
        super.max_speed =max_speed;
        super.angle_degree=angle;
        angle_radian =Math.toRadians(angle_degree);
        vector_direction=(angle_degree%180==0)?0:1;
    }

    public void paintVehicle(Graphics vehicle_model){
        vehicle_model.setColor(new Color(14, 32, 92, 255));
        vehicle_model.fillRect((int) position[0]- MOTOR_SIZE /2,(int) position[1]- MOTOR_SIZE /2, MOTOR_SIZE, MOTOR_SIZE);
    }

}
