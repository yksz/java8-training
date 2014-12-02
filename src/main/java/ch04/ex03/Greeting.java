package ch04.ex03;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Greeting {

    private final String text = "default";
    private StringProperty textProperty;

    public final StringProperty textProperty() {
        if (textProperty == null)
            textProperty = new SimpleStringProperty(text);
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
            textProperty = new SimpleStringProperty(text);
        textProperty.set(text);
    }

    public static void main(String[] args) {
        Greeting greeting1 = new Greeting();
        assert greeting1.getText().equals("default");
        assert greeting1.textProperty == null;
        greeting1.setText("hello");
        assert greeting1.getText().equals("hello");
        assert greeting1.textProperty != null;

        Greeting greeting2 = new Greeting();
        assert greeting2.getText().equals("default");
        assert greeting2.textProperty == null;
        greeting2.textProperty().set("hi");
        assert greeting2.getText().equals("hi");
        assert greeting2.textProperty != null;
    }

}
