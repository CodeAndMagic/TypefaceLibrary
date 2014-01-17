package org.codeandmagic.android;

/**
 * Implementation of {@TextStyleExtractor} for the SourceProSans font.
 */
public class SourceSansProTextStyleExtractor extends TextStyleExtractor {

    private static final SourceSansProTextStyleExtractor INSTANCE = new SourceSansProTextStyleExtractor();

    public static TextStyleExtractor getInstance() {
        return INSTANCE;
    }

    @Override
    public TextStyle[] getTextStyles() {
        return SourceSansProTextStyle.values();
    }
}
