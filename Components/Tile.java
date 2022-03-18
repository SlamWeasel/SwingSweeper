package Components;

import Listeners.TileMouseListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Tile extends JLabel
{
    private int value;
    private boolean isBomb;
    private boolean isUncovered;

    public Tile(int value, boolean isBomb)
    {
        this.value = value;
        this.isBomb = isBomb;

        TileMouseListener _TileMouseListener = new TileMouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if(e.getButton() == MouseEvent.BUTTON1)
                {
                    ((JLabel) e.getSource()).setBackground(Color.GREEN);

                    if (!((Tile) e.getSource()).isBomb())
                        ((JLabel) e.getSource()).setText(Integer.toString(((Tile) e.getSource()).getValue()));
                    else
                    {
                        ((JLabel) e.getSource()).setText("BOOM!");
                        ((JLabel) e.getSource()).getParent().setBackground(Color.RED);
                    }
                }
                else if(e.getButton() == MouseEvent.BUTTON3)
                    ((JLabel)e.getSource()).setBackground(Color.RED);

                ((Tile) e.getSource()).setUncovered(true);
            }
        };
        this.addMouseListener(_TileMouseListener);
    }

    public int getValue()
    {
        return value;
    }
    public void setValue(int value)
    {
        this.value = value;
    }
    public boolean isBomb()
    {
        return isBomb;
    }
    public void setBomb(boolean bomb)
    {
        isBomb = bomb;
    }
    public boolean isUncovered()
    {
        return isUncovered;
    }
    public void setUncovered(boolean uncovered)
    {
        isUncovered = uncovered;
    }


}
