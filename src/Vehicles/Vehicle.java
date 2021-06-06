package Vehicles;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;


public abstract class Vehicle {

    protected double[] position;
    protected int vector_direction;
    protected double max_speed;
    //int visibility = 3;//na razie tu potem do kalsy mapa
    private double speed = 0;
    private int time =1;
    protected int angle_degree;
    protected double angle_radian;
    private Driver driver;
    private boolean turning;
    Random rnd= new Random();

    public Vehicle(double[] position, double max_speed, int angle) {
        this.position=position;
        this.max_speed =max_speed;
        this.angle_degree=angle;
        angle_radian =Math.toRadians(angle_degree);
        vector_direction=(angle_degree%180==0)?0:1;
        this.driver = new Driver(position,angle);
    }

    public void paintView(Graphics window){
        driver.paintView(window);
        driver.dontPaintThisView(window);
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
        position[0] += 40*Math.cos(angle_radian);
        position[1] += -40*Math.sin(angle_radian);
        angle_degree += 90;
        angle_radian =Math.toRadians(angle_degree);
    }

    public void turnRight(){
        vector_direction=(angle_degree%180==0)?1:0;
        position[0] += 10*Math.cos(angle_radian);
        position[1] += -10*Math.sin(angle_radian);
        angle_degree -= 90;
        angle_radian =Math.toRadians(angle_degree);
    }

    public void drive( ArrayList<Car> cars, ArrayList<Motor> motors, int CAR_AMOUNT, int MOTOR_AMOUNT){
        if(driver.isSeeingAnything(this.position,cars,motors,CAR_AMOUNT,MOTOR_AMOUNT)){
            slowDown();
        } else {
            accelerate();
        }
        if(driver.isOnIntersection(this.position) == false) {turning = false;}
        if (turning == false && driver.isOnIntersection(this.position)){

            int random = rnd.nextInt(3);
            switch (random){
            case 0: {
                turnRight();
                turning = true;
                break;
            }
            case 1:{
                turnLeft();
                turning = true;
                break;
            }
            case 2:{
                turning = true;
                break;
            }}

       // if(time%100==0) {
      //      turnRight();
      //  }

    }}

    public void drive(int FRAME_WIDTH,int FRAME_HEIGHT){

        if(vector_direction==1){
            position[vector_direction]=(position[vector_direction]+speed)%(FRAME_HEIGHT);
            if(position[vector_direction]<0){position[vector_direction]=FRAME_HEIGHT;}
        } else{
            position[vector_direction]=(position[vector_direction]+speed)%(FRAME_WIDTH-FRAME_WIDTH/3);
            if(position[vector_direction]<0){position[vector_direction]=FRAME_WIDTH-FRAME_WIDTH/3;}
        }
        driver.setActualPosition(getPosition(),getAngle_degree());
        time++;
    }



}
