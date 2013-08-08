#-------------------------------------------------
#
# Project created by QtCreator 2013-08-02T18:26:52
#
#-------------------------------------------------

QT       -= core gui

TARGET = UsbAdapter
TEMPLATE = lib

DEFINES += USBADAPTER_LIBRARY

SOURCES += com_intexsoft_sensor_usb_UsbAdapter.cpp

HEADERS += com_intexsoft_sensor_usb_UsbAdapter.h

# necessary configure libs for 64 and 32 bit
unix:!macx {
    INCLUDEPATH += /usr/lib/jvm/java-7-oracle/include\
                   /usr/lib/jvm/java-7-oracle/include/linux\
                   /usr/include/libusb-1.0/
    CONFIG(64bit) {
        LIBS += ../../lib64/libusb-1.0.so
    }
    CONFIG(32bit) {
        LIBS += ../../lib32/libusb-1.0.so
    }
}

# necessary configure path
win32: {
    INCLUDEPATH += /usr/lib/jvm/java-7-oracle/include\
                   /usr/lib/jvm/java-7-oracle/include/linux\
                   /usr/include/libusb-1.0/
    LIBS += ../../lib32/libusb-1.0.dll
}

# necessary configure path
win64: {
    INCLUDEPATH += /usr/lib/jvm/java-7-oracle/include\
                   /usr/lib/jvm/java-7-oracle/include/linux\
                   /usr/include/libusb-1.0/
    LIBS += ../../lib64/libusb-1.0.dll
}
