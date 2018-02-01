package com.andova.ocv;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;

import static com.andova.ocv.OCVDiameterEnum.OCV_DIAMETER_ENUM_FULL;

/**
 * Defines configuration {@link CarouselOptions} for a {@link CarouselView}.
 * These options can be used when adding a carousel view to your application
 * programmatically (as opposed to via XML).
 *
 * @author Carousel View
 */
public final class CarouselOptions {

    /**
     * Holds max qantity of carousel items
     */
    private int mMaxQuantity = CarouselConfigInfo.MAX_QUANTITY;

    /**
     * Holds min quantity of carousel items
     */
    private int mMinQuantity = CarouselConfigInfo.MIN_QUANTITY;

    /**
     * Default min alpha value.
     */
    private int mMinAlpha = CarouselConfigInfo.MIN_ALPHA;

    /**
     * Max velocity for scrolling.
     */
    private int mMaxScrollingVelocity = CarouselConfigInfo.MAX_SCROLLING_VELOCITY;

    /**
     * Max scrolloing distance.
     */
    private int mMaxScrollingDistance = CarouselConfigInfo.MAX_SCROLLING_DISTANCE;

    /**
     * Duration in milliseconds from the start of a scroll during which we're
     * unsure whether the user is scrolling or flinging.
     */
    private int mScrollToFlingUncertaintyTimeout = CarouselConfigInfo.SCROLL_TO_FLING_UNCERTAINTY_TIMEOUT;

    /**
     * Duration in milliseconds from the start of animation to end.
     */
    private int mAnimationDuration = CarouselConfigInfo.ANIMATION_DURATION;

    /**
     * Holds default selected item.
     */
    private int mSelectedItem = CarouselConfigInfo.DEFAULT_SELECTED_ITEM;
    private float mTilt = CarouselConfigInfo.TILT;
    private int mDiameter = OCV_DIAMETER_ENUM_FULL;
    private IOCVCarouselPlugin[] mPlugins = new IOCVCarouselPlugin[0];
    private float mDiameterScale = CarouselConfigInfo.DIAMETER_SCALE;

    /**
     * Creates a new {@link CarouselOptions} object.
     */
    public CarouselOptions() {
        /* Default constructor */
    }

    /**
     * Creates a new {@link CarouselOptions} object from the attribute set.
     *
     * @param context application context
     * @param attrs   target attribute set
     */
    CarouselOptions(Context context, AttributeSet attrs) {
        initCarouselAttributes(context, attrs);
    }

    /**
     * Specifies max quantity of views.
     *
     * @param maxQuantity max quantity of views
     * @return this {@link CarouselOptions}
     */
    public CarouselOptions maxQuantity(int maxQuantity) {
        mMaxQuantity = maxQuantity;
        return this;
    }

    /**
     * Specifies min quantity of views.
     *
     * @param minQuantity min quantity of views
     * @return this {@link CarouselOptions}
     */
    public CarouselOptions minQuantity(int minQuantity) {
        mMinQuantity = minQuantity;
        return this;
    }

    /**
     * Specifies min alpha value for carousel items.
     *
     * @param minAlpha min alpha value for carousel items
     * @return this {@link CarouselOptions}
     */
    public CarouselOptions minAlpha(int minAlpha) {
        mMinAlpha = minAlpha;
        return this;
    }

    /**
     * Specifies max scrolling velocity for carousel view.
     *
     * @param maxScrollingVelocity max scrolling velocity for carousel view.
     * @return this {@link CarouselOptions}
     */
    public CarouselOptions maxScrollingVelocity(int maxScrollingVelocity) {
        mMaxScrollingVelocity = maxScrollingVelocity;
        return this;
    }

    /**
     * Specifies max scrolling distance for carousel view.
     *
     * @param maxScrollingDistance max scrolling distance for carousel view.
     * @return this {@link CarouselOptions}
     */
    public CarouselOptions maxScrollingDistance(int maxScrollingDistance) {
        mMaxScrollingDistance = maxScrollingDistance;
        return this;
    }

    /**
     * Specifies duration in milliseconds from the start of a scroll during
     * which we're unsure whether the user is scrolling or flinging.
     *
     * @param scrollToFlingUncertaintyTimeout scroll to fling uncertainty timeout
     * @return this {@link CarouselOptions}
     */
    public CarouselOptions scrollToFlingUncertaintyTimeout(int scrollToFlingUncertaintyTimeout) {
        mScrollToFlingUncertaintyTimeout = scrollToFlingUncertaintyTimeout;
        return this;
    }

    /**
     * Specifies animation duration in milliseconds.
     *
     * @param animationDuration animation duration in milliseconds
     * @return this {@link CarouselOptions}
     */
    public CarouselOptions animationDuration(int animationDuration) {
        mAnimationDuration = animationDuration;
        return this;
    }

