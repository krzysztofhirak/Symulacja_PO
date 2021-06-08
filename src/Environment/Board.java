package Environment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Board {

    public static void paintRoad(Graphics road ){
        road.setColor(new Color(0x252F2F2F, true));
        int StartPoint=70;
        for (int i=0; i<4; i++) {
            road.fillRect(StartPoint+i*200, 0, 60, 800);
        }
        for(int i=0; i<4; i++){
            road.fillRect(0, StartPoint+i*200, 800, 60);
        }
    }

    public static void paintIntersection(Graphics intersection){
        intersection.setColor(new Color(0x6876762A, true));
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++) {
                intersection.fillRect(70 + i * 200, 70 + j * 200, 60, 60);
            }
        }
 }

    public static void spawnLights(){

    }

    public static void paintLights(Graphics lights, double time){
//        Timer timer = new Timer(17, (ActionListener) this);
//        timer.restart();

        if(time % 600 < 200){
            lights.setColor(Color.RED);
//            daWey = 1;
        }
        else if(time % 600 < 400){
            lights.setColor(Color.YELLOW);
//            daWey = 2;
        }
        else {
            lights.setColor(Color.GREEN);
//            daWey = 3;
        }

        lights.fillOval(290,290,20,20);
        lights.fillOval(690,490,20,20);
        lights.fillOval(490,90,20,20);
        lights.fillOval(90,690,20,20);
    }

}
