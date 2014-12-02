package ch04.ex02;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Greeting {

    private String text = "";
    private StringProperty textProperty;

    public final StringProperty textProperty() {
        if (textProperty == null) {
            textProperty = new SimpleStringProperty(text);
            text = null;
        }
        return textProperty;
    }

    public final String getText() {
        if (textProperty == null)
            return text;
        else
            return textProperty.get();
    }

    public final void setText(String text) {
        if (textProperty == null)
            this.text = text;
        else
            textProperty.set(text);
    }

    public static void main(String[] args) {
        Greeting greeting = new Greeting();
        greeting.setText("hello");
        assert greeting.getText().equals("hello");
        assert greeting.textProperty == null;

        greeting.textProperty().set("hi");
        assert greeting.getText().equals("hi");
        assert greeting.textProperty != null;
    }

}
