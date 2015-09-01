package org.xmsu.service;

import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * Created by martin on 25/08/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = GpioServiceTest.class)
public class GpioServiceTest {


    @Inject
    private GpioService gpio;

    @Test
    public void testApp() {
        assertNull(gpio.getDigitalOutputPin(RaspiPin.GPIO_01, PinState.HIGH));
    }

    @Bean
    public GpioService getGpioMock() {
        GpioService serv = mock(GpioService.class);
        when(serv.getDigitalOutputPin(any(Pin.class), any(PinState.class))).thenReturn(null);
        return serv;
    }
}


