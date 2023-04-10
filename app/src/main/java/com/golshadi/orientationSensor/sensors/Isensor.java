package com.golshadi.orientationSensor.sensors;

public interface Isensor {
	
	boolean isSupport();
	
	void on(int speed);
	
	void off();

	float getMaximumRange();
}
