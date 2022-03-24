package by.javacourse.task3.service.impl;

import by.javacourse.task3.comparator.TextComparator;
import by.javacourse.task3.entity.TextComponent;
import by.javacourse.task3.entity.TextComponentType;
import by.javacourse.task3.entity.TextComposite;
import by.javacourse.task3.exception.TextCustomException;
import by.javacourse.task3.service.TextService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class TextServiceImpl implements TextService {
    private static final Logger logger = LogManager.getLogger();
    public static final String VOWELS_REGEX = "[aAeEiIoOuUyY]";
    public static final String CONSONANTS_REGEX = "[qQwWrRtTpPsSdDfFgGhHjJkKlLzZxXcCvVbBnNmM]";


    @Override
    public List<TextComponent> sortParagraphs(TextComposite textComposite) throws TextCustomException {
        check(textComposite, TextComponentType.TEXT);
        List<TextComponent> result = textComposite.getComponents();
        result.sort(new TextComparator());
        return result;
    }

    @Override
    public List<TextComponent> findSentenceWithLongestWord(TextComposite textComposite) throws TextCustomException {
        check(textComposite, TextComponentType.TEXT);
        int maxLength = 0;
        List<TextComponent> result = new ArrayList<>();
        List<TextComponent> paragraphs = textComposite.getComponents();
        for (TextComponent paragraph : paragraphs) {
            List<TextComponent> sentences = paragraph.getComponents();
            for (TextComponent sentence : sentences) {
                List<TextComponent> lexemes = sentence.getComponents();
                for (TextComponent lexeme : lexemes) {
                    List<TextComponent> wordsWithPunctuation = lexeme.getComponents();
                    for (TextComponent word : wordsWithPunctuation) {
                        if (word.getType() == TextComponentType.WORD && word.getComponents().size() > maxLength) {
                            maxLength = word.getComponents().size();
                            result.clear();
                            result.add(sentence);
                        }
                    }
                }
            }
        }
        return result;
    }

    @Override
    public void deleteSentencesWithLessWords(TextComposite textComposite, int wordsAmount) throws TextCustomException {
        check(textComposite, TextComponentType.TEXT);
        for (TextComponent paragraph : textComposite.getComponents()) {
            paragraph.getComponents().removeIf(sentence -> sentence.getComponents().size() < wordsAmount);
        }
        textComposite.getComponents().removeIf(paragraph -> paragraph.getComponents().size() == 0);

    }


    @Override
    public Map<String, Integer> findRepeatWords(TextComposite textComposite) throws TextCustomException {
        check(textComposite, TextComponentType.TEXT);
        Map<String, Integer> result = new LinkedHashMap<>();
        List<TextComponent> paragraphs = textComposite.getComponents();
        for (TextComponent paragraph : paragraphs) {
            List<TextComponent> sentences = paragraph.getComponents();
            for (TextComponent sentence : sentences) {
                List<TextComponent> lexemes = sentence.getComponents();
                for (TextComponent lexeme : lexemes) {
                    List<TextComponent> wordsAndPunctuations = lexeme.getComponents();
                    for (TextComponent word : wordsAndPunctuations) {
                        if (word.getType() == TextComponentType.WORD) {
                            int counter = 1;
                            String wordWithoutCase = word.toString().toUpperCase();
                            if (result.containsKey(wordWithoutCase)) {
                                counter = result.get(wordWithoutCase) + 1;

                            }
                            result.put(wordWithoutCase, counter);


                        }

                    }

                }

            }

        }
        return result;
    }

    @Override
    public Map<Integer, Integer> countVowelsAndConsonants(TextComponent sentence) throws TextCustomException {
        check(sentence, TextComponentType.SENTENCE);
        int counter_vowels = 0;
        int counter_consonants = 0;
        List<TextComponent> lexemes = sentence.getComponents();
        Map<Integer, Integer> countSymbol;
        for (TextComponent lexeme : lexemes) {

            List<TextComponent> wordsAndPunctuations = lexeme.getComponents();

            for (TextComponent word : wordsAndPunctuations) {
                if (word.getType() == TextComponentType.WORD) {
                    List<TextComponent> symbols = word.getComponents();
                    for (TextComponent symbol : symbols) {

                        if (symbol.toString().matches(VOWELS_REGEX)) {
                            counter_vowels++;
                        } else if (symbol.toString().matches(CONSONANTS_REGEX)) {
                            counter_consonants++;
                        }
                    }
                }
            }
        }
        countSymbol = Collections.singletonMap(counter_vowels, counter_consonants);
        return countSymbol;
    }

    private void check(TextComponent textComponent, TextComponentType textComponentType) throws TextCustomException {
        if (textComponent == null || textComponent.getType() != textComponentType) {
            logger.error("Component is incorrect");
            throw new TextCustomException("Component is incorrect");
        }
    }
}
