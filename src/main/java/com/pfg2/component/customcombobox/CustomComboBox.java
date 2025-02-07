package com.pfg2.component.customcombobox;

import java.util.List;
import java.util.stream.Collectors;

import javafx.event.EventHandler;
import javafx.scene.AccessibleAction;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.util.StringConverter;

import com.pfg2.CustomObject;

public class CustomComboBox extends ComboBox<CustomObject> {

    private final EventHandler<MouseEvent> eventHandler;

    public CustomComboBox(List<CustomObject> customObjects) {
        this.setCellFactory(l -> new CustomCell(this));
        this.getItems().addAll(customObjects);
        this.eventHandler = e -> {
            this.collapse();
            e.consume();
        };
        this.onHiddenProperty().addListener((ob, old, n) -> {
            this.getScene().removeEventFilter(
                MouseEvent.MOUSE_PRESSED,
                this.eventHandler
            );
        });
        this.setConverter(new StringConverter<>() {

            @Override
            public String toString(CustomObject customObject) {
                return getItems().stream().filter(CustomObject::isChecked).map(
                    CustomObject::getLabel).collect(Collectors.joining(", "));
            }

            @Override
            public CustomObject fromString(String s) {
                return null;
            }
        });
    }

    @Override
    public void show() {
        super.show();
        this.getScene().addEventFilter(
            MouseEvent.MOUSE_PRESSED,
            this.eventHandler
        );
    }

    @Override
    public void hide() {
        //
    }

    public void collapse() {
        super.hide();
        this.executeAccessibleAction(AccessibleAction.COLLAPSE);
    }
}
