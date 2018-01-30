package com.andova.ocv;

import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2018-01-30.
 *
 * @author kzaxil
 * @since 1.0.0
 */
public class OCVImagePlugin implements IOCVCarouselPlugin {
    @Override
    public boolean layout(ViewGroup parent, List<CarouselItemHolder> items) {
        return false;
    }

    @Override
    public boolean addViewInLayout() {
        return false;
    }

    @Override
    public View[] extraView() {
        return new View[0];
    }

    /**
     * @return 子控件当前横坐标据{@link CarouselItemHolder#getItemX()}的偏移量
     */
    private float scaleXOffset(ViewGroup parent, CarouselItemHolder child) {
        float scale = child.getItemScale();
        float centerX = (float) parent.getWidth() / 2;
        float scaleXOff = child.getWidth() / 2.0f * (1.0f - scale);
        int dpi = parent.getResources().getDisplayMetrics().densityDpi;
        float dpiScale = (float) dpi / DisplayMetrics.DENSITY_HIGH;
        scaleXOff += (child.getItemX() + child.getWidth() / 2 - centerX)
                * CarouselConfigInfo.DIAMETER_SCALE * dpiScale;
        return scaleXOff;
    }

    /**
     * @return 子控件的绘制区域
     */
    private RectF contentRect(ViewGroup parent, CarouselItemHolder child) {
        float scaleXOff = scaleXOffset(parent, child);
        float l = child.getItemX() + scaleXOff;
        float t = child.getItemY();
        float r = child.getItemX() + scaleXOff + child.getWidth() * child.getItemScale();
        float b = child.getItemY() + child.getHeight() * child.getItemScale();
        return new RectF(l, t, r, b);
    }

    /**
     * @return 所有子控件包围住的内部椭圆区域
     */
    private RectF ovalRect(ViewGroup parent, List<CarouselItemHolder> children) {
        float left = 0, right = 0, top = 0, bottom = 0;
        for (CarouselItemHolder child : children) {
            RectF content = contentRect(parent, child);
            float l = content.left;
            float t = content.top;
            float r = content.right;
            float b = content.bottom;

            l += child.getWidth() * child.getItemScale() / 2;
            t += child.getHeight() * child.getItemScale() / 2;
            r -= child.getWidth() * child.getItemScale() / 2;
            b -= child.getHeight() * child.getItemScale() / 2;
            if (l < left || left == 0) left = l;
            if (t < top || top == 0) top = t;
            if (r > right || right == 0) right = r;
            if (b > bottom || bottom == 0) bottom = b;
        }
        return new RectF(left, top, right, bottom);
    }
}
