package by.javacourse.task3.entity;

public enum TextComponentType {
    TEXT("\n\t"),
    PARAGRAPH("\n"),
    SENTENCE(""),
    LEXEME(" "),
    WORD(""),
    LETTER(""),
    PUNCTION_MARK("");

    private String delimiter;

    TextComponentType(String delimiter) {
        this.delimiter = delimiter;
    }
}