    /**
     * Specifies selected item on carousel view.
     *
     * @param selectedItem selected item on carousel view
     * @return this {@link CarouselOptions}
     */
    public CarouselOptions selectedItem(int selectedItem) {
        mSelectedItem = selectedItem;
        return this;
    }

    /**
     * 倾斜度配置项
     */
    public CarouselOptions tilt(float tilt) {
        mTilt = tilt;
        return this;
    }

    /**
     * 直径配置项
     */
    public CarouselOptions diameter(int diameter) {
        mDiameter = diameter;
        return this;
    }

    public CarouselOptions plugins(IOCVCarouselPlugin[] plugins) {
        mPlugins = plugins;
        return this;
    }

    public CarouselOptions diameterScale(int scale) {
        mDiameterScale = scale;
        return this;
    }

    /**
     * @return max quantity for carousel view
     */
    public int getMaxQuantity() {
        return mMaxQuantity;
    }

    /**
     * @return min quantity for carousel view
     */
    public int getMinQuantity() {
        return mMinQuantity;
    }

    /**
     * @return min alpha value for carousel items
     */
    public int getMinAlpha() {
        return mMinAlpha;
    }

    /**
     * @return max scrolling velocity for carousel view
     */
    public int getMaxScrollingVelocity() {
        return mMaxScrollingVelocity;
    }

    /**
     * @return max scrolling distance for carousel view
     */
    public int getMaxScrollingDistance() {
        return mMaxScrollingDistance;
    }

    /**
     * Duration in milliseconds from the start of a scrolling.
     *
     * @return duration in milliseconds
     */
    public int getScrollToFlingUncetaintyTimeout() {
        return mScrollToFlingUncertaintyTimeout;
    }

    /**
     * @return animation duration in milliseconds
     */
    public int getAnimationDuration() {
        return mAnimationDuration;
    }

    /**
     * @return default selected item on carousel view
     */
    public int getSelectedItem() {
        return mSelectedItem;
    }

    public float getTilt() {
        return mTilt;
    }

    public int getDiameter() {
        return mDiameter;
    }

    public IOCVCarouselPlugin[] getPlugins() {
        return mPlugins;
    }

    public float getDiameterScale() {
        return mDiameterScale;
    }

    /* ************************************************************************* */
    /* ***************************** Utility API ******************************* */
    /* ************************************************************************* */

    private void initCarouselAttributes(Context context, AttributeSet attrs) {
        TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.Carousel);
        mSelectedItem = arr.getInteger(R.styleable.Carousel_selectedItem, 0);

        int min = arr.getInteger(R.styleable.Carousel_minQuantity, CarouselConfigInfo.MIN_QUANTITY);
        int max = arr.getInteger(R.styleable.Carousel_maxQuantity, CarouselConfigInfo.MAX_QUANTITY);

        mMinQuantity = min < CarouselConfigInfo.MIN_QUANTITY ? CarouselConfigInfo.MIN_QUANTITY
                : min;
        mMaxQuantity = max > CarouselConfigInfo.MAX_QUANTITY ? CarouselConfigInfo.MAX_QUANTITY
                : max;
        if (arr.length() < mMinQuantity || arr.length() > mMaxQuantity)
            throw new IllegalArgumentException("Invalid set of items.");

        mMaxScrollingVelocity = arr.getInt(R.styleable.Carousel_maxScrollingVelocity,
                CarouselConfigInfo.MAX_SCROLLING_VELOCITY);
        mMaxScrollingDistance = arr.getInt(R.styleable.Carousel_maxScrollingDistance,
                CarouselConfigInfo.MAX_SCROLLING_DISTANCE);

        // Scroll coefficient used for improve touch handling on small density screen
        mMaxScrollingDistance = mMaxScrollingDistance - getScrollingDistanceCoefficient(context);
        mScrollToFlingUncertaintyTimeout = arr.getInt(
                R.styleable.Carousel_scrollToFlingUncertaintyTimeout,
                CarouselConfigInfo.SCROLL_TO_FLING_UNCERTAINTY_TIMEOUT);
        mAnimationDuration = arr.getInt(R.styleable.Carousel_animationDuration,
                CarouselConfigInfo.ANIMATION_DURATION);
        mMinAlpha = arr.getInt(R.styleable.Carousel_minAlpha, CarouselConfigInfo.MIN_ALPHA);
        arr.recycle();
    }

    private int getScrollingDistanceCoefficient(Context context) {
        int result;

        switch (context.getResources().getDisplayMetrics().densityDpi) {
            case DisplayMetrics.DENSITY_LOW:
            case DisplayMetrics.DENSITY_MEDIUM:
                result = 0;
                break;
            case DisplayMetrics.DENSITY_HIGH:
                result = 3;
                break;
            case DisplayMetrics.DENSITY_XHIGH:
                result = 4;
                break;
            default:
                result = 8;
                break;
        }
        return result;
    }
}