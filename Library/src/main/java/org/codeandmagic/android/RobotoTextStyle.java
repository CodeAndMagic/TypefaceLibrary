package org.codeandmagic.android;

/**
 * Created by evelina on 16/01/2014.
 */
public enum RobotoTextStyle implements TextStyle {

    NORMAL("roboto/Roboto-Regular.ttf"),
    LIGHT("roboto/Roboto-Light.ttf"),
    BOLD("roboto/Roboto-Bold.ttf"),
    CONDENSED("roboto/RobotoCondensed-Regular.ttf"),
    CONDENSED_LIGHT("roboto/RobotoCondensed-Light.ttf"),
    CONDENSED_BOLD("roboto/RobotoCondensed-Bold.ttf");

    private String mFontName;

    RobotoTextStyle(String fontName) {
        mFontName = fontName;
    }

    @Override
    public String getFontName() {
        return mFontName;
    }
}
