package com.pfg2;

public class CustomObject {

    private boolean isChecked;

    private String label;

    public CustomObject() {
        //
    }

    public CustomObject(int i) {
        this.label = String.format("Label %s", i);
    }

    public CustomObject(String label) {
        this.label = label;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return this.label;
    }
}
