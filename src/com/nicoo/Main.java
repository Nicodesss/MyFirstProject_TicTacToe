package com.nicoo;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Main extends JPanel implements ActionListener {
    private JButton btn_one;
    private JButton btn_two;
    private JButton btn_nine;
    private JButton btn_four;
    private JButton btn_seven;
    private JButton btn_eight;
    private JButton btn_three;
    private JButton btn_five;
    private JButton btn_six;
    private JButton reset_btn;
    private JLabel playerOne;
    private JLabel playerTwo;
    private JLabel pOneScore;
    private JLabel pTwoScore;
    private int pOneWin = 1;
    private int pTwoWin = 1;
    private String player;

    int roundCount = 1;
    boolean win;

    public Main() {
        //construct components
        reset_btn = new JButton("Reset Game");

        playerOne = new JLabel("X");
        playerTwo = new JLabel("O");

        pOneScore = new JLabel("Score: " + (pOneWin - 1));
        pTwoScore = new JLabel("Score: " + (pTwoWin - 1));

        JButton[] buttons = new JButton[]{
                btn_one = new JButton("-"), btn_two = new JButton("-"), btn_nine = new JButton("-"),
                btn_four = new JButton("-"),
                btn_seven = new JButton("-"),
                btn_eight = new JButton("-"),
                btn_three = new JButton("-"),
                btn_five = new JButton("-"),
                btn_six = new JButton("-"),
        };
        //adjust size and set layout
        setPreferredSize(new Dimension(346, 504));
        setLayout(null);

        //add components
        for (JButton button : buttons) {
            add(button);
        }
        add(reset_btn);
        add(playerOne);
        add(playerTwo);
        add(pOneScore);
        add(pTwoScore);

        for (JButton bu : buttons
        ) {
            bu.addActionListener(this);
        }

        reset_btn.addActionListener(this);


        //set component bounds (only needed by Absolute Positioning)
        btn_one.setBounds(25, 135, 90, 90);
        btn_two.setBounds(135, 135, 90, 90);
        btn_nine.setBounds(240, 355, 90, 90);
        btn_four.setBounds(25, 245, 90, 90);
        btn_seven.setBounds(25, 355, 90, 90);
        btn_eight.setBounds(135, 355, 90, 90);
        btn_three.setBounds(240, 135, 90, 90);
        btn_five.setBounds(135, 245, 90, 90);
        btn_six.setBounds(240, 245, 90, 90);

        reset_btn.setBounds(185, 460, 145, 30);
        playerOne.setBounds(20, 10, 125, 50);
        playerTwo.setBounds(20, 65, 120, 50);
        pOneScore.setBounds(235, 10, 125, 50);
        pTwoScore.setBounds(235, 65, 125, 50);
    }

    static JFrame frame = new JFrame("Tic Tac Toe");
    public static void main(String[] args) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new Main());
        frame.pack();
        frame.setVisible(true);
    }
