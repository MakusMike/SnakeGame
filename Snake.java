import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Random;


public class Snake extends JPanel implements ActionListener{
    static int screenWidth = 600;
    static int screenHeight = 600;
    final int gameUnit = 20;
    protected int gameField = (screenWidth * screenHeight) / (gameUnit * gameUnit);
    static int delay = 150;
    final int[] x = new int[gameField];
    final int[] y = new int[gameField];
    int bodyParts = 5;
    int fruityPoints;
    int fruitX;
    int fruitY;
    int t = 0;
    static String direction = "RIGHT";
    boolean running = false;
    Timer timer;
    Random random;

    Snake() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(new Color(128, 89, 64));
        this.setFocusable(true);
        this.addKeyListener(new MyKeys());
        random = new Random();
        startGame();

    }

    public void startGame() {
        addFruit();
        running = true;
        timer = new Timer(delay,this);
        timer.start();
    }
    public void move() {
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        switch (direction) {
            case "UP":
                up();
                break;
            case "DOWN":
                down();
                break;
            case "RIGHT":
                right();
                break;
            case "LEFT":
                left();
                break;
        }
    }
    public void addFruit() {
        fruitX = random.nextInt((int) (screenWidth / gameUnit)) * gameUnit;
        fruitY = random.nextInt((int) (screenHeight / gameUnit)) * gameUnit;
    }

    public void checkFruit() {
        if ((x[0] == fruitX) && (y[0] == fruitY)) {
            bodyParts++;
            fruityPoints+=2;
            if (delay<0){
            delay-=30;
            }
            addFruit();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        if (running) {
            g.setColor(Color.MAGENTA);
            g.fillOval(fruitX, fruitY, gameUnit, gameUnit);

            for (int i = 0; i < bodyParts; i++) {
                if (i == 0) {
                    g.setColor(new Color(38, 137, 21, 188));
                    g.fillOval(x[i], y[i], gameUnit, gameUnit);
                } else {
                    g.setColor(new Color(161, 7, 7));
                    g.fillRect(x[i], y[i], gameUnit, gameUnit);
                }
                repaint();
            }

            g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
            g.fillOval(fruitX, fruitY, gameUnit, gameUnit);
            g.setColor(Color.red);
            g.drawString("Score: "+fruityPoints, (screenWidth - getFontMetrics(new Font("Comic Sans",Font.BOLD,40)).stringWidth("Score: "+fruityPoints))/2, g.getFont().getSize());
        }
    }

    public void collisionCheck() {
        for (int i = bodyParts; i > 0; i--) {
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                running = false;
            }
        }

        if (y[0] < 0) {
            running = false;
        }

        if (x[0] < 0) {
            running = false;
        }

        if (x[0] > screenWidth) {
            running = false;
        }

        if (y[0] > screenHeight) {
            running = false;
        }
        if (!running){
            timer.stop();
            gameOver();
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkFruit();
            collisionCheck();
            t++;
        }
        repaint();
    }

    public void gameOver() {

        JFrame gameOver = new JFrame();
        gameOver.setLayout(new GridLayout(3,1));
        JTextArea over = new JTextArea();
        over.setFont(new Font("Comic Sans",Font.BOLD,40));
        over.setText("GAME OVER :(");
        over.setFocusable(false);
        JTextArea score = new JTextArea();
        JTextArea welldone = new JTextArea();
        welldone.setText("GOOD JOB");
        welldone.setFocusable(false);
        welldone.setFont(new Font("Comic Sans",Font.ITALIC,20));
        score.setText("Your 'fruit' score was: "+fruityPoints);
        score.setFocusable(false);
        score.setFont(new Font("Comic Sans",Font.BOLD, 20));

        JPanel endInfo = new JPanel();
        endInfo.setLayout(new GridLayout(3,1));
        endInfo.add(over);
        endInfo.add(score);
        endInfo.add(welldone);

        JPanel scoreSave = new JPanel();
        scoreSave.setLayout(new GridLayout(3,1));

        JTextField nick = new JTextField();
        JTextArea nickSave = new JTextArea("Enter your name for the Scoreboard: ");
        nickSave.setFont(new Font("Comic Sans",Font.PLAIN, 25));
        nick.setSize(30,20);
        nick.setFont(new Font("Comic Sans",Font.BOLD,20));

        scoreSave.add(nickSave);
        scoreSave.add(nick);

        JButton save = new JButton();
        save.setText("Save!");
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (PrintWriter saveSB = new PrintWriter(new FileWriter("ScoreBoard.txt",true))) {
                    saveSB.println(nick.getText() + " scored : " + fruityPoints + " on this daya bla");
                }catch (java.io.FileNotFoundException e1){
                    System.out.println("WHOOPS WHERE IS THE FILE ??");
                }catch (java.io.IOException e2){
                    System.out.println("im so sorry but something went wrong...");
                }
                gameOver.dispose();
                JFrame zapis = new JFrame();
                JPanel score = new JPanel();


              Color color = new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));
              JTextPane scored = new JTextPane();
              scored.setText("For me,\n your score was the best \n"+nick.getText());
              scored.setFont(new Font("MS Comic Sans",Font.BOLD,18));
              score.setSize(200,120);
              scored.setBackground(color);
              scored.setFocusable(false);


              JTextPane pkt = new JTextPane();
              pkt.setFont(new Font("MS Comic Sans",Font.BOLD,40));
              pkt.setText("! "+fruityPoints+" !");
              pkt.setFocusable(false);
              pkt.setBackground(color);
              pkt.setSize(100,100);

              score.setLayout(new GridLayout(2,1));
              score.add(pkt);
              score.add(scored);
              score.setSize(200,120);

              zapis.add(score);
              zapis.setSize(350,300);
              zapis.setVisible(true);
              zapis.setLocationRelativeTo(null);
              zapis.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }}
        );
        gameOver.add(endInfo);
        gameOver.add(scoreSave);
        gameOver.add(save);
        gameOver.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameOver.pack();
        gameOver.setLocationRelativeTo(null);
        gameOver.setResizable(false);
        gameOver.setVisible(true);

    }

    public void down() {
        y[0] = y[0] + gameUnit;
    }

    public void up() {
        y[0] = y[0] - gameUnit;
    }

    public void right() {
        x[0] = x[0] + gameUnit;
    }

    public void left() {
        x[0] = x[0] - gameUnit;
    }

}

