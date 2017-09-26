package sStudio2.Imaging.Converters;


import marvin.image.MarvinImage;

public interface IImageConverter {

    ImageData convert(String path);
    MarvinImage convert(String path, String outputPath);
}
