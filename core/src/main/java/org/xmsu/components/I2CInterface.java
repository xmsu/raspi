package org.xmsu.components;

import com.pi4j.io.i2c.I2CBus;

/**
 * Created by martin on 28/08/15.
 */
public interface I2CInterface {
    public void connect(int address);
}
