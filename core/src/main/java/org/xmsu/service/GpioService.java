package org.xmsu.service;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;

/**
 * Created by martin on 25/08/15.
 */
public interface GpioService {
    public GpioPinDigitalOutput getDigitalOutputPin(Pin pin, PinState state);
}
