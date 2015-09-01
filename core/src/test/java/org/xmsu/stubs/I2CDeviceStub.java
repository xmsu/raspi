package org.xmsu.stubs;

import com.pi4j.io.i2c.I2CDevice;

import java.io.IOException;

/**
 * Created by martin on 28/08/15.
 */
public class I2CDeviceStub implements I2CDevice {
    @Override
    public void write(byte b) throws IOException {
        System.out.println("device received byte " + (char) b);
    }

    @Override
    public void write(byte[] bytes, int i, int i1) throws IOException {

    }

    @Override
    public void write(int i, byte b) throws IOException {

    }

    @Override
    public void write(int i, byte[] bytes, int i1, int i2) throws IOException {

    }

    @Override
    public int read() throws IOException {
        return 1;
    }

    @Override
    public int read(byte[] bytes, int i, int i1) throws IOException {
        return 0;
    }

    @Override
    public int read(int i) throws IOException {
        return 0;
    }

    @Override
    public int read(int i, byte[] bytes, int i1, int i2) throws IOException {
        return 0;
    }

    @Override
    public int read(byte[] bytes, int i, int i1, byte[] bytes1, int i2, int i3) throws IOException {
        return 0;
    }
}
