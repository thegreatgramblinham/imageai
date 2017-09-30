package sStudio2.Imaging.Converters;


import java.util.ArrayList;

public class ImageData<T> {

    //Private Variables
    private ArrayList<ArrayList<T>> _grid;
    private Class<T> _dataType;
    private int _w;
    private int _h;

    //Constructor
    /**
     * Base ImageData Constructor
     * @param w Width of the image.
     * @param h Height of the image.
     * @param dataType Class of the resulting T-type pixel.
     */
    public ImageData(int w, int h, Class<T> dataType) {

        _w = w;
        _h = h;
        _grid = new ArrayList<>();

        for(int i = 0; i < _h; i++)
            _grid.add(new ArrayList<>(_w));

        _dataType = dataType;
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

    public Class getDataClass() {
        return _dataType;
    }
}
