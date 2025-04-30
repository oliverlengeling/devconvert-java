import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu implements ActionListener {

    public static JFrame frame;
    public static JPanel buttonPanel;
    public static JPanel titlePanel;
    public static JButton calcButton, tempButton;
    public static Font font;

    Menu() {
        frame = new JFrame();
        buttonPanel = new JPanel();
        font = new Font("Ink Free", Font.BOLD, 25);

        JLabel authorLabel = new JLabel("Written by: Oliver Lengeling");
        authorLabel.setFont(new Font("Ink Free", Font.BOLD, 12));
        authorLabel.setBounds(10,440,200,30);

        JLabel versionLabel = new JLabel("v0.1.1");
        versionLabel.setBounds(250,440,50,30);
        versionLabel.setFont(new Font("Ink Free", Font.BOLD, 12));

        JLabel titleLabel = new JLabel();
        titleLabel.setFont(font);
        titleLabel.setLayout(null);
        titleLabel.setText("DevConvert");
        titleLabel.setBounds(75,35,200,20);

        buttonPanel.setBounds(50,75,200,300);

        calcButton = new JButton("Calculator");
        calcButton.setFont(font);
        calcButton.setFocusable(false);
        calcButton.setBounds(50,50,200,50);
        calcButton.addActionListener(this);

        tempButton = new JButton("Temp");
        tempButton.setFont(font);
        tempButton.setFocusable(false);
        tempButton.setBounds(100,50,100,50);
        tempButton.addActionListener(this);

        buttonPanel.add(calcButton);
        buttonPanel.add(tempButton);

        frame.add(authorLabel);
        frame.add(versionLabel);
        frame.add(buttonPanel);
        frame.add(titleLabel);

        frame.setTitle("DevConvert");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,500);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==calcButton) {
            new Calculator();
        }
        if(e.getSource()==tempButton) {
            new Temp();
        }
    }
}
