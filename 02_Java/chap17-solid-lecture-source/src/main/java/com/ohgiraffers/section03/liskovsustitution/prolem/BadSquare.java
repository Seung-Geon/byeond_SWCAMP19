package com.ohgiraffers.section03.liskovsustitution.prolem;

public class BadSquare extends BadRectangle {
    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width); // LSP 위반
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        super.setWidth(height); // LSP 위반
    }
}
