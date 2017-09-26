package sStudio2.Imaging.Converters;


import marvin.image.MarvinImage;
import marvin.io.MarvinImageIO;

import java.awt.*;

public class BinaryImageConverter implements IImageConverter {

    //Private Constants
    private final double THRESHOLD = 127.5;

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

    public MarvinImage convert(String imgPath, String outputPath) {

        _imgPath = imgPath;
        ImageData<Boolean> data = run();

        MarvinImage img = new MarvinImage(_image.getWidth(),_image.getHeight());
        img.setColorModel(0);
        img.allocColorArray();
        for(int i = 0; i < _image.getWidth(); i++)
            for(int j = 0; j < _image.getHeight(); j++)
                img.setIntColor(i, j,
                        data.get(i,j) ? 255 : 0,
                        data.get(i,j) ? 255 : 0,
                        data.get(i,j) ? 255 : 0);
        img.update();
        MarvinImageIO.saveImage(img, outputPath);
        return img;
    }

    //Private Methods
    private ImageData<Boolean> run() {

        _image = MarvinImageIO.loadImage(_imgPath);
        ImageData<Color> imgData = new ImageData<>(_image.getWidth(), _image.getHeight());

        for(int i = 0; i < _image.getWidth(); i++) {

            for(int j = 0; j < _image.getHeight(); j++) {

                imgData.set(i,j, new Color(
                                _image.getIntComponent0(i,j),
                                _image.getIntComponent1(i,j),
                                _image.getIntComponent2(i,j),
                                1));
            }
        }

        ImageData<Boolean> binImageData = new ImageData<>(_image.getWidth(), _image.getHeight());
        for(int i = 0; i < _image.getWidth(); i++) {

            for(int j = 0; j < _image.getHeight(); j++) {

                Color c = imgData.get(i,j);
                int r = c.getRed();
                int g = c.getGreen();
                int b = c.getBlue();
                int total = r + g + b;
                total = total/3;

                binImageData.set(i, j, total < THRESHOLD);
            }
        }

        return binImageData;
    }

}