package by.javacourse.task3.entity;

import java.util.List;

public interface TextComponent {
    TextComponentType getType();

    public boolean add(TextComponent textComponent);

    public boolean remove(TextComponent textComponent);

    List<TextComponent> getComponents();

}

