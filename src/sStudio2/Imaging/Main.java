package sStudio2.Imaging;

import sStudio2.Imaging.Converters.BinaryImageConverter;
import sStudio2.Imaging.Converters.ImageData;

public class Main {

    public static void main(String[] args) {

        BinaryImageConverter bic = new BinaryImageConverter();
        ImageData imageData = bic.convert("resources/lensflareCarl.jpg");
    }
}
