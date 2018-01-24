package com.andova.ocv;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.andova.ocv.OCVDiameterEnum.OCV_DIAMETER_ENUM_FULL;
import static com.andova.ocv.OCVDiameterEnum.OCV_DIAMETER_ENUM_WRAP;

/**
 * Created by Administrator on 2018-01-24.
 *
 * @author kzaxil
 * @since 1.0.0
 */
@IntDef({OCV_DIAMETER_ENUM_WRAP, OCV_DIAMETER_ENUM_FULL})
@Retention(RetentionPolicy.SOURCE)
@interface OCVDiameterEnum {
    int OCV_DIAMETER_ENUM_WRAP = -1;
    int OCV_DIAMETER_ENUM_FULL = -2;
}