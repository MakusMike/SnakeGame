import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Game extends JFrame{

     ActionListener alPlay = e -> {
        JFrame selectSizeWindow = new JFrame();
        selectSizeWindow.setSize(400, 400);
        selectSizeWindow.setLocationRelativeTo(null);
        selectSizeWindow.setLayout(new GridLayout(4, 1));
        selectSizeWindow.setResizable(false);
        selectSizeWindow.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JButton btnPLAY = new JButton();
        btnPLAY.setText("Let's PLAY!");
        btnPLAY.setBackground(new Color(217, 56, 56));
        btnPLAY.setSize(30, 80);

        JLabel instruction = new JLabel();
        instruction.setText("Select desired Height and Width:");
        instruction.setBackground(new Color(91, 133, 69));
        instruction.setFont(new Font("Comic Sans", Font.BOLD, 20));
        JLabel heightinfo = new JLabel();
        heightinfo.setText("Height : ");
        heightinfo.setFont(new Font("Comic Sans", Font.BOLD, 20));
        JLabel widthinfo = new JLabel();
        widthinfo.setText("Width : ");
        widthinfo.setFont(new Font("Comic Sans", Font.BOLD, 20));
        JPanel inst = new JPanel();
        JPanel height = new JPanel();
        height.setLayout(new GridLayout(2, 2));
        height.setFocusable(false);
        JPanel width = new JPanel();
        width.setLayout(new GridLayout(2, 2));
        width.setFocusable(false);
        JPanel play = new JPanel();

        SpinnerModel modelh = new SpinnerNumberModel(640, 420, 840, 20);
        JSpinner spinnerHeight = new JSpinner(modelh);
        SpinnerModel modelw = new SpinnerNumberModel(640, 420, 840, 20);
        JSpinner spinnerWidth = new JSpinner(modelw);
        spinnerHeight.addChangeListener((e12 -> Snake.screenHeight =(int)(((JSpinner) e12.getSource()).getValue())));
        spinnerHeight.addChangeListener((e1 -> Snake.screenWidth =(int)(((JSpinner) e1.getSource()).getValue())));
        btnPLAY.addActionListener(e13 -> {
            selectSizeWindow.dispose();
            JFrame snake = new JFrame();
            snake.add(new Snake());
            snake.setTitle("Snake");
            snake.setDefaultCloseOperation(EXIT_ON_CLOSE);
            snake.setResizable(false);
            snake.pack();
            snake.setVisible(true);
            snake.setLocationRelativeTo(null);
        });

        height.add(heightinfo);
        height.add(spinnerHeight);
        width.add(widthinfo);
        width.add(spinnerWidth);
        inst.add(instruction);
        play.add(btnPLAY);
        selectSizeWindow.add(inst);
        selectSizeWindow.add(height);
        selectSizeWindow.add(width);
        selectSizeWindow.add(play);
        selectSizeWindow.setVisible(true);

    };
}
