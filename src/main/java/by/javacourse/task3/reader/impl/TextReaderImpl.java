package by.javacourse.task3.reader.impl;

import by.javacourse.task3.exception.TextCustomException;
import by.javacourse.task3.reader.TextReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class TextReaderImpl implements TextReader {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public String readTextFromFile(String pathToFile) throws TextCustomException {
        String text;

        try {
            text = Files.readString(Paths.get(pathToFile));

        } catch (FileNotFoundException e) {
            logger.error("File with path " + pathToFile + " is not found", e);
            throw new TextCustomException("File with path " + pathToFile + " is not found", e);

        } catch (IOException e) {
            logger.error("I/O exception " + pathToFile, e);
            throw new TextCustomException("I/O exception " + pathToFile, e);
        }
        return text;
    }
}
