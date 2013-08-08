jar -cf WheelInput.jar WheelInput.dll
jarsigner -keystore testKeys WheelInput.jar jdc
jar -cf libusb-1.0.jar libusb-1.0.dll
jarsigner -keystore testKeys libusb-1.0.jar jdc