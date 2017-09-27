package sStudio2.Imaging.Converters;


import org.junit.Before;
import org.junit.Test;
import sStudio2.Imaging.TestConstants;

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

        _binaryImageConverter.convert(TestConstants.CARL_IMAGE_PATH, CARL_BINARY_OUTPUT);
    }

    @Test
    public void testCaptchaGridConversion() {

        _binaryImageConverter.convert(TestConstants.CAPTCHAGRID_IMAGE_PATH, CAPTCHAGRID_BINARY_OUTPUT);
    }

    

}
