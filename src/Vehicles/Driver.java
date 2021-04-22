package Vehicles;

import java.awt.*;
import java.util.ArrayList;

public class Driver {

    private final int FOV = 120;//Field Of View

    private double[] actual_position;
    private int actual_angle_degree;
    private int angle_case;
    private int entity;

    public Driver(double[] actual_position, int actual_angle_degree) {
        this.actual_position = actual_position;
        this.actual_angle_degree = actual_angle_degree;
    }

    public void setActualPosition(double[] actual_position, int actual_angle_degree) {
        this.actual_position = actual_position;
        this.actual_angle_degree = actual_angle_degree;
    }

    public void paintView(Graphics field_of_view) {
        field_of_view.setColor(new Color(255, 0, 0, 0));
        field_of_view.drawArc((int) actual_position[0] - (FOV / 2), (int) actual_position[1] - FOV / 2, FOV, FOV, (actual_angle_degree + 30) % 360, -60);
        field_of_view.fillArc((int) actual_position[0] - (FOV / 2), (int) actual_position[1] - FOV / 2, FOV, FOV, (actual_angle_degree + 30) % 360, -60);
    }

    public void dontPaintThisView(Graphics front_filed_of_view) {
        front_filed_of_view.setColor(new Color(169, 241, 154, 169));
        switch (actual_angle_degree % 360) {
            case 0 -> {
                front_filed_of_view.fillRect((int) (actual_position[0]), (int) (actual_position[1] - FOV / 8), FOV / 2, FOV / 4);
                angle_case = 0;
            }
            case 90, -270 -> {
                front_filed_of_view.fillRect((int) (actual_position[0] - FOV / 8), (int) (actual_position[1] - FOV / 2), FOV / 4, FOV / 2);
                angle_case = 1;
            }
            case 180, -180 -> {
                front_filed_of_view.fillRect((int) (actual_position[0] - FOV / 2), (int) (actual_position[1] - FOV / 8), FOV / 2, FOV / 4);
                angle_case = 2;
            }
            case 270, -90 -> {
                front_filed_of_view.fillRect((int) (actual_position[0] - FOV / 8), (int) (actual_position[1]), FOV / 4, FOV / 2);
                angle_case = 3;
            }
        }
    }


    public boolean isSeeingAnything(double[] this_vehicles_position, ArrayList<Car> cars, ArrayList<Motor> motors, int CAR_AMOUNT, int MOTOR_AMOUNT) {
        entity = 0;
        for (int i = 0; i < CAR_AMOUNT; i++) {
            if ((angle_case == 0) &&
                            ((this_vehicles_position[0] < cars.get(i).getPosition()[0]) && (cars.get(i).getPosition()[0] < this_vehicles_position[0] + FOV / 2)) &&
                            ((this_vehicles_position[1] - FOV / 8 < cars.get(i).getPosition()[1]) && (cars.get(i).getPosition()[1] < this_vehicles_position[1] + FOV / 8)) ||
                    (angle_case == 1) &&
                            ((this_vehicles_position[0] - FOV / 8 < cars.get(i).getPosition()[0]) && (cars.get(i).getPosition()[0] < this_vehicles_position[0] + FOV / 8)) &&
                            ((this_vehicles_position[1] > cars.get(i).getPosition()[1]) && (cars.get(i).getPosition()[1] > this_vehicles_position[1] - FOV / 2)) ||
                    (angle_case == 2) &&
                            ((this_vehicles_position[0] > cars.get(i).getPosition()[0]) && (cars.get(i).getPosition()[0] > this_vehicles_position[0] - FOV / 2)) &&
                            ((this_vehicles_position[1] - FOV / 8 < cars.get(i).getPosition()[1]) && (cars.get(i).getPosition()[1] < this_vehicles_position[1] + FOV / 8)) ||
                    (angle_case == 3) &&
                            ((this_vehicles_position[0] - FOV / 8 < cars.get(i).getPosition()[0]) && (cars.get(i).getPosition()[0] < this_vehicles_position[0] + FOV / 8)) &&
                            ((this_vehicles_position[1] < cars.get(i).getPosition()[1]) && (cars.get(i).getPosition()[1] < this_vehicles_position[1] + FOV / 2))
            ) {
                entity++;
            }
        }
        for (int i = 0; i < MOTOR_AMOUNT; i++){
            if ((angle_case == 0) &&
                            ((this_vehicles_position[0] < motors.get(i).getPosition()[0]) && (motors.get(i).getPosition()[0] < this_vehicles_position[0] + FOV / 2)) &&
                            ((this_vehicles_position[1] - FOV / 8 < motors.get(i).getPosition()[1]) && (motors.get(i).getPosition()[1] < this_vehicles_position[1] + FOV / 8)) ||
                    (angle_case == 1) &&
                            ((this_vehicles_position[0] - FOV / 8 < motors.get(i).getPosition()[0]) && (motors.get(i).getPosition()[0] < this_vehicles_position[0] + FOV / 8)) &&
                            ((this_vehicles_position[1] > motors.get(i).getPosition()[1]) && (motors.get(i).getPosition()[1] > this_vehicles_position[1] - FOV / 2)) ||
                    (angle_case == 2) &&
                            ((this_vehicles_position[0] > motors.get(i).getPosition()[0]) && (motors.get(i).getPosition()[0] > this_vehicles_position[0] - FOV / 2)) &&
                            ((this_vehicles_position[1] - FOV / 8 < motors.get(i).getPosition()[1]) && (motors.get(i).getPosition()[1] < this_vehicles_position[1] + FOV / 8)) ||
                    (angle_case == 3) &&
                            ((this_vehicles_position[0] - FOV / 8 < motors.get(i).getPosition()[0]) && (motors.get(i).getPosition()[0] < this_vehicles_position[0] + FOV / 8)) &&
                            ((this_vehicles_position[1] < motors.get(i).getPosition()[1]) && (motors.get(i).getPosition()[1] < this_vehicles_position[1] + FOV / 2))
            ) {
                entity++;
            }
        }
        return (entity > 0);
    }

}