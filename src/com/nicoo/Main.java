package com.nicoo;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Main extends JPanel implements ActionListener {
    private JButton btn_1;
    private JButton btn_2;
    private JButton btn_3;
    private JButton btn_4;
    private JButton btn_5;
    private JButton btn_6;
    private JButton btn_7;
    private JButton btn_8;
    private JButton btn_9;
    private JButton reset_btn;
    private JLabel playerOne;
    private JLabel playerTwo;
    private JLabel pOneScore;
    private JLabel pTwoScore;

    private int playerOneScoreCount, playerTwoScoreCount, roundCount;

    boolean activePlayer;

    public Main() {
        //construct components
        reset_btn = new JButton ("Reset");
        playerOne = new JLabel ("X");
        playerTwo = new JLabel ("O");
        pOneScore = new JLabel ("newLabel");
        pTwoScore = new JLabel ("newLabel");

        JButton[] buttons = new JButton[]{
                btn_1 = new JButton ("1"), btn_2 = new JButton ("2"), btn_3 = new JButton ("3"),
        btn_4 = new JButton ("4"),
        btn_5 = new JButton ("5"),
        btn_6 = new JButton ("6"),
        btn_7 = new JButton ("7"),
        btn_8 = new JButton ("8"),
        btn_9 = new JButton ("9"),
        };


        //adjust size and set layout
        setPreferredSize (new Dimension (346, 504));
        setLayout (null);

        //add components
        for (int i = 0; i <buttons.length ; i++) {
            add(buttons[i]);
        }
        add (reset_btn);
        add (playerOne);
        add (playerTwo);
        add (pOneScore);
        add (pTwoScore);

        btn_1.addActionListener(this);
        //set component bounds (only needed by Absolute Positioning)
        btn_1.setBounds (25, 135, 90, 90);
        btn_2.setBounds (135, 135, 90, 90);
        btn_3.setBounds (240, 355, 90, 90);
        btn_4.setBounds (25, 245, 90, 90);
        btn_5.setBounds (25, 355, 90, 90);
        btn_6.setBounds (135, 355, 90, 90);
        btn_7.setBounds (240, 135, 90, 90);
        btn_8.setBounds (135, 245, 90, 90);
        btn_9.setBounds (240, 245, 90, 90);
        reset_btn.setBounds (25, 460, 310, 30);
        playerOne.setBounds (20, 10, 125, 50);
        playerTwo.setBounds (20, 75, 120, 50);
        pOneScore.setBounds (235, 10, 125, 50);
        pTwoScore.setBounds (235, 65, 125, 50);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main (String[] args) {
        JFrame frame = new JFrame ("MyPanel");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new Main());
        frame.pack();
        frame.setVisible (true);
    }


}