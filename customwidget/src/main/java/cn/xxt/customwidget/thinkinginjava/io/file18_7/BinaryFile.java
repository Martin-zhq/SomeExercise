package cn.xxt.customwidget.thinkinginjava.io.file18_7;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author zhq
 * @Date 2019-12-02-17:25
 * @Description
 * @Email 1457453696@qq.com
 */
public class BinaryFile {

    public static byte[] read(File file) throws IOException {
        BufferedInputStream bf = new BufferedInputStream(new FileInputStream(file));
        try {
            byte[] data = new byte[bf.available()];
            bf.read(data);
            return data;
        } finally {
            bf.close();
        }
    }

    public static byte[] read(String file) throws IOException {
        return read(new File(file).getAbsoluteFile());
    }
}
