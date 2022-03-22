package by.javacourse.task3.service;

import by.javacourse.task3.entity.TextComponent;
import by.javacourse.task3.entity.TextComposite;
import by.javacourse.task3.exception.TextCustomException;

import java.util.List;
import java.util.Map;

public interface TextService {
    List<TextComponent> sortParagraphs(TextComposite textComposite) throws TextCustomException;

    List<TextComponent> findSentenceWithLongestWord(TextComposite textComposite) throws TextCustomException;

    List<TextComponent> deleteSentencesWithLessWords(TextComposite composite, int wordsAmount) throws TextCustomException;

    Map<String, Integer> findRepeatWords(TextComposite textComposite) throws TextCustomException;

    Map<Integer, Integer> countVowelsAndConsonants(TextComponent sentence) throws TextCustomException;
}
