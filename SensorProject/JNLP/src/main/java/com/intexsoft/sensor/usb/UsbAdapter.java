/*
 * Hanna Eismant
 * 26.07.13
 */

package com.intexsoft.sensor.usb;

/**
 * Class for call native code.
 */
public class UsbAdapter {

    /**
     * Get current position from USB-device.
     * <br/>
     * IMPORTANT! Before it {@link #openDevice()} must be called .
     *
     * @return -128..127 is valid value <br/>
     *         -300      if USB-device is not initialized (for example have not called
     *         {@link #openDevice()})
     */
    public native int getPosition();

    /**
     * Initialize USB-devise and handle it.
     *
     * @return {@code null} if no error <br/>
     *         otherwise string contains error message
     */
    public native String openDevice();

    /**
     * Unhandled device and close it. It is necessary to avoid memory leak.
     *
     * @return {@code null} if no error <br/>
     *         otherwise string contains error message
     */
    public native String closeDevice();
} 