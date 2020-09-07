package com.orangeink.eventz.utility;

import android.content.Context;
import android.util.TypedValue;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;

public class Utility {

    public static int marginConvertToSp(int margin, Context context) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, margin, context.getResources().getDisplayMetrics());
    }

    public static void setupBottomMargin(CardView view, Context context, int bottom) {
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int marginStartEnd = marginConvertToSp(10, context);
        int marginTop = marginConvertToSp(10, context);
        int marginBottom = marginConvertToSp(bottom, context);
        layoutParams.setMargins(marginStartEnd, marginTop, marginStartEnd, marginBottom);
    }
}
