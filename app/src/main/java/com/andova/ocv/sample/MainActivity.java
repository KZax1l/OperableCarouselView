package com.andova.ocv.sample;

import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.andova.ocv.CarouselOptions;
import com.andova.ocv.CarouselView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CarouselView.CarouselScrollListener {
    private CarouselView mCarouselView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mCarouselView = (CarouselView) findViewById(R.id.carouselView);
        mCarouselView.setCarouselScrollListener(this);
        CarouselOptions options = new CarouselOptions();
        options.tilt(-0.6f);
        options.diameter(500);
        mCarouselView.carouselOptions(options);
        for (View stubItem : initStubItems()) {
            mCarouselView.addView(stubItem);
        }

        mCarouselView.notifyDataSetChanged();

        findViewById(R.id.prev).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = mCarouselView.getSelectedItemPosition() == 0 ? mCarouselView.getCount() - 1 : mCarouselView.getSelectedItemPosition() - 1;
                mCarouselView.scrollToChild(position);
                mCarouselView.invalidate();
            }
        });

        findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = mCarouselView.getSelectedItemPosition() == mCarouselView.getCount() - 1 ? 0 : mCarouselView.getSelectedItemPosition() + 1;
                mCarouselView.scrollToChild(position);
                mCarouselView.invalidate();
            }
        });
    }

    private List<View> initStubItems() {
        List<View> result = new ArrayList<>();

        result.add(getChildView(R.mipmap.ic_module_annual_survey, "年检"));
        result.add(getChildView(R.mipmap.ic_module_dangerous, "危化"));
        result.add(getChildView(R.mipmap.ic_module_deliver, "快递"));
        result.add(getChildView(R.mipmap.ic_module_enterprise, "企业"));
        result.add(getChildView(R.mipmap.ic_module_filings, "备案"));
        result.add(getChildView(R.mipmap.ic_module_hotel, "旅馆"));
        result.add(getChildView(R.mipmap.ic_module_identification, "身份"));
        result.add(getChildView(R.mipmap.ic_module_law, "法律"));
        result.add(getChildView(R.mipmap.ic_module_place, "场所"));
        result.add(getChildView(R.mipmap.ic_module_ring, "报警"));
        result.add(getChildView(R.mipmap.ic_module_spot, "巡查"));

        return result;
    }

    private View getChildView(@DrawableRes int icon, String name) {
        View view = LayoutInflater.from(this).inflate(R.layout.item_carousel, mCarouselView, false);
        ((ImageView) view.findViewById(R.id.iv_icon)).setImageResource(icon);
        ((TextView) view.findViewById(R.id.tv_name)).setText(name);
        return view;
    }

    @Override
    public void onPositionChanged(int position) {
        Toast.makeText(this, "滑动到了第" + position + "项", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPositionClicked(int position) {
        Toast.makeText(this, "点击了第" + position + "项", Toast.LENGTH_SHORT).show();
    }
}
