package by.javacourse.task3.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Symbol implements TextComponent {
    private static final Logger logger = LogManager.getLogger();
    private TextComponentType textComponentType;
    private char character;

    public Symbol(TextComponentType textComponentType, char character) {
        this.textComponentType = textComponentType;
        this.character = character;
    }

    @Override
    public boolean add(TextComponent textComponent) {
        logger.warn("Unsupported operation of add symbol");
        throw new UnsupportedOperationException("Unsupported operation of add symbol");
    }

    @Override
    public boolean remove(TextComponent textComponent) {
        logger.warn("Unsupported operation of remove symbol");
        throw new UnsupportedOperationException("Unsupported operation of remove symbol");
    }


    @Override
    public TextComponentType getType() {
        return textComponentType;
    }

    @Override
    public List<TextComponent> getComponents() {
        throw new UnsupportedOperationException("cant get element from leaf");
    }


    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + character;
        result = 31 * result + ((textComponentType == null) ? 0 : textComponentType.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Symbol symbol = (Symbol) obj;

        return character == symbol.character && textComponentType.equals(symbol.textComponentType);
    }

    @Override
    public String toString() {
        return String.valueOf(character);
    }
}
