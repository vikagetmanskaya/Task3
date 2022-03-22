package by.javacourse.task3;

import by.javacourse.task3.exception.TextCustomException;
import by.javacourse.task3.reader.TextReader;
import by.javacourse.task3.reader.impl.TextReaderImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;

public class TextReaderTest {
    private TextReader textReader;
    private static final String pathToTestFile = "src/test/resources/text_test.txt";
    private String expected;
    @BeforeClass
    public void setUp(){
        textReader = new TextReaderImpl();
        expected = "\tIt is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using (~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78 Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using (Content here), content here', making it look like readable English.\n\tIt is a (7^5|1&2<<(2|5>>2&71))|1200 established fact that a reader will be of a page when looking at its layout.";
    }
    @Test
    public void testTextReader() throws TextCustomException {
        String actual;
        try {
            actual = textReader.readTextFromFile(pathToTestFile);
        } catch (TextCustomException e) {
            throw new TextCustomException("Error in reader text", e);
        }
        Assert.assertEquals(actual, expected);
    }

}
