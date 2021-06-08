package MainPackage;

import Environment.Board;
import Vehicles.Car;
import Vehicles.Motor;
import Vehicles.SpawnPoint;
import Vehicles.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Start extends JPanel implements ActionListener {

    private final int FRAME_HEIGHT = 800;
    private final int FRAME_WIDTH = 1200;
    private final int CAR_AMOUNT = 10;
    private final int MOTOR_AMOUNT = 5;
    public double max_speed = 0;
    double time = 0;

    ArrayList<Car> cars = new ArrayList<>();
    ArrayList<Motor> motors = new ArrayList<>();

    JFrame frame = new JFrame("Symulacja");

    JTextField carAmount = new JTextField();
    JButton buttonSlow = new JButton("Slow");
    JButton buttonMedium = new JButton("Medium");
    JButton buttonFast = new JButton("Fast");

//    JPanel panel = new JPanel();

//    String carAmountInput = "";

    public Start() {

        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.cyan);
        frame.setResizable(false);

        SpawnPoint.createVehicle(cars,motors,CAR_AMOUNT,MOTOR_AMOUNT);

        Timer timer = new Timer(17,this);
        timer.restart();

        frame.add(this);
        frame.setVisible(true);

    }

    public void paint(Graphics window) {

//        frame.setBounds(100, 100, 1000, 1000);
//        panel.setBackground(new Color(210, 217, 228));
//        panel.setBorder(null);
//        panel.setVisible(true);
//        frame.add(panel);

        paintButtons(window);
        paintSimulation(window);

        Vehicle.saveToCSV(cars, motors, time, CAR_AMOUNT, MOTOR_AMOUNT);

        time++;
    }

    public void paintSimulation(Graphics g){
        super.paintComponent(g);

        SpawnPoint.spawnVehicle(g, cars, motors, FRAME_WIDTH, FRAME_HEIGHT, CAR_AMOUNT, MOTOR_AMOUNT);

        Board.paintRoad(g);
        Board.paintIntersection(g);
//        Board.paintLights(g, time);

        g.setColor(Color.black);
        g.drawLine(FRAME_WIDTH - FRAME_WIDTH / 3, 0, FRAME_WIDTH - FRAME_WIDTH / 3, FRAME_HEIGHT);
        g.setColor(new Color(200, 207, 218));
        g.fillRect(FRAME_WIDTH - FRAME_WIDTH / 3, 0, FRAME_WIDTH / 3, FRAME_HEIGHT);
        g.setColor(Color.black);
        g.drawString("Cars: " + "   Time: " + time, FRAME_WIDTH - FRAME_WIDTH / 3 + 30, 30);
//        window.drawString("Collisions: ", FRAME_WIDTH - FRAME_WIDTH / 3 + 30, 45);
        g.drawString(String.format("Car max speed: %.2f",Math.abs(max_speed)), 950, 70);
    }

    public void paintButtons(Graphics h){
//        panel.paint(h);

        buttonSlow.setBounds(820,130,90,25);
        this.add(buttonSlow);
        buttonSlow.addActionListener(this);
        buttonSlow.setVisible(true);

        buttonMedium.setBounds(920,130,90,25);
        this.add(buttonMedium);
        buttonMedium.addActionListener(this);
        buttonMedium.setVisible(true);

        buttonFast.setBounds(1020,130,90,25);
        this.add(buttonFast);
        buttonFast.addActionListener(this);
        buttonFast.setVisible(true);

        carAmount.setBounds(820, 90, 50, 25);
        this.add(carAmount);
        carAmount.addActionListener(this);
        carAmount.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();

        if(e.getSource()== buttonSlow){
            for(int i = 0; i < CAR_AMOUNT; i++){
                cars.get(i).setMaxSpeed(1.5);
            }
            for(int i = 0; i < MOTOR_AMOUNT; i++){
                motors.get(i).setMaxSpeed(2);
            }
        }

        if(e.getSource()== buttonMedium){
            for(int i = 0; i < CAR_AMOUNT; i++){
                cars.get(i).setMaxSpeed(2.5);
            }
            for(int i = 0; i < MOTOR_AMOUNT; i++){
                motors.get(i).setMaxSpeed(4);
            }
        }

        if(e.getSource()== buttonFast){
            for(int i = 0; i < CAR_AMOUNT; i++){
                cars.get(i).setMaxSpeed(4);
            }
            for(int i = 0; i < MOTOR_AMOUNT; i++){
                motors.get(i).setMaxSpeed(6);
            }
        }

//        if(e.getSource()== carAmount){
//            carAmountInput = carAmount.getText();
//            int carInputNumber=Integer.parseInt(carAmountInput);
////            for(int i=0;i<carInputNumber;i++){
////                double[] start_point = {290,790};
////                cars.add(new Car(start_point,Math.random()*4+3,(90)));
////            }
//        }
    }

}