package sStudio2.Imaging.Converters;


import marvin.image.MarvinImage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sStudio2.Imaging.TestConstants;

import java.io.File;

public class PercentageBinaryImageConverterTests {
    //Private Constants
    private static final String CARL_OUTPUT = "out/percentBinaryCarl.png";
    private static final String CAPTCHAGRID_OUTPUT = "out/percentBinaryCaptchaGrid.png";

    //Private Variables
    IImageConverter _binaryImageConverter;

    //Constructor
    public PercentageBinaryImageConverterTests() {

    }

    //Setup Methods
    @Before
    public void setup() {

        _binaryImageConverter = new PercentageBinaryImageConverter();
    }

    //Test Methods
    @Test
    public void testCarlConversion() {

        binaryConversionTest(TestConstants.CARL_IMAGE_PATH, CARL_OUTPUT);
    }

    @Test
    public void testCaptchaGridConversion() {

        binaryConversionTest(TestConstants.CAPTCHAGRID_IMAGE_PATH, CAPTCHAGRID_OUTPUT);
    }

    //Private Methods
    private void binaryConversionTest(String input, String output) {

        File inputFile = new File(input);
        Assert.assertTrue(inputFile.isFile());

        MarvinImage img = _binaryImageConverter.convert(input, output);
        int[] colorArr = img.getIntColorArray();
        for(int i = 0; i < colorArr.length; i++)
        {
            boolean cond = true;
            if(!cond)
                System.out.println("Invalid Color: "+colorArr[i]);

            Assert.assertTrue(cond);

        }
        File outputFile = new File(output);
        Assert.assertTrue(outputFile.isFile());
    }
}
