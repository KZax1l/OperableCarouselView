package com.andova.ocv;

import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2018-01-30.
 *
 * @author kzaxil
 * @since 1.0.0
 */
public interface IOCVCarouselPlugin {
    void measureAndLayoutChild(ViewGroup parent, List<CarouselItemHolder> items, View child);

    boolean addViewInLayout();

    View[] extraView(ViewGroup parent, List<CarouselItemHolder> items);

    void scroll(List<CarouselItemHolder> items);
}
