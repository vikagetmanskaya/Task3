package by.javacourse.task3.main;

import by.javacourse.task3.entity.TextComposite;
import by.javacourse.task3.exception.TextCustomException;
import by.javacourse.task3.parser.BaseTextParser;
import by.javacourse.task3.parser.impl.TextParser;
import by.javacourse.task3.reader.TextReader;
import by.javacourse.task3.reader.impl.TextReaderImpl;
import by.javacourse.task3.service.TextService;
import by.javacourse.task3.service.impl.TextServiceImpl;

public class Main {
    public static void main(String[] args) throws TextCustomException {
        TextReader textReader = new TextReaderImpl();
        String text = textReader.readTextFromFile("src/main/resources/text.txt");
        BaseTextParser parser = new TextParser();
        TextService textService = new TextServiceImpl();
        TextComposite textComposite = parser.parse(text);
        //TextComponent sentence = textComposite.getComponents().get(2).getComponents().get(0);
        //System.out.println(textService.findSentenceWithLongestWord(parser.parse(text)));
        //System.out.println(textService.countVowelsAndConsonants(sentence));
       System.out.println(textComposite);
        //textService.deleteSentencesWithLessWords(textComposite, 25);
        //System.out.println(textComposite.toString().replaceAll("\n", "").replaceAll("\r", ""));
       // System.out.println(textService.findRepeatWords(textComposite));


    }
}
