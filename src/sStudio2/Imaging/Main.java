package sStudio2.Imaging;

import sStudio2.Imaging.Converters.BinaryImageConverter;
import sStudio2.Imaging.Converters.IImageConverter;

public class Main {

    public static void main(String[] args) {

        IImageConverter bic = new BinaryImageConverter();
        bic.convert("resources/lensflareCarl.jpg", "out/binaryCarl.png");
    }
}
