package org.codeandmagic.android;

/**
 * Created by evelina on 16/01/2014.
 */
public abstract class TextStyleExtractor {

    public abstract TextStyle[] getTextStyles();

    public TextStyle getFromTextStyle(String textStyleName) {
        for (TextStyle textStyle : getTextStyles()) {
            if (textStyle.getName().equals(textStyleName)) {
                return textStyle;
            }
        }
        return null;
    }
}
