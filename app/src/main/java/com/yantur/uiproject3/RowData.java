package com.yantur.uiproject3;

/**
 * Created by Artur on 3/21/2016.
 */
public class RowData {

    private String title;
    private boolean hidden;
    private boolean checked;
    private boolean color;

    public RowData(String title, boolean hidden, boolean checked, boolean color) {
        this.title = title;
        this.hidden = hidden;
        this.checked = checked;
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }
}
