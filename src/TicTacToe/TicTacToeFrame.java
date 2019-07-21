package TicTacToe;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.*;

public class TicTacToeFrame extends JFrame {

    // indicate whose turn is it
    private char whoseTurn = 'X';

    // create cell grid
    private Cell[][] cells = new Cell[3][3];

    //create a status label
    JLabel jlblStatus = new JLabel("X's turn");

    /**
     * No-argument Constructor
     */
    public TicTacToeFrame()
    {
        // Panel to hold cells
        JPanel panel = new JPanel(new GridLayout(3, 3, 0, 0));
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                panel.add(cells[i][j] = new Cell());

        panel.setBorder(new LineBorder(Color.RED,1));
        jlblStatus.setBorder(new LineBorder(Color.YELLOW,1));

        add(panel,BorderLayout.CENTER);
        add(jlblStatus,BorderLayout.SOUTH);

    }

    /**
     * Determine if game board is full
     * @return True, if game board is full. Otherwise, false.
     */
    public boolean isFull(){
        for (int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                if (cells[i][j].getToken() == ' ')
                    return false;
                return true;
    }

    public boolean isWon(char token)
    {
        // check rows
        for (int i = 0; i < 3; i++)
            if((cells[i][0].getToken() == token )
                && (cells[i][1].getToken() == token)
                && (cells[i][2].getToken() == token))
            {
                return true;
            }
        // check columns
        for (int j = 0; j < 3;j++)
            if((cells[0][j].getToken() == token )
                    && (cells[1][j].getToken() == token)
                    && (cells[2][j].getToken() == token))
            {
                return true;
            }
        return false;
    }

    public class Cell extends JPanel {
        // token of this cell
        private char token = ' ';

        public Cell(){
            setBorder(new LineBorder(Color.BLACK, 1));
            addMouseListener(new MyMouseListener());
        }


        public char getToken(){
            return token;
        }

        public void setToken(char c){
            this.token = c;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);

            if (token == 'X') {
                g.drawLine(10, 10, getWidth() - 10, getHeight() - 10);
                g.drawLine(getWidth() - 10, 10, 10, getHeight() - 10);
            }

            else if (token == 'O')
            {
                g.drawOval(10,10,getWidth()-20,getHeight()-20);
            }
        }

        private class MyMouseListener extends MouseAdapter
        {
            @Override
            public void mouseClicked(MouseEvent event)
            {
                if(token == ' ' && whoseTurn != ' ')
                    setToken(whoseTurn);

                //check game status
                if (isWon(whoseTurn))
                {
                    jlblStatus.setText(whoseTurn + " won! Game Over!");
                    whoseTurn = ' ';
                }
                else if (isFull())
                {
                    jlblStatus.setText("Tie Game ! Game Over !");
                    whoseTurn = ' ';
                }
                else
                {
                    whoseTurn = (whoseTurn == 'X') ? 'O' : 'X';
                    jlblStatus.setText(whoseTurn + "'s turn.");
                }
            }
        } // end class MyMouseListener
    }

}