package sStudio2.Imaging.Converters;


import marvin.image.MarvinImage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sStudio2.Imaging.TestConstants;

import java.io.File;

public class BinaryImageConverterTests {

    //Private Constants
    private static final String CARL_BINARY_OUTPUT = "out/binaryCarl.png";
    private static final String CAPTCHAGRID_BINARY_OUTPUT = "out/binarycaptchaGrid.png";

    //Private Variables
    IImageConverter _binaryImageConverter;

    //Constructor
    public BinaryImageConverterTests() {

    }

    //Setup Methods
    @Before
    public void setup() {

        _binaryImageConverter = new BinaryImageConverter();
    }

    //Test Methods
    @Test
    public void testCarlConversion() {

        binaryConversionTest(TestConstants.CARL_IMAGE_PATH, CARL_BINARY_OUTPUT);
    }

    @Test
    public void testCaptchaGridConversion() {

        binaryConversionTest(TestConstants.CAPTCHAGRID_IMAGE_PATH, CAPTCHAGRID_BINARY_OUTPUT);
    }

    //Private Methods
    private void binaryConversionTest(String input, String output) {

        File inputFile = new File(input);
        Assert.assertTrue(inputFile.isFile());

        MarvinImage img = _binaryImageConverter.convert(input, output);
        int[] colorArr = img.getIntColorArray();
        for(int i = 0; i < colorArr.length; i++)
        {
            boolean cond = colorArr[i] == -16777216 || //white
                           colorArr[i] == -1;         //black

            if(!cond)
                System.out.println("Invalid Color: "+colorArr[i]);

            Assert.assertTrue(cond);

        }
        File outputFile = new File(output);
        Assert.assertTrue(outputFile.isFile());
    }

}
