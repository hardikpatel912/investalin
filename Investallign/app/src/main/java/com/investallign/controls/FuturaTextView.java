package com.investallign.controls;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.investallign.configuration.AppConstants;


public class FuturaTextView extends TextView {

    public FuturaTextView(Context context) {
        super(context);
        setFont();
    }
    public FuturaTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont();
    }
    public FuturaTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setFont();
    }

    private void setFont() {
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), AppConstants.APP_FONT);
        setTypeface(font, Typeface.NORMAL);
    }


}