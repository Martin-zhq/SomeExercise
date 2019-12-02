package cn.xxt.customwidget.thinkinginjava.io.file18_6;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author zhq
 * @Date 2019-11-25-09:22
 * @Description
 * @Email 1457453696@qq.com
 */
public class TestEOF {

    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream("TestEOF.java")
                )
        );
        while (in.available() != 0) {
            System.out.println((char)in.readByte());
        }
    }
}
