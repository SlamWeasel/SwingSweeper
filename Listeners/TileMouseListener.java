package Listeners;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public abstract class TileMouseListener implements MouseListener
{
    @Override
    public void mouseClicked(MouseEvent e)
    {
        if(e.getButton() == MouseEvent.BUTTON1)
        {
            ((JLabel) e.getSource()).setBackground(Color.GREEN);
        }
        else if(e.getButton() == MouseEvent.BUTTON3)
            ((JLabel) e.getSource()).setBackground(Color.RED);
        else
            System.out.println(e.getButton());
    }

    @Override
    public void mousePressed(MouseEvent e)
    {

    }

    @Override
    public void mouseReleased(MouseEvent e)
    {

    }

    @Override
    public void mouseEntered(MouseEvent e)
    {

    }

    @Override
    public void mouseExited(MouseEvent e)
    {

    }
}
