package fr.undev.linuxhacks.util;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GraphicsCard;
import org.jsoftbiz.utils.OS;
import oshi.hardware.HardwareAbstractionLayer;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/*
 * hwid based on xploding's HWID.jar
 * getting distro name now thanks to random os detection library i found on github lol
 */
public class HWIDUtils {
    private static final char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static byte[] generateHWID() {
        OS os = OS.getOs();
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();
        CentralProcessor cpu = hal.getProcessor();
        CentralProcessor.ProcessorIdentifier cpuid = cpu.getProcessorIdentifier();
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            StringBuilder s = new StringBuilder();
            s.append(os.getPlatformName());
            s.append(cpuid.getName());
            s.append(System.getProperty("os.arch"));
            for (GraphicsCard graphicsCard : hal.getGraphicsCards()) {
                s.append(graphicsCard.getName());
            }
            System.out.println(s.toString());
            return digest.digest(s.toString().getBytes(StandardCharsets.UTF_8));
        }
        catch (NoSuchAlgorithmException e) {
            throw new Error("Algorithm wasn't found.", e);
        }
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte)((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; ++j) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0xF];
        }
        return new String(hexChars);
    }
}