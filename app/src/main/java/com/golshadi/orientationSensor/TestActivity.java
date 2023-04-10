package com.golshadi.orientationSensor;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import com.golshadi.orientationSensor.databinding.ActivityTestBinding;
import com.golshadi.orientationSensor.sensors.Orientation;
import com.golshadi.orientationSensor.utils.OrientationSensorInterface;

/**
 * Created by majidGolshadi on 9/22/2014.
 */
public class TestActivity extends Activity implements OrientationSensorInterface{

    private static final String TAG = TestActivity.class.getSimpleName();
    private ActivityTestBinding mBinding;
    private Orientation mOrientationSensor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = ActivityTestBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mOrientationSensor = new Orientation(this.getApplicationContext(), this);
        //------Turn Orientation sensor ON-------
        // set tolerance for any directions
        mOrientationSensor.init(1.0, 1.0, 1.0);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // set output speed and turn initialized sensor on
        // 0 Normal
        // 1 UI
        // 2 GAME
        // 3 FASTEST
        mOrientationSensor.on(0);
        //---------------------------------------


        // turn orientation sensor off
//        orientationSensor.off();

        // return true or false
//        orientationSensor.isSupport();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mOrientationSensor.off();
    }

    @Override
    public void orientation(Double AZIMUTH, Double PITCH, Double ROLL) {

        Log.d(TAG, "YAW: "+ AZIMUTH);
        Log.d(TAG, "PITCH: "+ PITCH);
        Log.d(TAG, "ROLL: "+ ROLL);

        mBinding.yawView.setText("Азимут: "+Math.round(AZIMUTH));
        mBinding.pitchView.setText("Тангаж: "+Math.round(PITCH));
        mBinding.rollView.setText("Крен: "+Math.round(ROLL));
    }
}
