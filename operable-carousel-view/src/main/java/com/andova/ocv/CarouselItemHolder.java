package com.andova.ocv;

import android.content.Context;
import android.graphics.Matrix;
import android.os.Build;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Carousel item holder. Contains specific information about carousel item.
 *
 * @author Carousel view
 */
public class CarouselItemHolder extends FrameLayout implements Comparable<CarouselItemHolder> {

    private int mIndex;
    private float mCurrentAngle;
    private boolean mDrawn;
    private boolean mIsDispatchTouchEventEnable;

    private View mContentView;

    // Item's coordinates in carousel view
    private float mItemX;
    private float mItemY;
    private float mItemZ;
    private float mScale;

    private float mAlpha;
    // It's needed to find screen coordinates
    private Matrix mCIMatrix;
    private OnClickListener mOnItemClickListener;

    private static final LayoutParams CHILD_PARAMS = new LayoutParams(
            LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);

    @SuppressWarnings("unused")
    private CarouselItemHolder(Context context) {
        super(context);
    }

    CarouselItemHolder(Context context, View childView) {
        super(context);
        initWidget(childView);
    }

    @Override
    public void offsetLeftAndRight(int offset) {
        super.offsetLeftAndRight(offset);
        /* DON'T REMOVE THIS!!! NEEDED FOR CAROUSEL APPROPRIATE WORK */
        invalidate();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return mIsDispatchTouchEventEnable && super.dispatchTouchEvent(ev);
    }

    @Override
    public float getAlpha() {
        return mAlpha;
    }

    /* ******************************************************************** */
    /* ***************************** Comparable  ************************** */
    /* ******************************************************************** */

    @Override
    public int compareTo(@NonNull CarouselItemHolder another) {
        return (int) (another.getItemZ() - mItemZ);
    }

    /* ***************************************************************************** */
    /* ******************************** Utility API ******************************** */
    /* ***************************************************************************** */

    View getContentView() {
        return mContentView;
    }

    OnClickListener getOnItemClickListener() {
        return mOnItemClickListener;
    }

    void setOnItemClickListener(OnClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    boolean isEnable() {
        return mIsDispatchTouchEventEnable;
    }

    void setDispatchTouchEventEnable(boolean isEnable) {
        mIsDispatchTouchEventEnable = isEnable;
    }

    public int getIndex() {
        return mIndex;
    }

    public float getCurrentAngle() {
        return mCurrentAngle;
    }

    public float getItemX() {
        return mItemX;
    }

    public float getItemY() {
        return mItemY;
    }

    public float getItemScale() {
        return mScale;
    }

    public void setItemZ(float z) {
        mItemZ = z;
    }

    public float getItemZ() {
        return mItemZ;
    }

    boolean isDrawn() {
        return mDrawn;
    }

    Matrix getCIMatrix() {
        return mCIMatrix;
    }

    void setIndex(int index) {
        mIndex = index;
    }

    void setCurrentAngle(float currentAngle) {
        mCurrentAngle = currentAngle;
    }

    void setItemX(float x) {
        mItemX = x;
    }

    void setItemY(float y) {
        mItemY = y;
    }

    void setItemScale(float scale) {
        mScale = scale;
    }

    void setDrawn(boolean drawn) {
        mDrawn = drawn;
    }

    void setCIMatrix(Matrix mMatrix) {
        mCIMatrix = mMatrix;
    }

    void setItemAlpha(float angleDeg, int minAlpha) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            double percent = 1.0 - Math.sin(Math.toRadians(angleDeg / 2.0));
            percent = Math.pow(percent, 2.0);
            double alpha = Math.max(percent, minAlpha / 255.0);
            mAlpha = (float) alpha;
            setAlpha(mAlpha);
        }
    }

    private void initWidget(View childView) {
        mContentView = childView;
        final LayoutParams params = new LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        this.setLayoutParams(params);
        this.addView(childView, CHILD_PARAMS);
    }
}