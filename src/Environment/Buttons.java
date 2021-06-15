package Environment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buttons extends JPanel implements ActionListener {

    public Buttons(){
        JLabel label = new JLabel("Jakiś tekst");
        label.setBounds(820, 130, 160,25);

        JTextField textfield = new JTextField();
        textfield.setBounds(820, 70, 160, 25);

        JButton button = new JButton("Apply");
        button.setBounds(820,100,80,25);
    }

    public void paint(Graphics buttons) {

        super.paintComponent(buttons);

        JLabel label = new JLabel("XDDD");
        label.setBounds(20, 20, 160,25);
        this.add(label);

        JTextField textfield = new JTextField();
        textfield.setBounds(20, 20, 160, 25);
        super.add(textfield);
        textfield.addActionListener(this);

        JButton button = new JButton("Apply");
        button.setBounds(20,20,80,25);
        super.add(button);
        button.addActionListener(this);
        button.setVisible(true);

        buttons.drawString("SAMPLE TEXT", 50,50);
    }

    public void button1(Graphics buttons){
        JLabel label = new JLabel("XDDD");
        label.setBounds(820, 70, 160,25);
        super.add(label);

        JTextField textfield = new JTextField();
        textfield.setBounds(820, 100, 160, 25);
        super.add(textfield);
        textfield.addActionListener(this);

        JButton button = new JButton("Apply");
        button.setBounds(820,130,80,25);
        super.add(button);
        button.addActionListener(this);
        button.setVisible(true);

        buttons.drawString("SAMPLEEEEEEEEEE", 50,50);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}