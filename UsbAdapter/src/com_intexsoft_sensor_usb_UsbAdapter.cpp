#include "com_intexsoft_sensor_usb_UsbAdapter.h"
#include <string>
#include <stdio.h>
#include <libusb.h>

// Vendor ID of the device
#define DEVICE_VENDOR  0x1a5c
// Product ID of the device
#define DEVICE_PRODUCT 0x3012
// Number of bytes to get at once
#define DEVICE_DATA_SIZE 8
// Error code when device is not initialized
#define ERROR_DEVICE_IS_NOT_INIT -300;

// Handler for device
struct libusb_device_handle *dev_handle = NULL;
// Device
struct libusb_device *dev = NULL;
// Config descriptor for device
struct libusb_config_descriptor *conf_desc = NULL;
// Context
struct libusb_context *ctx = NULL;
// data to reed
unsigned char *data = new unsigned char[DEVICE_DATA_SIZE];
bool isInitialize = false;

#ifdef __cplusplus
extern "C" {
#endif

/*
 * Initialize and handle device.
 * Return error message or empty string.
 */
JNIEXPORT jstring JNICALL Java_com_intexsoft_sensor_usb_UsbAdapter_openDevicee(JNIEnv *jEnv, jobject)
{
    // return to Java
    jstring result = NULL;
    // C++ string contains error message
    const char *errorMessage;
    // returned value libusb functions
    int ret;

    // initialize library
    ret = libusb_init(&ctx);

    // if has error
    if(ret < 0)
    {
        // get string message
        errorMessage = libusb_error_name(ret);
        // convert form C++ string to Java string
        result = jEnv->NewStringUTF(errorMessage);
        // return
        return result;
    }

    // handle device
    dev_handle = libusb_open_device_with_vid_pid(ctx, DEVICE_VENDOR, DEVICE_PRODUCT);

    // if has error
    if(dev_handle == NULL)
    {
        // generate returned error message
        std::string tmpString("Could not handle device (not found)");
        errorMessage = tmpString.c_str();
        // convert form C++ string to Java string
        result = jEnv->NewStringUTF(errorMessage);
        // return
        return result;
    }

    // get device
    dev = libusb_get_device(dev_handle);
    // get desgriptor
    libusb_get_config_descriptor(dev, 0, &conf_desc);


    // if devace is attached to kernel driver
    if(libusb_kernel_driver_active(dev_handle, 0) == 1)
    {
        // deattache it
        libusb_detach_kernel_driver(dev_handle, 0);
    }

    // claim interface
    ret = libusb_claim_interface(dev_handle, 0);

    // if has error
    if(ret < 0)
    {
        // get string message
        errorMessage = libusb_error_name(ret);
        // convert form C++ string to Java string
        result = jEnv->NewStringUTF(errorMessage);
        // return
        return result;
    }

    isInitialize = true;

    // if has not errors — return empty string
    // TODO: generate empty _Java_ string
    return result;
}

/*
 * NB! Before need call openDevice().
 * Get current position.
 */
JNIEXPORT jint JNICALL Java_com_intexsoft_sensor_usb_UsbAdapter_getPosition(JNIEnv *jEnv, jobject)
{
    // if devace is not initialized - return
    if (!isInitialize)
    {
        // valid data is 00..FF (for Java -128..127)
        // other value is error
        return ERROR_DEVICE_IS_NOT_INIT;
    }

    // returned value to Java
    int result = 0;
    // returned value libusb functions
    int positionIndex = 0;
    int actual;
    // address to reed data from device
    unsigned char endpointAddress;

    // get endpoint address from descriptor
    endpointAddress = conf_desc->interface->altsetting->endpoint->bEndpointAddress;
    // default value of data
    data[positionIndex] = 0x80;
    // read data from device
    libusb_interrupt_transfer(dev_handle, endpointAddress, data, DEVICE_DATA_SIZE, &actual, 0);
    // get position
    result = data[positionIndex];

    // return position to Java
    return result;
}


JNIEXPORT jstring JNICALL Java_com_intexsoft_sensor_usb_UsbAdapter_closeDevice(JNIEnv *jEnv, jobject)
{
    // return to Java
    jstring result = NULL;
    // C++ string contains error message
    const char *errorMessage;
    // returned value libusb functions
    int ret;

    // release interface
    ret = libusb_release_interface(dev_handle, 0);

    // TODO: (?) attach kernel drive

    // if has error
    if(ret < 0)
    {
        // get string message
        errorMessage = libusb_error_name(ret);
        // convert form C++ string to Java string
        result = jEnv->NewStringUTF(errorMessage);
        // return
        return result;
    }

    // close device
    libusb_close(dev_handle);
    libusb_exit(ctx);

    // dismiss data
    delete[] data;
    // TODO: delete other data

    isInitialize = false;

    // if has not errors — return empty string
    // TODO: generate empty _Java_ string
    return result;

#ifdef __cplusplus
}
#endif
}
