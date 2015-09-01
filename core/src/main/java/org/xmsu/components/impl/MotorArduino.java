package org.xmsu.components.impl;

import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CDevice;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.xmsu.components.Arduino;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;

/**
 * Created by martin on 28/08/15.
 */
@Named("motorArduino")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MotorArduino implements Arduino {

    private static final long WAIT_BETWEEN_WRITES_MILLIS = 10;

    @Inject @Named("bus")
    private I2CBus bus;

    private Integer address;
    private I2CDevice arduino;

    @Override
    public void connect(int address) {
        try {
            this.address = address;
            this.arduino = bus.getDevice(address);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't connect to motor arduino", e);
        }
    }

    public boolean powerUp() {
        return sendCommand("POWER UP");
    }

    private boolean sendCommand(String command) {
        try {
            String cmd = command.replaceAll("\\n", "") + '\n';
            byte[] bytes = cmd.getBytes();
            for (int n=0; n<bytes.length; n++) {
                arduino.write(bytes[n]);
                Thread.sleep(WAIT_BETWEEN_WRITES_MILLIS);
            }
            return arduino.read() == 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
