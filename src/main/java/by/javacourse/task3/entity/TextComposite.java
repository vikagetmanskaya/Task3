package by.javacourse.task3.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent{
    private List<TextComponent> components = new ArrayList<>();
    private TextComponentType textComponentType;

    public TextComposite(TextComponentType textComponentType) {
        this.textComponentType = textComponentType;
    }

    @Override
    public boolean add(TextComponent textComponent) {
        return components.add(textComponent);
    }

    @Override
    public boolean remove(TextComponent textComponent) {
        return components.remove(textComponent);
    }
}
