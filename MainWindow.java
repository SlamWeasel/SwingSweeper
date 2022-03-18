import Components.Tile;
import Listeners.TileMouseListener;
import Util.PlayingField;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainWindow
{
    /**
     * Bruh
     */
    static int size = 10;

    static PlayingField<Integer> playField = new PlayingField<>(size, size);

    private static void createAndShowGUI()
    {
        //Create and set up the window.
        JFrame frame = new JFrame("SwingSweeper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setBackground(Color.WHITE);

        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                if(((int)Math.round(Math.random()*5)) % 5 == 1)
                    playField.set(i, j, -1);
                else
                    playField.set(i, j, 0);
            }
        }

        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                Tile label;

                if(playField.get(i, j) == -1)
                    label = new Tile(0, true);
                else
                    label = new Tile(playField.countBombs(i, j), false);

                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setBounds(58 * i, 58 * j, 60,60);
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
                label.setOpaque(true);
                label.setName(i + ";" + j);
                frame.getContentPane().add(label);
            }
        }

        //Display the window.
        frame.pack();
        frame.setVisible(true);
        frame.setBounds(100, 100, 400, 250);
    }

    public static void main(String[] args)
    {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(MainWindow::createAndShowGUI);
    }


}