// p1 0
    // p2 1
    // empty "-"

    public void turn() {
        if (roundCount % 2 != 0) {
            player = "X";
        } else {
            player = "O";
        }
        roundCount++;
    }

    void win() {
        if (btn_one.getText() == btn_two.getText() && btn_two.getText() == btn_three.getText() && btn_two.getText() != "-") {
            win = true;
        } else if (btn_four.getText() == btn_five.getText() && btn_five.getText() == btn_six.getText() && btn_five.getText() != "-") {
            win = true;
        } else if (btn_seven.getText() == btn_eight.getText() && btn_eight.getText() == btn_nine.getText() && btn_eight.getText() != "-") {
            win = true;
        } else if (btn_one.getText() == btn_four.getText() && btn_four.getText() == btn_seven.getText() && btn_four.getText() != "-") {
            win = true;
        } else if (btn_two.getText() == btn_five.getText() && btn_five.getText() == btn_eight.getText() && btn_eight.getText() != "-") {
            win = true;
        } else if (btn_three.getText() == btn_six.getText() && btn_six.getText() == btn_nine.getText() && btn_six.getText() != "-") {
            win = true;
        } else if (btn_one.getText() == btn_five.getText() && btn_five.getText() == btn_nine.getText() && btn_five.getText() != "-") {
            win = true;
        } else if (btn_three.getText() == btn_five.getText() && btn_five.getText() == btn_seven.getText() && btn_five.getText() != "-") {
            win = true;
        }

    }

    public void scoreInput() {
        if (player == "X" && win == true) {
            pOneScore.setText("Score: " + (pTwoWin++));
            win = false;
        } else if (player == "O" && win == true) {
            pTwoScore.setText("Score: " + (pOneWin++));
            win = false;
        }
    }

    public void hasWon() {
        if (win) {
            JOptionPane.showMessageDialog(frame, "Player " + player + " has won!");
            btn_one.setText("-");
            btn_two.setText("-");
            btn_three.setText("-");
            btn_four.setText("-");
            btn_five.setText("-");
            btn_six.setText("-");
            btn_seven.setText("-");
            btn_eight.setText("-");
            btn_nine.setText("-");

            roundCount = 1;

        }
    }

    public void hasTied() {
        if (btn_one.getText() != "-" && btn_two.getText() != "-"&& btn_three.getText() != "-" && btn_four.getText() !="-" && btn_five.getText() !="-" && btn_six.getText() != "-" && btn_seven.getText() != "-" && btn_eight.getText() !="-"&& btn_nine.getText()!= "-")
        {
            JOptionPane.showMessageDialog(frame, "Game Tied!");
            btn_one.setText("-");
            btn_two.setText("-");
            btn_three.setText("-");
            btn_four.setText("-");
            btn_five.setText("-");
            btn_six.setText("-");
            btn_seven.setText("-");
            btn_eight.setText("-");
            btn_nine.setText("-");

            roundCount = 1;
            win = false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        turn();

        if (e.getSource() == btn_one) {
            if (player == "X" && btn_one.getText() != "O"){
            btn_one.setText(player);
            System.out.println("btn1");
            }else if(player == "O" && btn_one.getText() != "X"){
                btn_one.setText(player);
            }
        } else if (e.getSource() == btn_two) {
            if (player == "X" && btn_two.getText() != "O"){
                btn_two.setText(player);
                System.out.println("btn1");
            }else if(player == "O" && btn_two.getText() != "X"){
                btn_two.setText(player);
            }
        } else if (e.getSource() == btn_nine) {
            if (player == "X" && btn_nine.getText() != "O"){
                btn_nine.setText(player);
                System.out.println("btn1");
            }else if(player == "O" && btn_nine.getText() != "X"){
                btn_nine.setText(player);
            }
        } else if (e.getSource() == btn_four) {
            if (player == "X" && btn_four.getText() != "O"){
                btn_four.setText(player);
                System.out.println("btn1");
            }else if(player == "O" && btn_four.getText() != "X"){
                btn_four.setText(player);
            }
        } else if (e.getSource() == btn_seven) {
            if (player == "X" && btn_seven.getText() != "O"){
                btn_seven.setText(player);
                System.out.println("btn1");
            }else if(player == "O" && btn_seven.getText() != "X"){
                btn_seven.setText(player);
            }
        } else if (e.getSource() == btn_eight) {
            if (player == "X" && btn_eight.getText() != "O"){
                btn_eight.setText(player);
                System.out.println("btn1");
            }else if(player == "O" && btn_eight.getText() != "X"){
                btn_eight.setText(player);
            }
        } else if (e.getSource() == btn_three) {
            if (player == "X" && btn_three.getText() != "O"){
                btn_three.setText(player);
                System.out.println("btn1");
            }else if(player == "O" && btn_three.getText() != "X"){
                btn_three.setText(player);
            }
        } else if (e.getSource() == btn_five) {
            if (player == "X" && btn_five.getText() != "O"){
                btn_five.setText(player);
                System.out.println("btn1");
            }else if(player == "O" && btn_five.getText() != "X"){
                btn_five.setText(player);
            }
        } else if (e.getSource() == btn_six) {
            if (player == "X" && btn_six.getText() != "O"){
                btn_six.setText(player);
                System.out.println("btn1");
            }else if(player == "O" && btn_six.getText() != "X"){
                btn_six.setText(player);
            }
        }
        win();
        System.out.println(win);
        hasWon();

        scoreInput();

        if (e.getSource() == reset_btn) {

            pOneWin = 0;
            pTwoWin = 0;
            pOneScore.setText("Score: " + pOneWin);
            pTwoScore.setText("Score: " + pTwoWin);
            btn_one.setText("-");
            btn_two.setText("-");
            btn_three.setText("-");
            btn_four.setText("-");
            btn_five.setText("-");
            btn_six.setText("-");
            btn_seven.setText("-");
            btn_eight.setText("-");
            btn_nine.setText("-");

            win = false;
        }
        hasTied();

    }
}
