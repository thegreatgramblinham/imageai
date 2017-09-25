package sStudio2.Imaging.Converters;


import marvin.image.MarvinImage;
import marvin.io.MarvinImageIO;

import java.awt.*;

public class BinaryImageConverter implements IImageConverter {

    //Private Variables
    MarvinImage _image;
    String _imgPath;

    //Constructor
    public BinaryImageConverter() {

    }

    //Public Methods
    public ImageData convert(String imgPath) {

        _imgPath = imgPath;
        return run();
    }

    //Private Methods
    private ImageData run() {

        _image = MarvinImageIO.loadImage(_imgPath);
        ImageData imgData = new ImageData(_image.getWidth(), _image.getHeight());

        for(int i = 0; i < _image.getWidth(); i++) {

            for(int j = 0; j < _image.getHeight(); j++) {

                imgData.set(i,j, new Color(
                                _image.getIntComponent0(i,j),
                                _image.getIntComponent1(i,j),
                                _image.getIntComponent2(i,j),
                                1));
            }
        }

        return imgData;
    }

}