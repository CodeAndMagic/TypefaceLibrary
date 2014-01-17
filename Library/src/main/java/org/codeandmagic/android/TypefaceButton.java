package org.codeandmagic.android;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by evelina on 17/01/2014.
 */
public class TypefaceButton extends Button {

    public TypefaceButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypefaceManager.getInstance().applyTypeface(this, context, attrs);
    }

    public void setTextStyle(TextStyle textStyle) {
        TypefaceManager.getInstance().applyTypeface(this, textStyle);
    }
}
