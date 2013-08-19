package com.intexsoft.sensor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * User: sergey.berdashkevich
 * Date: 29.07.13
 */
public class ClassPathLibraryLoader {
    private static final String[] HID_LIB_NAMES = {
            "/native/win/libusb-1.0.dll",
            "/native/win/libUsbAdapter.dll",
            "/native/linux/libusb-1.0.so",
            "/native/linux/libUsbAdapter.so"
    };

    public static boolean loadNativeHIDLibrary() {
        boolean isHIDLibLoaded = false;

        for (String path : HID_LIB_NAMES) {
            try {
                if ((System.getProperty("os.name").toLowerCase().contains("lin")) & (path.contains("dll"))) {
                    continue;
                }
                if ((System.getProperty("os.name").toLowerCase().contains("win")) & (path.contains("so"))) {
                    continue;
                }
                InputStream in = ClassPathLibraryLoader.class.getResourceAsStream(path);
                if (in != null) {
                    try {
                        // always write to different location
                        String tempName = path.substring(path.lastIndexOf('/') + 1);
                        File fileOut = new File(System.getProperty("java.io.tmpdir"), tempName);
                        fileOut.deleteOnExit();

                        if (!fileOut.exists()) {
                            OutputStream out = new FileOutputStream(fileOut);
                            byte[] buf = new byte[1024];
                            int len;
                            while ((len = in.read(buf)) > 0) {
                                out.write(buf, 0, len);
                            }
                            out.close();
                        }
                        else    {
                            fileOut.delete();

                            OutputStream out = new FileOutputStream(fileOut);
                            byte[] buf = new byte[1024];
                            int len;
                            while ((len = in.read(buf)) > 0) {
                                out.write(buf, 0, len);
                            }
                            out.close();
                        }

                        System.load(fileOut.toString());

                        isHIDLibLoaded = true;
                    } finally {
                        in.close();
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }

            /*  if (isHIDLibLoaded) {
                break;
            }*/
        }

        return isHIDLibLoaded;
    }
}
