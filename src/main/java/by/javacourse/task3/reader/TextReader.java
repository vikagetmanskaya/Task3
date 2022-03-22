package by.javacourse.task3.reader;

import by.javacourse.task3.exception.TextCustomException;

public interface TextReader {
    String readTextFromFile(String pathToFile) throws TextCustomException;
}
