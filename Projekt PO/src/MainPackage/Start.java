package MainPackage;

import Vehicles.Car;
import Vehicles.SpawnPoint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Start extends JPanel implements ActionListener {

    private final int FRAME_HIGHT = 800;
    private final int FRAME_WIDTH = 1500;
    private final int CAR_AMOUNT = 20;

    double time = 0;

    ArrayList<Car> cars = new ArrayList<>();

    public Start() {

        JFrame frame = new JFrame("Symulacja");
        frame.setSize(FRAME_WIDTH,FRAME_HIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.cyan);
        frame.setResizable(false);

        SpawnPoint.create_vehicle(cars,CAR_AMOUNT);

        Timer timer = new Timer(40,this);
        timer.restart();

        frame.add(this);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        time++;
    }

    public void paint(Graphics window){

        super.paintComponent(window);

        SpawnPoint.spawn_vehicle(window,cars,FRAME_WIDTH);


        window.setColor(Color.black);
        window.drawLine(FRAME_WIDTH-FRAME_WIDTH/3, 0, FRAME_WIDTH-FRAME_WIDTH/3, FRAME_HIGHT);
        window.setColor(new Color(200, 207, 218));
        window.fillRect(FRAME_WIDTH-FRAME_WIDTH/3, 0, FRAME_WIDTH/3,FRAME_HIGHT);
        window.setColor(Color.black);
        window.drawString("Cars: "+   "   Time: " + time , FRAME_WIDTH-FRAME_WIDTH/3+30, 30);
        window.drawString("Collisions: ", FRAME_WIDTH-FRAME_WIDTH/3+30, 45);
        }


}

