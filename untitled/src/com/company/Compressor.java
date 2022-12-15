package com.company;

import com.google.common.primitives.Bytes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Compressor {
    private HashMap<String, Integer> hm = new HashMap<String, Integer>();
    private int hmSize = 256;
    private String P = "";
    private String BP = "";
    private byte inputByte;
    private byte[] buffer = new byte[3];
    private boolean isLeft = true;
    private List<Byte> out = new ArrayList<Byte>();

    public byte[] compress(byte[] image) {

        int i, byteToInt;
        char C;

        for (i = 0; i < 256; i++) hm.put(Character.toString((char) i), i);

        inputByte = image[0];
        byteToInt = inputByte;

        if (byteToInt < 0) byteToInt += 256;
        C = (char) byteToInt;
        P = "" + C;

        for (int j = 1; j < image.length; j++) {
            inputByte = image[j];
            byteToInt = inputByte;

            if (byteToInt < 0) byteToInt += 256;
            C = (char) byteToInt;

            if (hm.containsKey(P + C)) {
                P = P + C;
            } else {
                BP = convertTo12Bit(hm.get(P));
                if (isLeft) {
                    buffer[0] = (byte) Integer.parseInt(BP.substring(0, 8), 2);
                    buffer[1] = (byte) Integer.parseInt(BP.substring(8, 12) + "0000", 2);
                } else {
                    writeToOut();
                }
                isLeft = !isLeft;
                if (hmSize < 4096) hm.put(P + C, hmSize++);

                P = "" + C;
            }
        }

        BP = convertTo12Bit(hm.get(P));
        if (isLeft) {
            buffer[0] = (byte) Integer.parseInt(BP.substring(0, 8), 2);
            buffer[1] = (byte) Integer.parseInt(BP.substring(8, 12) + "0000", 2);
            out.add(buffer[0]);
            out.add(buffer[1]);
        } else {
            writeToOut();
        }

        return Bytes.toArray(out);
    }

    private void writeToOut() {
        int i;
        buffer[1] += (byte) Integer.parseInt(BP.substring(0, 4), 2);
        buffer[2] = (byte) Integer.parseInt(BP.substring(4, 12), 2);
        for (i = 0; i < buffer.length; i++) {
            out.add(buffer[i]);
            buffer[i] = 0;
        }
    }

    private static String convertTo12Bit(int i) {
        StringBuilder to12Bit = new StringBuilder(Integer.toBinaryString(i));
        while (to12Bit.length() < 12) to12Bit.insert(0, "0");
        return to12Bit.toString();
    }

    public byte[] getArray(){
        return Bytes.toArray(out);
    }
//    public byte[] toArray(List<Byte> lst){
//        byte[] array = new byte[lst.size()];
//        int index = 0;
//        for (Byte value : lst) {
//            array[index] = value;
//            index++;
//        }
//        return array;
//    }
}
