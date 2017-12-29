package com.zaaach.tabradiobutton;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;

/**
 * @Author: Bro0cL
 * @Date: 2017/12/27 16:25
 * @Discription: 图片和文字居中的RadioButton，只处理左边或上边有图片的情况
 */

public class TabRadioButton extends android.support.v7.widget.AppCompatRadioButton {
    private Drawable leftDrawable;
    private Drawable topDrawable;
    private int drawablePadding;
    private String text;
    private float textHeight = 0;
    private float textWidth = 0;

    public TabRadioButton(Context context) {
        this(context, null);
    }

    public TabRadioButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TabRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {
        setClickable(true);
        setFocusable(true);
        setGravity(Gravity.CENTER);
        text = getText().toString();
        if (TextUtils.isEmpty(text)){
            setTextSize(0);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Drawable[] drawables = getCompoundDrawables();
        leftDrawable = drawables[0];
        topDrawable = drawables[1];

        textWidth = getFontWidth(getPaint(), text);
        textHeight = getFontHeight(getPaint());

        drawablePadding = getCompoundDrawablePadding();

        int drawableWidth;
        int drawableHeight;
        //图片在文字左边
        if (leftDrawable != null && topDrawable == null){
            drawableWidth = leftDrawable.getIntrinsicWidth();
            drawableHeight = leftDrawable.getIntrinsicHeight();
            int left = (int) ((this.getWidth() - drawableWidth - drawablePadding - textWidth) / 2);
            leftDrawable.setBounds(left, 0, left + drawableWidth, drawableHeight);
        }
        //图片在文字上边
        if (topDrawable != null && leftDrawable == null){
            drawableWidth = topDrawable.getIntrinsicWidth();
            drawableHeight = topDrawable.getIntrinsicHeight();
            int top = (int) ((this.getHeight() - drawableHeight - drawablePadding - textHeight) / 2);
            topDrawable.setBounds(0, top, drawableWidth, top + drawableHeight);
        }
        super.onDraw(canvas);
    }

    private float getFontWidth(Paint paint, String text) {
        return paint.measureText(text);
    }

    private float getFontHeight(Paint paint){
        Paint.FontMetrics fm = paint.getFontMetrics();
        return fm.descent - fm.ascent;
    }
}
