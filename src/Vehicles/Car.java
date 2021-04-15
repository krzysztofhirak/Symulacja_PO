package Vehicles;

import java.awt.*;

public class Car {

   private final int FOV = 8;//Field Of View
   private final int CAR_SIZE = 12;

    final private double[] position;
    private int vector_direction;
    private final double maxspeed;//na razie maxspeed jest ustalana przy tworzeniu pojazdu ale poteme trzeba bedzie zmienic ja zalezec to bedzie np od rodzaju drogi
    int visibility = 3;//na razie tu potem do kalsy mapa
    private double speed = 1;
    private int time =1;
    private int angle_degree;
    private double angle_radian;


    public Car(double[] position,double max_speed,int angle) {
        this.position=position;
        this.maxspeed=max_speed;
        this.angle_degree=angle;
        angle_radian =Math.toRadians(angle_degree);
        vector_direction=(angle_degree%180==0)?0:1;
    }

    public void paint(Graphics vehicle_model){
    vehicle_model.setColor(new Color(0, 0, 0));
    vehicle_model.fillRect((int) position[0]-CAR_SIZE/2,(int) position[1]-CAR_SIZE/2,CAR_SIZE,CAR_SIZE);
    }

    public void paint_view(Graphics field_of_view){
        field_of_view.setColor(new Color(255, 0, 0, 0));
        field_of_view.drawArc((int) position[0]-(CAR_SIZE/2)* FOV,(int) position[1]-(CAR_SIZE/2)* FOV,CAR_SIZE* FOV,CAR_SIZE* FOV, (angle_degree+45)%360,-90);
        field_of_view.fillArc((int) position[0]-(CAR_SIZE/2)* FOV,(int) position[1]-(CAR_SIZE/2)* FOV,CAR_SIZE* FOV,CAR_SIZE* FOV, (angle_degree+45)%360,-90);
    }

    public void dont_paint_this_view(Graphics front_filed_of_view){
        front_filed_of_view.setColor(new Color(169, 241, 154, 141));
        switch (angle_degree % 360) {
            case 0 -> {
                front_filed_of_view.fillRect((int) (position[0]), (int) (position[1] - CAR_SIZE * FOV / 6), CAR_SIZE * FOV / 2, CAR_SIZE * FOV / 3);
            }
            case 90,-270 -> {
                front_filed_of_view.fillRect((int) (position[0] - CAR_SIZE * FOV / 6), (int) (position[1] - CAR_SIZE * FOV / 2), CAR_SIZE * FOV / 3, CAR_SIZE * FOV / 2);
            }
            case 180,-180 -> {
                front_filed_of_view.fillRect((int) (position[0] - CAR_SIZE * FOV / 2), (int) (position[1] - CAR_SIZE * FOV / 6), CAR_SIZE * FOV / 2, CAR_SIZE * FOV / 3);
            }
            case 270,-90 -> {
                front_filed_of_view.fillRect((int) (position[0] - CAR_SIZE * FOV / 6), (int) (position[1]), CAR_SIZE * FOV / 3, CAR_SIZE * FOV / 2);
            }
        }
    }

    public void acceleration(){
        speed = (maxspeed-1/(double)time)*(Math.cos(angle_radian)-Math.sin(angle_radian));
    }

    public void release(){
        speed =0;
    }

    public void turn_left(){
        vector_direction=(angle_degree%180==0)?1:0;
        angle_degree += 90;
        angle_radian =Math.toRadians(angle_degree);
    }

    public void turn_right(){
        vector_direction=(angle_degree%180==0)?1:0;
        angle_degree -= 90;
        angle_radian =Math.toRadians(angle_degree);
    }

    public void drive(int FRAME_WIDTH){
        //in_sight(this); to jest po to zebym pamietał ze tak sie da XDD
        acceleration();
        //release();
        position[vector_direction]=(position[vector_direction]+speed)%(FRAME_WIDTH-FRAME_WIDTH/3);
        if(position[vector_direction]<0){position[vector_direction]=FRAME_WIDTH-FRAME_WIDTH/3;}
        time++;
    }
}
