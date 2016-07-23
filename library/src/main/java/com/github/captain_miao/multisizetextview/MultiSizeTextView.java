package com.github.captain_miao.multisizetextview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * @author YanLu
 * @since 16/7/23
 */
public class MultiSizeTextView extends TextView {

    private String mDefaultText = "";
    private float  mDefaultTextSize = 14;
    private int    mDefaultTextColor = Color.BLACK;

    private String mBeforeText;
    private int    mBeforeTextColor;
    private float  mBeforeTextSize;

    private String mCenterText;
    private int    mCenterTextColor;
    private float  mCenterTextSize;

    private String mAfterText;
    private int    mAfterTextColor;
    private float  mAfterTextSize;



    public MultiSizeTextView(Context context) {
        this(context, null);
    }

    public MultiSizeTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MultiSizeTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mDefaultText  = getText() != null ? getText().toString() : mDefaultText;
        mDefaultTextSize  = getTextSize();
        mDefaultTextColor = getCurrentTextColor();
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MultiSizeTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mDefaultText  = getText() != null ? getText().toString() : mDefaultText;
        mDefaultTextSize  = getTextSize();
        mDefaultTextColor = getCurrentTextColor();
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MultiSizeTextView);
        mBeforeText = a.getString(R.styleable.MultiSizeTextView_beforeText);
        mBeforeTextColor = a.getColor(R.styleable.MultiSizeTextView_beforeTextColor, mDefaultTextColor);
        mBeforeTextSize = a.getDimension(R.styleable.MultiSizeTextView_beforeTextSize, mDefaultTextSize);

        mCenterText = a.getString(R.styleable.MultiSizeTextView_centerText);
        if(TextUtils.isEmpty(mCenterText) && !TextUtils.isEmpty(mDefaultText)){
            mCenterText = mDefaultText;
        }
        mCenterTextColor = a.getColor(R.styleable.MultiSizeTextView_centerTextColor, mDefaultTextColor);
        mCenterTextSize = a.getDimension(R.styleable.MultiSizeTextView_centerTextSize, mDefaultTextSize);

        mAfterText = a.getString(R.styleable.MultiSizeTextView_afterText);
        mAfterTextColor = a.getColor(R.styleable.MultiSizeTextView_afterTextColor, mDefaultTextColor);
        mAfterTextSize = a.getDimension(R.styleable.MultiSizeTextView_afterTextSize, mDefaultTextSize);

        a.recycle();
        onUpdateContent();
    }


    private SpannableString mSpannableString;

    protected void onUpdateContent() {
        StringBuilder content = new StringBuilder();
        int beforeTextLen = 0;
        if(!TextUtils.isEmpty(mBeforeText)){
            content.append(mBeforeText);
            beforeTextLen = mBeforeText.length();
        }

        int centerTextLen = 0;
        if(!TextUtils.isEmpty(mCenterText)){
            content.append(mCenterText);
            centerTextLen = mCenterText.length();
        }

        int afterTextLen = 0;
        if(!TextUtils.isEmpty(mAfterText)){
            content.append(mAfterText);
            afterTextLen = mAfterText.length();
        }


        mSpannableString = new SpannableString(content);
        if (beforeTextLen > 0) {
            mSpannableString.setSpan(new AbsoluteSizeSpan((int) mBeforeTextSize),
                    0, beforeTextLen, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
            mSpannableString.setSpan(new ForegroundColorSpan(mBeforeTextColor),
                    0, beforeTextLen, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        }

        if (centerTextLen > 0) {
            mSpannableString.setSpan(new AbsoluteSizeSpan((int) mCenterTextSize),
                    beforeTextLen, beforeTextLen + centerTextLen, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
            mSpannableString.setSpan(new ForegroundColorSpan(mCenterTextColor),
                    beforeTextLen, beforeTextLen + centerTextLen, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        }

        if (afterTextLen > 0) {
            mSpannableString.setSpan(new AbsoluteSizeSpan((int) mAfterTextSize),
                    beforeTextLen + centerTextLen, mSpannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
            mSpannableString.setSpan(new ForegroundColorSpan(mAfterTextColor),
                    beforeTextLen + centerTextLen, mSpannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        }


        setText(mSpannableString);
    }


    public String getBeforeText() {
        return mBeforeText;
    }

    public void setBeforeText(String beforeText) {
        mBeforeText = beforeText;
        onUpdateContent();
    }

    public int getBeforeTextColor() {
        return mBeforeTextColor;
    }

    public void setBeforeTextColor(int beforeTextColor) {
        mBeforeTextColor = beforeTextColor;
        onUpdateContent();
    }

    public float getBeforeTextSize() {
        return mBeforeTextSize;
    }

    public void setBeforeTextSize(float beforeTextSize) {
        mBeforeTextSize = beforeTextSize;
        onUpdateContent();
    }

    public String getCenterText() {
        return mCenterText;
    }

    public void setCenterText(String centerText) {
        mCenterText = centerText;
        onUpdateContent();
    }

    public int getCenterTextColor() {
        return mCenterTextColor;
    }

    public void setCenterTextColor(int centerTextColor) {
        mCenterTextColor = centerTextColor;
        onUpdateContent();
    }

    public float getCenterTextSize() {
        return mCenterTextSize;
    }

    public void setCenterTextSize(float centerTextSize) {
        mCenterTextSize = centerTextSize;
        onUpdateContent();
    }

    public String getAfterText() {
        return mAfterText;
    }

    public void setAfterText(String afterText) {
        mAfterText = afterText;
        onUpdateContent();
    }

    public int getAfterTextColor() {
        return mAfterTextColor;
    }

    public void setAfterTextColor(int afterTextColor) {
        mAfterTextColor = afterTextColor;
        onUpdateContent();
    }

    public float getAfterTextSize() {
        return mAfterTextSize;
    }

    public void setAfterTextSize(float afterTextSize) {
        mAfterTextSize = afterTextSize;
        onUpdateContent();
    }
}
