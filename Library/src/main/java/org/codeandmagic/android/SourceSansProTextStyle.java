package org.codeandmagic.android;

/**
 * Implementation of {@link TextStyle} defining the possible values for the 'textStyle' attribute
 * using the SourceSansPro font.
 * Created by evelina on 17/01/2014.
 */
public enum SourceSansProTextStyle implements TextStyle {

    NORMAL("regular", "sourcesanspro/SourceSansPro-Regular.ttf"),
    LIGHT_ITALIC("lightItalic", "sourcesanspro/SourceSansPro-LightItalic.ttf"),
    SEMI_BOLD_ITALIC("semiBoldItalic", "sourcesanspro/SourceSansPro-SemiBoldItalic.ttf"),
    BLACK("black", "sourcesanspro/SourceSansPro-Black.ttf");

    private String mName;
    private String mFontName;

    SourceSansProTextStyle(String name, String fontName) {
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
