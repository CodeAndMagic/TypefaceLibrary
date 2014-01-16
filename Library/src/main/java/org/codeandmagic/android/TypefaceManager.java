package org.codeandmagic.android;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility class used to apply a custom {@link Typeface} to a {@link TextView} subclass.
 */
public class TypefaceManager {

    private static final TypefaceManager INSTANCE = new TypefaceManager();

    public static TypefaceManager getInstance() {
        return INSTANCE;
    }

    public static void setTextStyleExtractor(TextStyleExtractor textStyleExtractor) {
        INSTANCE.mTextStyleExtractor = textStyleExtractor;
    }

    private final Map<TextStyle, Typeface> mTypefaces = new HashMap<TextStyle, Typeface>();
    private TextStyleExtractor mTextStyleExtractor;

    private TypefaceManager() {
        // Singleton
    }

    /**
     * Method called from the {@TypefaceTextView} constructor to
     * apply a custom {@link TextStyle} defined in the application theme.
     *
     * @param textView the {@link TextView} to have the {@link TextStyle} applied
     * @param context  the {@link Context} of the {@link TextView}
     * @param attrs    the {@link AttributeSet} of the {@link TextView}
     */
    public void applyTypeface(TextView textView, Context context, AttributeSet attrs) {
        final TypedArray styleValues = context.obtainStyledAttributes(attrs, new int[]{android.R.attr.textAppearance});
        final int textAppearanceStyleId = styleValues.getResourceId(0, 0);
        if (textAppearanceStyleId != -1) {
            final ContextThemeWrapper themedContext = new ContextThemeWrapper(context, textAppearanceStyleId);
            final TypedArray textAppearanceStyleValues = themedContext.obtainStyledAttributes(new int[]{R.attr.textStyle});
            final int textStyleOrdinal = textAppearanceStyleValues.getInt(0, -1);
            if (textStyleOrdinal != -1) {
                final TextStyle textStyle = mTextStyleExtractor.getFromTextStyleOrdinal(textStyleOrdinal);
                applyTypeface(textView, textStyle);
            }
            textAppearanceStyleValues.recycle();
        }
        styleValues.recycle();
    }

    /**
     * Method called from code to apply a custom {@link TextStyle}.
     *
     * @param textView  the {@link TextView} to have the {@link TextStyle} applied
     * @param textStyle the {@link TextStyle} to be applied
     */
    public void applyTypeface(TextView textView, TextStyle textStyle) {
        final Typeface typeface = getTypeface(textView.getContext(), textStyle);
        if (typeface != null) {
            textView.setTypeface(typeface);
        }
    }

    /**
     * Apply a {@link Typeface} for a given {@link TextStyle}.
     *
     * @param context   the {@link Context} of the {@link TextView}
     * @param textStyle the {@link TextStyle} to be applied
     * @return the {@link Typeface} corresponding to the {@link TextStyle}, if defined
     */
    private Typeface getTypeface(Context context, TextStyle textStyle) {
        if (textStyle == null) {
            throw new IllegalArgumentException("Param 'textStyle' can't be null.");
        }
        if (mTypefaces.containsKey(textStyle)) {
            return mTypefaces.get(textStyle);
        }

        final Typeface typeface = Typeface.createFromAsset(context.getAssets(), textStyle.getFontName());
        if (typeface == null) {
            throw new RuntimeException("Can't create Typeface for font '" + textStyle.getFontName() + "'");
        }

        mTypefaces.put(textStyle, typeface);
        return typeface;
    }
}
