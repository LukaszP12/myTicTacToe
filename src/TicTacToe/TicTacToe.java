package TicTacToe;

import javax.swing.JFrame;

public class TicTacToe {

    public static void main(String[] args){
        JFrame ticTacToe = new TicTacToeFrame();
        ticTacToe.setTitle("Phantom TicTacToe Game!");
        ticTacToe.setSize(600,600);
        ticTacToe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ticTacToe.setLocationRelativeTo(null);
        ticTacToe.setVisible(true);
    }
}
