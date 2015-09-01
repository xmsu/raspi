package org.xmsu.conf;

import com.pi4j.io.i2c.I2CBus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.xmsu.components.Arduino;
import org.xmsu.components.impl.MotorArduino;
import org.xmsu.stubs.I2CDeviceStub;

import javax.inject.Named;

import static org.mockito.Mockito.*;

/**
 * Created by martin on 28/08/15.
 */
@Configuration
public class RaspiTestConfig {

    @Named("motorArduino") @Bean
    public MotorArduino getMotorArduino() {
        return new MotorArduino();
    }

    @Named("otherArduino") @Bean
    public Arduino getOtherArduinoMock() {
        return mock(MotorArduino.class);
    }

    @Named("bus") @Bean
    public I2CBus getI2CBusMock() throws Exception {
        I2CBus bus = mock(I2CBus.class);
        when(bus.getDevice(anyInt())).thenReturn(new I2CDeviceStub());
        return bus;
    }
}
