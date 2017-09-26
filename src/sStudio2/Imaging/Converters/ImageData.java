package sStudio2.Imaging.Converters;


import java.awt.*;
import java.util.ArrayList;

public class ImageData<T> {

    //Private Variables
    private ArrayList<ArrayList<T>> _grid;
    private int _w;
    private int _h;

    //Constructor
    public ImageData(int w, int h) {

        _w = w;
        _h = h;
        _grid = new ArrayList<>();

        for(int i = 0; i < _h; i++)
            _grid.add(new ArrayList<>(_w));
    }

    //Public Methods
    public void set(int x, int y, T item) {

        ArrayList<T> row = _grid.get(y);
        if(row.size() == x)
            row.add(item);
        else
            row.set(x, item);
    }

    public T get(int x, int y) {

        return _grid.get(y).get(x);
    }

    public int getWidth() {

        return _w;
    }

    public int getHeight() {

        return _h;
    }
}
