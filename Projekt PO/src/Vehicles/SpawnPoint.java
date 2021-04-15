package Vehicles;

import java.awt.*;
import java.util.ArrayList;

public class SpawnPoint {

    public SpawnPoint() {
    }

    public static void create_vehicle(ArrayList<Car> car, int amount){
        for(int i=0;i<amount;i++){//to tutaj do przerobienia ale dopiero jak bedziemy wiedziec gdzie start
            double[] start_point = {Math.random()*800,Math.random()*800};
            car.add(new Car(start_point,(Math.random()*4+1),(int)(Math.random()*4)*90));
        }
    }

    public static void spawn_vehicle(Graphics window, ArrayList<Car> car, int FRAME_WIDTH) {
        for (Car car_model: car) {
            car_model.paint_view(window);
            car_model.paint(window);
            car_model.dont_paint_this_view(window);
            car_model.drive(FRAME_WIDTH);
        }
    }

}
