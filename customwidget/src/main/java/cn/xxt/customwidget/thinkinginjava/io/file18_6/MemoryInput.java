package cn.xxt.customwidget.thinkinginjava.io.file18_6;

import java.io.IOException;
import java.io.StringReader;

/**
 * @Author zhq
 * @Date 2019-11-23-14:45
 * @Description
 * @Email 1457453696@qq.com
 */
public class MemoryInput {

    public static void main(String[] args) throws IOException {
        StringReader in = new StringReader(BufferedInputFile.read("MemoryInput.java"));

        while (in.read() != -1) {
            System.out.println((char)in.read());
        }
    }
}
