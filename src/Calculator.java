import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {

    JFrame frame;
    JPanel panel;
    JTextField textfield;
    JButton[] numbers = new JButton[10];
    JButton[] functions = new JButton[9];
    JButton add, sub, div, mult;
    JButton clr, del, dec, equ, neg;

    Font font = (new Font("Ink Free", Font.BOLD, 25));
    Font font2 = (new Font("Ink Free", Font.BOLD, 15));

    char operator;
    double num1 = 0, num2 = 0, result = 0;

    Calculator(){
        frame = new JFrame();

        add = new JButton("+");
        sub = new JButton("-");
        mult = new JButton("*");
        div = new JButton("/");
        dec = new JButton(".");
        del = new JButton("DEL");
        clr = new JButton("CLR");
        neg = new JButton("(-)");
        equ = new JButton("=");

        textfield = new JTextField();
        textfield.setBounds(75,50,250,50);
        textfield.setFont(font);
        textfield.setEditable(false);
        textfield.setFocusable(false);

        panel = new JPanel();
        panel.setBounds(50,125,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));

        functions[0] = add;
        functions[1] = sub;
        functions[2] = mult;
        functions[3] = div;
        functions[4] = dec;
        functions[5] = del;
        functions[6] = clr;
        functions[7] = neg;
        functions[8] = equ;



        for (int i = 0; i < functions.length; i++) {
            functions[i].addActionListener(this);
            functions[i].setFont(font);
            functions[i].setFocusable(false);
        }

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = new JButton(String.valueOf(i));
            numbers[i].addActionListener(this);
            numbers[i].setFont(font);
            numbers[i].setFocusable(false);
        }

        del.setBounds(51,450,90,50);
        clr.setBounds(259,450,90,50);
        neg.setBounds(150,450,100,50);

        panel.add(numbers[1]);
        panel.add(numbers[2]);
        panel.add(numbers[3]);
        panel.add(add);

        panel.add(numbers[4]);
        panel.add(numbers[5]);
        panel.add(numbers[6]);
        panel.add(sub);

        panel.add(numbers[7]);
        panel.add(numbers[8]);
        panel.add(numbers[9]);
        panel.add(mult);

        panel.add(dec);
        panel.add(numbers[0]);
        panel.add(equ);
        panel.add(div);

        frame.add(del);
        frame.add(clr);
        frame.add(neg);

        frame.add(textfield);
        frame.add(panel);
        frame.setSize(400,600);
        frame.setTitle("DevConvert - Calculator");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < numbers.length; i++) {
            if(e.getSource()==numbers[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }

        if(e.getSource()==add) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        if(e.getSource()==sub) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        if(e.getSource()==div) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }
        if(e.getSource()==mult) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }

        if(e.getSource()==sub) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }

        if (e.getSource()==equ) {
            num2 = Double.parseDouble(textfield.getText());

            switch (operator) {
                case '+':
                    result=num1+num2;
                    break;
                case '-':
                    result=num1-num2;
                    break;
                case '/':
                    result=num1/num2;
                    break;
                case '*':
                    result=num1*num2;
                    break;
                }
                textfield.setText(String.valueOf(result));
        }

        if (e.getSource()==dec) {
            textfield.setText(textfield.getText().concat("."));
        }

        if (e.getSource()==del) {
            String string = textfield.getText();
            textfield.setText("");

            for (int i = 0; i < string.length()-1; i++) {
                textfield.setText(textfield.getText() + string.charAt(i));
            }
        }

        if (e.getSource()==neg) {
            double temp = Double.parseDouble(textfield.getText());
            temp = -temp;
            textfield.setText(String.valueOf(temp));
        }

        if (e.getSource()==clr) {
            textfield.setText("");
        }
    }
}
