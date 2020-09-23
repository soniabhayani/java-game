package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;

public class ControlPanel  extends Container {
    private JButton Quit;
    private JButton Resume;
    private JPanel mainPanel;
    private JButton Pause;
    private JButton Save;
    private JButton Load;

    private int levelNum;
    private String levelStr;
    private int livesNum;
    private String livesStr;
    private int scoreNum;
    private String scoreStr;
    private Game game;

    public ControlPanel(Game game) {
        this.game = game;
        requestFocus();

        Quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        Resume.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.resume();
                System.out.println("resume");
            }
        });
        Pause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.pause();
                System.out.println("pause");
            }
        });
        Save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{

                    //For level position
                    levelNum = game.getLevel();
                    levelStr = Integer.toString(levelNum); // convert level to string
                    FileWriter fileWriter = new FileWriter("savedlevel.txt"); //write level in text file
                    PrintWriter printWriter = new PrintWriter("savedlevel.txt");

                    printWriter.println(levelStr); //print the string form of the level
                    printWriter.close();

                    //For lives
                    livesNum = game.getPlayer().getLifeCount();
                    livesStr = Integer.toString(livesNum); // convert score to string
                    FileWriter fileWrite = new FileWriter("savedlives.txt"); //write level in text file
                    PrintWriter printWrite = new PrintWriter("savedlives.txt");

                    printWrite.println(livesStr); //print the string form of the lives
                    printWrite.close();

                    //For Score
                    //For lives
                    scoreNum = game.getPlayer().getCoinCount();
                    scoreStr = Integer.toString(scoreNum); // convert score to string
                    FileWriter fw = new FileWriter("savedscore.txt"); //write score in text file
                    PrintWriter pw = new PrintWriter("savedscore.txt");

                    pw.println(scoreStr); //print the string form of the score
                    pw.close();
                }
                catch(IOException ioe) {
                    System.out.println(ioe);
                }
                setFocusable(false);
            }
        });
        Load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    String livesRead;
                    String levelRead;
                    String scoreRead;

                    //For level load
                    FileReader fileReader = new FileReader("savedlevel.txt");
                    BufferedReader bufferedReader = new BufferedReader(fileReader);

                    levelRead = bufferedReader.readLine();
                    bufferedReader.close();
                    levelNum = Integer.parseInt(levelRead);
                    System.out.println(levelRead);

                    game.setLevel(levelNum - 1);
                    game.goNextLevel();

                    //For lives
                    FileReader fileRead = new FileReader("savedlives.txt");
                    BufferedReader bufferedRead = new BufferedReader(fileRead);

                    livesRead = bufferedRead.readLine();
                    livesNum = Integer.parseInt(livesRead);
                    game.getPlayer().setLifeCount(livesNum);
                    System.out.println(livesRead);

                    //For score
                    FileReader fr = new FileReader("savedscore.txt");
                    BufferedReader br = new BufferedReader(fr);

                    scoreRead = br.readLine();
                    scoreNum = Integer.parseInt(scoreRead);
                    game.getPlayer().setCoinCount(scoreNum);
                    System.out.println(scoreRead);

                } catch (IOException ioe) {
                    System.out.println(ioe);
                }
                setFocusable(false);
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}