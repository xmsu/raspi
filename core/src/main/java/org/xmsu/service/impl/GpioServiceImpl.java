package org.xmsu.service.impl;

import com.pi4j.io.gpio.*;
import org.xmsu.service.GpioService;

import javax.inject.Named;

/**
 * Created by martin on 25/08/15.
 */
@Named("GpioService")
public class GpioServiceImpl implements GpioService {

    private final GpioController gpio = GpioFactory.getInstance();

    public GpioPinDigitalOutput getDigitalOutputPin(Pin pin, PinState state) {
        return gpio.provisionDigitalOutputPin(pin, state);
    }
}
