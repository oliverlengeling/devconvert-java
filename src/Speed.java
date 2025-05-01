import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Speed implements ActionListener {

    JTextField input;
    JTextField output;

    JRadioButton mph;
    JRadioButton kph;

    ButtonGroup buttonGroup = new ButtonGroup();

    DecimalFormat numberFormat = new DecimalFormat("#.00");

    JFrame frame;

    char type;

    double current;
    double result;

    Speed() {
        frame = new JFrame();

        input = new JTextField();
        input.setBounds(100,25,100,30);

        output = new JTextField();
        output.setBounds(100,100,100,30);
        output.setFocusable(false);

        mph = new JRadioButton("MPH");
        mph.setBounds(83,65,70,20);
        mph.setFocusable(false);
        mph.addActionListener(this);

        kph = new JRadioButton("KPH");
        kph.setBounds(165,65,70,20);
        kph.setFocusable(false);
        kph.addActionListener(this);

        buttonGroup.add(mph);
        buttonGroup.add(kph);

        frame.add(input);
        frame.add(output);
        frame.add(mph);
        frame.add(kph);

        frame.setTitle("DevConvert - Speed");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300,200);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void mph() {
        current = Double.parseDouble(input.getText());
        result = current * 0.621371;
        output.setText(String.valueOf(numberFormat.format(result).concat(" MPH")));
        System.out.println(result);
    }

    public void kph() {
        current = Double.parseDouble(input.getText());
        result = current * 1.60934;
        output.setText(String.valueOf(numberFormat.format(result).concat(" KPH")));
        System.out.println(result);
    }

    Thread thread = new Thread(() -> {
        while(true) {
            try {
                switch(type) {
                    case 'm':
                        mph();
                        break;
                    case 'k':
                        kph();
                        break;
                }
            } catch (Exception e) {
                System.out.println("null");
            }
            try {
                Thread.sleep(250);
            } catch (Exception e) {
                break;
            }
        }
    });

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==mph) {
            type = 'm';
            System.out.println("m");
            System.out.println("type" + type);
            thread.start();
        }
        if(e.getSource()==kph) {
            type = 'k';
            System.out.println("k");
            System.out.println("type" + type);
            thread.start();
        }
    }
}
