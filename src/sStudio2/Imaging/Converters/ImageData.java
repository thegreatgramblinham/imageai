package sStudio2.Imaging.Converters;


import java.awt.*;

public class ImageData {

    //Private Variables
    private Color[][] _grid;
    private int _w;
    private int _h;

    //Constructor
    public ImageData(int w, int h) {

        _w = w;
        _h = h;
        _grid = new Color[_w][_h];
    }

    //Public Methods
    public void set(int x, int y, Color item) {

        _grid[x][y] = item;
    }

    public Color get(int x, int y) {

        return _grid[x][y];
    }

    public int getWidth() {

        return _w;
    }

    public int getHeight() {

        return _h;
    }
}
