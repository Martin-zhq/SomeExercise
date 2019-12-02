package cn.xxt.customwidget.thinkinginjava.io.file18_6;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

/**
 * @Author zhq
 * @Date 2019-11-25-09:16
 * @Description
 * @Email 1457453696@qq.com
 */
public class FormattedMeoryInput {

    public static void main(String[] args) throws IOException {
        try {
            DataInputStream in = new DataInputStream(
                    new ByteArrayInputStream(
                            BufferedInputFile.read("FormattedMeoryInput.java").getBytes()));
            while (true) {
                System.out.println((char)in.readByte());
            }
        } catch (EOFException e) {
            System.err.println("End of stream");
        }
    }
}
