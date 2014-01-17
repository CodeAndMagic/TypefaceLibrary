package org.codeandmagic.android;

/**
 * Implementation of {@link TextStyle} defining the possible values for the 'textStyle' attribute
 * using the Roboto font.
 * Created by evelina on 16/01/2014.
 */
public enum RobotoTextStyle implements TextStyle {

    NORMAL("normal", "roboto/Roboto-Regular.ttf"),
    LIGHT("light", "roboto/Roboto-Light.ttf"),
    BOLD("bold", "roboto/Roboto-Bold.ttf"),
    CONDENSED("condensed", "roboto/RobotoCondensed-Regular.ttf"),
    CONDENSED_LIGHT("condensedLight", "roboto/RobotoCondensed-Light.ttf"),
    CONDENSED_BOLD("condensedBold", "roboto/RobotoCondensed-Bold.ttf");

    private String mName;
    private String mFontName;

    RobotoTextStyle(String name, String fontName) {
        mName = name;
        mFontName = fontName;
    }

    @Override
    public String getFontName() {
        return mFontName;
    }

    @Override
    public String getName() {
        return mName;
    }
}
