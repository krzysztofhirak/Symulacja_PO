package Vehicles;

import java.awt.*;

public abstract class Vehicles {

    protected final int FOV = 8;//Field Of View
    private final int VEHICLE_SIZE = 12;

    protected double[] position;
    protected int vector_direction;
    protected double max_speed;
    //int visibility = 3;//na razie tu potem do kalsy mapa
    private double speed = 0;
    private int time =1;
    protected int angle_degree;
    protected double angle_radian;

    public void paintView(Graphics field_of_view){
        field_of_view.setColor(new Color(255, 0, 0, 106));
        field_of_view.drawArc((int) position[0]-(VEHICLE_SIZE /2)* FOV,(int) position[1]-(VEHICLE_SIZE /2)* FOV, VEHICLE_SIZE * FOV, VEHICLE_SIZE * FOV, (angle_degree+45)%360,-90);
        field_of_view.fillArc((int) position[0]-(VEHICLE_SIZE /2)* FOV,(int) position[1]-(VEHICLE_SIZE /2)* FOV, VEHICLE_SIZE * FOV, VEHICLE_SIZE * FOV, (angle_degree+45)%360,-90);
    }

    public void dontPaintThisView(Graphics front_filed_of_view){
        front_filed_of_view.setColor(new Color(169, 241, 154, 141));
        switch (angle_degree % 360) {
            case 0 -> {
                front_filed_of_view.fillRect((int) (position[0]), (int) (position[1] - VEHICLE_SIZE * FOV / 8), VEHICLE_SIZE * FOV / 2, VEHICLE_SIZE * FOV / 4);
            }
            case 90,-270 -> {
                front_filed_of_view.fillRect((int) (position[0] - VEHICLE_SIZE * FOV / 8), (int) (position[1] - VEHICLE_SIZE * FOV/2 ), VEHICLE_SIZE * FOV / 4, VEHICLE_SIZE * FOV / 2);
            }
            case 180,-180 -> {
                front_filed_of_view.fillRect((int) (position[0] - VEHICLE_SIZE * FOV/2 ), (int) (position[1] - VEHICLE_SIZE * FOV / 8), VEHICLE_SIZE * FOV / 2, VEHICLE_SIZE * FOV / 4);
            }
            case 270,-90 -> {
                front_filed_of_view.fillRect((int) (position[0] - VEHICLE_SIZE * FOV / 8), (int) (position[1]), VEHICLE_SIZE * FOV / 4, VEHICLE_SIZE * FOV / 2);
            }
        }
    }

    public double[] getPosition() {
        return position;
    }

    public int getAngle_degree() {
        return angle_degree;
    }

    public void accelerate(){
        speed = max_speed*(Math.cos(angle_radian)-Math.sin(angle_radian));
    }

    public void slowDown(){
        speed =0;
    }

    public void turnLeft(){
        vector_direction=(angle_degree%180==0)?1:0;
        angle_degree += 90;
        angle_radian =Math.toRadians(angle_degree);
    }

    public void turnRight(){
        vector_direction=(angle_degree%180==0)?1:0;
        angle_degree -= 90;
        angle_radian =Math.toRadians(angle_degree);
    }

    public void drive(int FRAME_WIDTH,int FRAME_HEIGHT){
        accelerate();
        //if(time%20==0) turnLeft();
        if(vector_direction==1){
            position[vector_direction]=(position[vector_direction]+speed)%(FRAME_HEIGHT);
            if(position[vector_direction]<0){position[vector_direction]=FRAME_HEIGHT;}
        } else{
            position[vector_direction]=(position[vector_direction]+speed)%(FRAME_WIDTH-FRAME_WIDTH/3);
            if(position[vector_direction]<0){position[vector_direction]=FRAME_WIDTH-FRAME_WIDTH/3;}
        }

        time++;
    }

    public void doVeryImportantStuffLikeSlowDownWhenYouSeeCar(double posision_of_some_car) {

    }
}
