package Util;

import java.util.ArrayList;
import java.util.Collections;

public class PlayingField<T>
{
    private ArrayList<ArrayList<T>> values;
    private final int X, Y;

    public PlayingField(int sizeX, int sizeY)
    {
        this.values = new ArrayList<>(sizeX);
        this.X = sizeX;
        this.Y = sizeY;

        for (int i = 0; i < sizeX; i++)
        {
            ArrayList<T> row = new ArrayList<>(sizeY);
            for (int j = 0; j < sizeY; j++)
                row.add(null);
            this.values.add(row);
        }
    }

    public void set(int x, int y, T v)
    {
        this.values.get(x).set(y, v);
    }
    public T get(int x, int y)
    {
        return this.values.get(x).get(y);
    }

    public int countBombs(int x, int y)
    {
        int OUT = 0;

        // XOO
        // O O
        // OOO
        if(x != 0 && y != 0)
            if(((int) this.get(x - 1, y - 1)) == -1)
                OUT++;
        // OXO
        // O O
        // OOO
        if(y != 0)
            if(((int) this.get(x, y - 1)) == -1)
                OUT++;
        // OOX
        // O O
        // OOO
        if(x != this.X - 1 && y != 0)
            if(((int) this.get(x + 1, y - 1)) == -1)
                OUT++;
        // OOO
        // X O
        // OOO
        if(x != 0)
            if(((int) this.get(x - 1, y)) == -1)
                OUT++;
        // OOO
        // O X
        // OOO
        if(x != this.X - 1)
            if(((int) this.get(x + 1, y)) == -1)
                OUT++;
        // OOO
        // O O
        // XOO
        if(x != 0 && y != this.Y - 1)
            if(((int) this.get(x - 1, y + 1)) == -1)
                OUT++;
        // OOO
        // O O
        // OXO
        if(y != this.Y - 1)
            if(((int) this.get(x, y + 1)) == -1)
                OUT++;
        // OOO
        // O O
        // OOX
        if(x != this.X - 1 && y != this.Y-1)
            if(((int) this.get(x + 1, y + 1)) == -1)
                OUT++;


        return OUT;
    }
}
