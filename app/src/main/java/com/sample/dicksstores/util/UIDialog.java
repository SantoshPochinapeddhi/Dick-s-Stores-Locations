package com.sample.dicksstores.util;

import android.content.Context;
import android.graphics.Color;

import com.leo.simplearcloader.ArcConfiguration;
import com.leo.simplearcloader.SimpleArcDialog;
import com.leo.simplearcloader.SimpleArcLoader;
import com.sample.dicksstores.R;

/**
 * Created by santosh on 12/22/17.
 */

public class UIDialog {

    private static SimpleArcDialog mDialog;

    static int[] mColors = {Color.parseColor("#333333"),Color.parseColor("#333333")};

    public static void showUIDialog(Context context) {
        mDialog = new SimpleArcDialog(context);
        ArcConfiguration configuration = new ArcConfiguration(context);
        configuration.setColors(mColors);
        configuration.setTextColor(Color.parseColor("#333333"));
        configuration.setText(context.getResources().getString(R.string.loading));
        configuration.setAnimationSpeedWithIndex(SimpleArcLoader.SPEED_MEDIUM);
        mDialog.setConfiguration(configuration);
        mDialog.show();
    }

    public static void dismissDialog(Context context) {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
        }
    }
}
