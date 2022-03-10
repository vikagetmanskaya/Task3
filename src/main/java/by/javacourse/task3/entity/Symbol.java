package by.javacourse.task3.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Symbol implements TextComponent{
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
}
