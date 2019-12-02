package cn.xxt.customwidget.thinkinginjava.io.file18_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * @Author zhq
 * @Date 2019-11-25-10:02
 * @Description
 * @Email 1457453696@qq.com
 */
public class FileOutputShortcut {

    static String file = "FileOutputShortcut.out";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new StringReader(
                        BufferedInputFile.read("FileOutputShortcut.java")
                )
        );
        PrintWriter out = new PrintWriter(file);
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null) {
            out.println(lineCount++ + ": " + s);
        }
        out.close();
        System.out.println(BufferedInputFile.read(file));
    }
}
