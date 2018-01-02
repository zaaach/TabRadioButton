package com.zaaach.tabradiobutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;

/**
 * @Author: Bro0cL
 * @Date: 2017/12/27 16:25
 * 图片和文字居中的RadioButton，只处理左边或上边有图片的情况，
 * 可以启用默认的缩放动画：在手指按下时会有缩小动画，在手指离开时有复原动画
 */

public class TabRadioButton extends android.support.v7.widget.AppCompatRadioButton {
    /** 默认缩放动画，缩放比例为3/4 */
    private static final float DEFAULT_SCALE_RATE = 0.75f;
    /** 默认缩放动画的时长 */
    private static final int DEFAULT_DURATION = 200;
    /** 如果drawable的size为-1，则显示其默认大小 */
    private static final int DEFAULT_DRAWABLE_SIZE = -1;

    private Drawable leftDrawable;
    private Drawable topDrawable;
    private Drawable rightDrawable;
    private Drawable bottomDrawable;
    /** 指定drawable的大小 */
    private int drawableSize;
    private int drawablePadding;
    private String text;
    private float textHeight;
    private float textWidth;

    /** 是否启用动画效果 */
    private boolean enableAnimation;
    /** 手指按下时的动画 */
    private Animator pressedAnimator;
    /** 手指离开时的动画 */
    private Animator releasedAnimator;
    private long duration;
    private float scaleRate;

    public TabRadioButton(Context context) {
        this(context, null);
    }

    public TabRadioButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TabRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        parseAttrs(context, attrs);
        init();
    }

    private void parseAttrs(Context context, AttributeSet attrs) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.TabRadioButton);
        drawableSize = array.getDimensionPixelSize(R.styleable.TabRadioButton_trb_drawable_size, DEFAULT_DRAWABLE_SIZE);
        scaleRate = array.getFloat(R.styleable.TabRadioButton_trb_scale_rate, DEFAULT_SCALE_RATE);
        duration = array.getInteger(R.styleable.TabRadioButton_trb_duration, DEFAULT_DURATION);
        enableAnimation = array.getBoolean(R.styleable.TabRadioButton_trb_enable_animation, false);
        drawableSize = drawableSize < 0
                ? -1
                : drawableSize;
        array.recycle();
    }

    private void init() {
        setClickable(true);
        setFocusable(true);
        setGravity(Gravity.CENTER);
        text = getText().toString();
        if (TextUtils.isEmpty(text)){
            setTextSize(0);
        }

        //初始化动画
        pressedAnimator = getAnimator(true);
        releasedAnimator = getAnimator(false);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.performClick();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                //手指按下时开始动画
                if (enableAnimation && !pressedAnimator.isRunning()){
                    pressedAnimator.start();
                }
                break;
            case MotionEvent.ACTION_UP:
                //手指离开时进行复原
                if (enableAnimation && !releasedAnimator.isRunning()){
                    releasedAnimator.start();
                }
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean performClick() {
        return super.performClick();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Drawable[] drawables = getCompoundDrawables();
        leftDrawable = drawables[0];
        topDrawable = drawables[1];
        rightDrawable = drawables[2];
        bottomDrawable = drawables[3];

        textWidth = getFontWidth(getPaint(), text);
        textHeight = getFontHeight(getPaint());

        drawablePadding = getCompoundDrawablePadding();

        int drawableWidth;
        int drawableHeight;
        //只有左边有图片
        if (leftDrawable != null && topDrawable == null && rightDrawable == null && bottomDrawable == null){
            drawableWidth = drawableSize < 0
                    ? leftDrawable.getIntrinsicWidth()
                    : drawableSize;
            drawableHeight = drawableSize < 0
                    ? leftDrawable.getIntrinsicHeight()
                    : drawableSize;
            int left = (int) ((this.getWidth() - drawableWidth - drawablePadding - textWidth) / 2);
            leftDrawable.setBounds(left, 0, left + drawableWidth, drawableHeight);
        }
        //只有上边有图片
        if (topDrawable != null && leftDrawable == null && rightDrawable == null && bottomDrawable == null){
            drawableWidth = drawableSize < 0
                    ? topDrawable.getIntrinsicWidth()
                    : drawableSize;
            drawableHeight = drawableSize < 0
                    ? topDrawable.getIntrinsicHeight()
                    : drawableSize;
            int top = (int) ((this.getHeight() - drawableHeight - drawablePadding - textHeight) / 2);
            topDrawable.setBounds(0, top, drawableWidth, top + drawableHeight);
        }
        //指定drawable显示的大小
        setCompoundDrawables(leftDrawable, topDrawable, rightDrawable, bottomDrawable);
        super.onDraw(canvas);
    }

    /**
     * @param whenPressed 是否是按下时的动画
     * @return
     */
    private Animator getAnimator(boolean whenPressed) {
        return getDefaultScaleAnimator(whenPressed ? 1.0f : scaleRate,
                whenPressed ? scaleRate : 1.0f, duration);
    }

    private Animator getDefaultScaleAnimator(float from, float to, long duration){
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(this, "ScaleX", from, to);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(this, "ScaleY", from, to);
        animatorSet.play(animatorX).with(animatorY);
        animatorSet.setDuration(duration);
        animatorSet.setTarget(this);
        return animatorSet;
    }

    private float getFontWidth(Paint paint, String text) {
        return paint.measureText(text);
    }

    private float getFontHeight(Paint paint){
        Paint.FontMetrics fm = paint.getFontMetrics();
        return fm.descent - fm.ascent;
    }

    public void setEnableAnimation(boolean enableAnimation) {
        this.enableAnimation = enableAnimation;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public void setScaleRate(float scaleRate) {
        this.scaleRate = scaleRate;
    }
}
