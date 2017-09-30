package sStudio2.Imaging.Converters;


import marvin.image.MarvinImage;
import marvin.io.MarvinImageIO;

public class PercentageBinaryImageConverter implements IImageConverter {

    //Private Variables
    MarvinImage _image;
    String _imgPath;

    //Constructor
    public PercentageBinaryImageConverter() {

    }

    //Public Methods
    public ImageData convert(String imgPath) {

        _imgPath = imgPath;
        return run();
    }

    public MarvinImage convert(String imgPath, String outputPath) {

        _imgPath = imgPath;
        ImageData<Float> data = run();

        MarvinImage img = new MarvinImage(data.getWidth(),data.getHeight());
        img.setColorModel(0);
        img.allocColorArray();
        for(int i = 0; i < data.getWidth(); i++)
            for(int j = 0; j < data.getHeight(); j++)
                img.setIntColor(i, j,
                        percentToRGBInt(data.get(i,j)),
                        percentToRGBInt(data.get(i,j)),
                        percentToRGBInt(data.get(i,j)));
        img.update();
        MarvinImageIO.saveImage(img, outputPath);
        return img;
    }

    //Private Methods
    private ImageData<Float> run() {

        _image = MarvinImageIO.loadImage(_imgPath);
        ImageData<Float> imgData = new ImageData<>(_image.getWidth(), _image.getHeight(), Float.class);

        for(int i = 0; i < _image.getWidth(); i++) {

            for(int j = 0; j < _image.getHeight(); j++) {

                int r = _image.getIntComponent0(i,j);
                int g = _image.getIntComponent1(i,j);
                int b = _image.getIntComponent2(i,j);
                int total = r + g + b;
                float avg = (float)total/3.0f;
                float percent = avg/255.0f;
                imgData.set(i,j, percent);
            }
        }

        return imgData;
    }

    private int percentToRGBInt(Float f) {

        return Math.round(f*255);
    }
}
