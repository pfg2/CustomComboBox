package com.pfg2.component.customcombobox;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;

import com.pfg2.CustomObject;

public class CustomCell extends ListCell<CustomObject> {

    private final CustomComboBox customComboBox;

    private final CheckBox checkBox;

    private final Label label;

    public CustomCell(CustomComboBox customComboBox) {
        this.customComboBox = customComboBox;
        this.checkBox       = new CheckBox();
        this.label          = new Label();
        this.label.setOnMousePressed(e -> {
            this.checkBox.setSelected(!this.checkBox.isSelected());
            e.consume();
        });
        this.checkBox.selectedProperty().addListener((o, old, n) -> {
            getItem().setChecked(n);
            updateItem(getItem(), false);
            int selectedIndex =
                this.customComboBox.getItems().indexOf(getItem());
            this.customComboBox.getSelectionModel().select(-1);
            this.customComboBox.getSelectionModel().select(selectedIndex);
        });
    }

    @Override
    protected void updateItem(CustomObject customObject, boolean empty) {
        super.updateItem(customObject, empty);
        if (customObject != null) {
            if (customObject.isChecked()) {
                this.checkBox.setSelected(true);
            }
            this.label.setText(customObject.getLabel());
            HBox hBox = new HBox();
            hBox.setSpacing(5);
            hBox.getChildren().add(checkBox);
            hBox.getChildren().add(label);
            this.setGraphic(hBox);
        }
    }

    @Override
    public String toString() {
        return this.label.getText();
    }
}
