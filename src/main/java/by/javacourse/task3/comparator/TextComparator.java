package by.javacourse.task3.comparator;

import by.javacourse.task3.entity.TextComponent;

import java.util.Comparator;

public class TextComparator implements Comparator<TextComponent> {
    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        return o1.getComponents().size() - o2.getComponents().size();
    }
}
