package by.javacourse.task3.entity;

public enum TextComponentType {
    TEXT("\n\t"),
    PARAGRAPH("\n"),
    SENTENCE("\s"),
    LEXEME(" "),
    WORD("\s"),
    NUMBER(""),
    SYMBOL(""),
    PUNCTUATION_MARK("");

    private String delimiter;

    TextComponentType(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
