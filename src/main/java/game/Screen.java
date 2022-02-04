package game;


import javax.swing.*;

public class Screen {
    public static void main(String[] args) {


        JFrame frame = new JFrame("Sailing The Seas");
        frame.setTitle("Sailing The Seas");
        frame.add(new Board());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 365);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }
}

