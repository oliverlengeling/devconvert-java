import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Temp implements ActionListener {
    public static double current;

    JTextField input = new JTextField();
    JTextField output = new JTextField();
    double result;
    JFrame frame;
    DecimalFormat numFormat = new DecimalFormat("#.##");
    public char type;
    JButton refresh;
    JRadioButton cel = new JRadioButton("Celsius");
    JRadioButton fer = new JRadioButton("Fahrenheit");
    ButtonGroup group = new ButtonGroup();

    public static void main (String[] args) {
        new Temp();
    }

    Temp() {
        frame = new JFrame("DevConvert - Temp");

        refresh = new JButton("\uD83D\uDDD8");
        refresh.setBounds(215,10,70,50);
        refresh.setFocusable(false);
        refresh.addActionListener(this);

        input.setBounds(100,25,100,30);

        output.setBounds(75,100,150,30);
        output.setFocusable(false);


        cel.setBounds(60,63,70,20);
        cel.addActionListener(this);
        fer.setBounds(140,63,100,20);
        fer.addActionListener(this);

        group.add(cel);
        group.add(fer);

        //frame.add(refresh);
        frame.add(input);
        frame.add(output);
        frame.add(cel);
        frame.add(fer);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300,200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        thread.start();
    }

    public void cel () {

        current = Double.parseDouble(input.getText());
        result = (current - 32) * 5/9;
        output.setText(String.valueOf(result).concat("°C"));
        System.out.println(result);
    }

    public void fer() {
        current = Double.parseDouble(input.getText());
        result = (current * 9/5) + 32;
        output.setText(String.valueOf(result).concat("°F"));
        System.out.println(result);
    }

    Thread thread = new Thread(() -> {
        while (true) {
            try {
                switch (type) {
                    case 'c':
                        cel();
                        break;
                    case 'f':
                        fer();
                        break;
                }
            } catch (Exception e) {
                System.out.println("shit put a number in");
            }
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                System.out.println("error code what the fuck");
            }
        }
    });

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==cel) {
            type = 'c';
            System.out.println(type);
            cel();
        }
        if(e.getSource()==fer) {
            type = 'f';
            System.out.println(type);
            fer();
        }
        if (e.getSource()==refresh) {
            switch (type) {
                case 'c':
                    System.out.println(type);
                    cel();
                case 'f':
                    System.out.println(type);
                    fer();
                    thread.start();
            }
        }
    }
}
