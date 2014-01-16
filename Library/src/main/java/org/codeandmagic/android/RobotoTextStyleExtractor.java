package org.codeandmagic.android;

import android.app.Application;

/**
 * Implementation of {@TextStyleExtractor} which defines what fonts are used by the
 * {@link Application}.
 */
public class RobotoTextStyleExtractor implements TextStyleExtractor {

    private static final RobotoTextStyleExtractor INSTANCE = new RobotoTextStyleExtractor();

    public static TextStyleExtractor getInstance() {
        return INSTANCE;
    }

    @Override
    public TextStyle[] getTextStyles() {
        return RobotoTextStyle.values();
    }

    @Override
    public TextStyle getFromTextStyleOrdinal(int textStyleOrdinal) {
        return getTextStyles()[textStyleOrdinal];
    }
}
