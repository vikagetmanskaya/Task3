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

    @Override
    public TextComponentType getType() {
        return textComponentType;
    }
    @Override
    public List<TextComponent> getComponents() {
        return components;
    }
    @Override
    public void setComponents(List<TextComponent> components) {
        this.components = components;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + ((components == null) ? 0 : components.hashCode());
        result = 31 * result + ((textComponentType == null) ? 0 : textComponentType.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        TextComposite textComposite = (TextComposite) obj;

        return components.equals(textComposite.components) && textComponentType.equals(textComposite.textComponentType);
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String delimiter = textComponentType.getDelimiter();
        for (TextComponent textComponent : components) {
            stringBuilder.append(" " + textComponent.getType() + " [").append(textComponent).append("]").append(delimiter);
        }
        return stringBuilder.toString();
    }
}
