package com.xoquin.centroestudios.view;

public class TableStyle {
    private String vertical;
    private String horizontal;
    private String cross;

    public TableStyle(String vertical, String horizontal, String cross) {
        this.vertical = vertical;
        this.horizontal = horizontal;
        this.cross = cross;
    }

    public String getVertical() {
        return this.vertical;
    }

    public void setVertical(String vertical) {
        this.vertical = vertical;
    }

    public String getHorizontal() {
        return this.horizontal;
    }

    public void setHorizontal(String horizontal) {
        this.horizontal = horizontal;
    }

    public String getCross() {
        return this.cross;
    }

    public void setCross(String cross) {
        this.cross = cross;
    }
}
