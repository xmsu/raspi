package org.xmsu.components;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.xmsu.components.impl.MotorArduino;
import org.xmsu.conf.RaspiTestConfig;

import javax.inject.Inject;
import javax.inject.Named;

import static org.junit.Assert.*;

/**
 * Created by martin on 28/08/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RaspiTestConfig.class)
public class MotorArduinoTest {

    private static Logger LOG  = LoggerFactory.getLogger(MotorArduinoTest.class);

    @Inject @Named("motorArduino")
    private MotorArduino motor;

    @Before
    public void setup() {
        motor.connect(0x04);
    }

    @Test
    public void testPowerUp() {
        System.out.println("power up motor " + motor);
        assertTrue("Received bad ACK from motor", motor.powerUp());
    }
}
