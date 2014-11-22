package ch04.ex02;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Greeting {

    private String text = "";

    public Greeting(String text) {
        this.text = text;
    }

    public final StringProperty textProperty() {
        return new SimpleStringProperty(text);
    }

    public final String getText() {
        return text;
    }

    public final void setText(String text) {
        this.text = text;
    }

    public static void main(String[] args) {
        Greeting greeting = new Greeting("hello");
        StringProperty stringProperty = greeting.textProperty();
        assert stringProperty.getValue().equals("hello");
        assert greeting.getText().equals("hello");
    }

}
