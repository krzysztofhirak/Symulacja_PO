package Environment;

import java.awt.*;

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
         for(int j=0; j<4; j++){
             intersection.fillRect(70+i*200, 70+j*200, 60, 60);
         }
     }

 }





}
