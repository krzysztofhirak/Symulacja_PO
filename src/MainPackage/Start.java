package MainPackage;

import Environment.Board;
import Vehicles.Car;
import Vehicles.Driver;
import Vehicles.Motor;
import Vehicles.SpawnPoint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Start extends JPanel implements ActionListener {

    private final int FRAME_HEIGHT = 800;
    private final int FRAME_WIDTH = 1200;
    private final int CAR_AMOUNT = 1;
    private final int MOTOR_AMOUNT = 0;

    double time = 0;

    ArrayList<Car> cars = new ArrayList<>();
    ArrayList<Motor> motors = new ArrayList<>();

    public Start(){

        JFrame frame = new JFrame("Symulacja");
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.cyan);
        frame.setResizable(false);


        SpawnPoint.createVehicle(cars,motors,CAR_AMOUNT,MOTOR_AMOUNT);

        Timer timer = new Timer(20,this);
        timer.restart();

        frame.add(this);
        frame.setVisible(true);
    }

    public void paint(Graphics window){

        super.paintComponent(window);

        SpawnPoint.spawnVehicle(window,cars,motors,FRAME_WIDTH, FRAME_HEIGHT,CAR_AMOUNT,MOTOR_AMOUNT);
        Board.paintRoad(window);
        Board.paintIntersection(window);
        window.setColor(Color.black);
        window.drawLine(FRAME_WIDTH-FRAME_WIDTH/3, 0, FRAME_WIDTH-FRAME_WIDTH/3, FRAME_HEIGHT);
        window.setColor(new Color(200, 207, 218));
        window.fillRect(FRAME_WIDTH-FRAME_WIDTH/3, 0, FRAME_WIDTH/3, FRAME_HEIGHT);
        window.setColor(Color.black);
        window.drawString("Cars: "+   "   Time: " + time , FRAME_WIDTH-FRAME_WIDTH/3+30, 30);
        window.drawString("Collisions: ", FRAME_WIDTH-FRAME_WIDTH/3+30, 45);

        }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        time++;
    }

}