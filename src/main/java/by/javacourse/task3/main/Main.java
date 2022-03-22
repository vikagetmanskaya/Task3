package by.javacourse.task3.main;

import by.javacourse.task3.entity.TextComponent;
import by.javacourse.task3.entity.TextComposite;
import by.javacourse.task3.exception.TextCustomException;
import by.javacourse.task3.parser.TextParser;
import by.javacourse.task3.parser.impl.ParagraphParser;
import by.javacourse.task3.parser.impl.SentenceParser;
import by.javacourse.task3.parser.impl.TextParserImpl;
import by.javacourse.task3.reader.TextReader;
import by.javacourse.task3.reader.impl.TextReaderImpl;
import by.javacourse.task3.service.TextService;
import by.javacourse.task3.service.impl.TextServiceImpl;

public class Main {
    public static void main(String[] args) throws TextCustomException {
        TextReader textReader = new TextReaderImpl();
        String text = textReader.readTextFromFile("src/main/resources/text.txt");
        TextParser parser = new TextParserImpl();
        TextService textService = new TextServiceImpl();
        TextComposite textComposite = parser.parse(text);
        System.out.println(text);
        //System.out.println(textService.deleteSentencesWithLessWords(textComposite, 2));
        //System.out.println(textService.findSentenceWithLongestWord(parser.parse(text)));


    }
}
