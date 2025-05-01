import javax.swing.*;
import java.awt.*;

public class salesTax {

    double taxAmount;

    JTextField taxInput = new JTextField();
    JTextField input = new JTextField();
    JTextField output = new JTextField();

    JLabel taxInputLabel = new JLabel();
    JLabel inputLabel = new JLabel();
    JLabel outputLabel = new JLabel();

    JFrame frame;

    Font font = new Font("Ink Free",Font.BOLD, 17);

    salesTax() {
        frame = new JFrame();

        taxInputLabel.setText("Tax Amount:");
        taxInputLabel.setBounds(91,10,150,20);
        taxInputLabel.setFont(font);

        taxInput.setBounds(110,40,75,30);

        outputLabel.setText("Cost:");
        outputLabel.setBounds(125,75,75,20);
        outputLabel.setFont(font);

        input.setBounds(110,100,75,30);

        inputLabel.setText("Final:");
        inputLabel.setBounds(125,140,150,20);
        inputLabel.setFont(font);

        output.setBounds(110,170,75,30);
        output.setFocusable(false);

        frame.add(taxInput);
        frame.add(input);
        frame.add(output);

        frame.add(outputLabel);
        frame.add(inputLabel);
        frame.add(taxInputLabel);
        frame.setLayout(null);
        frame.setTitle("DevConvert - Sales Tax");
        frame.setSize(300,250);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        taxCalc.start();
        try {
            taxCalc.start();
        } catch (Exception e) {
            System.out.println("tik");
        }
    }

    double taxAmountNumTemp;
    double taxAmountNum;
    double result;
    double cost;

    Thread taxCalc = new Thread(() -> {
       while(true) {
           try {
               taxAmountNumTemp = Double.parseDouble(taxInput.getText());
               taxAmountNum = taxAmountNumTemp / 100;
               cost = Double.parseDouble(input.getText());
               result = (cost * taxAmountNum) + cost;
               output.setText("$".concat(String.valueOf(result)));
               System.out.println("result: " + result);
               System.out.println("taxAmountNum: " + taxAmountNum);
               System.out.println("taxAmountNumTemp: " + taxAmountNumTemp);
           } catch (Exception e) {
               System.out.println("error");
           }

           try {
               Thread.sleep(500);
           } catch (InterruptedException e) {
               System.out.println("crit error");
           }
       }
    });
}
