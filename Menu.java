import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Menu extends Game{

    public Menu() {

        JFrame menu = new JFrame();
        menu.setDefaultCloseOperation(EXIT_ON_CLOSE);
        menu.setTitle("Snake");
        menu.setResizable(false);
        menu.setSize(400, 450);
        menu.setLocationRelativeTo(null);
        menu.setLayout(new GridLayout(4, 1));
        menu.setBackground(new Color(91, 133, 69));

        JPanel menuPanelTitle = new JPanel();
        JPanel menuPanelPlay = new JPanel();
        JPanel menuPanelScoreBoard = new JPanel();
        JPanel menuPanelExit = new JPanel();

        JButton btnPlay = new JButton();
        JButton btnScoreBoard = new JButton();
        JButton btnExit = new JButton();
        btnPlay.setPreferredSize(new Dimension(120, 50));
        btnPlay.setText("PLAY");
        btnPlay.setBackground(new Color(217, 56, 56));
        btnScoreBoard.setPreferredSize(new Dimension(120, 50));
        btnScoreBoard.setText("SCOREBOARD");
        btnScoreBoard.setBackground(new Color(217, 56, 56));
        btnExit.setPreferredSize(new Dimension(120, 50));
        btnExit.setText("EXIT");
        btnExit.setBackground(new Color(217, 56, 56));
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.dispose();
            }
        });
        btnPlay.addActionListener(alPlay);
        btnPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.dispose();
            }
        });

        btnScoreBoard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame scoreBoard = new JFrame();
                scoreBoard.setLayout(new GridLayout(2,1));

            }
        });
        JLabel title = new JLabel();
        title.setText("SNAKE");
        title.setFont(new Font("Serif", Font.ITALIC, 40));

        menuPanelTitle.setBackground(new Color(91, 133, 69));
        menuPanelPlay.setBackground(new Color(91, 133, 69));
        menuPanelScoreBoard.setBackground(new Color(91, 133, 69));
        menuPanelExit.setBackground(new Color(91, 133, 69));
        menuPanelTitle.add(title);
        menuPanelPlay.add(btnPlay);
        menuPanelScoreBoard.add(btnScoreBoard);
        menuPanelExit.add(btnExit);

        menu.add(menuPanelTitle);
        menu.add(menuPanelPlay);
        menu.add(menuPanelScoreBoard);
        menu.add(menuPanelExit);
        menu.setVisible(true);
    }
}
