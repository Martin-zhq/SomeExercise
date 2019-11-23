package cn.xxt.customwidget.thinkinginjava.io.file18_6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author zhq
 * @Date 2019-11-23-14:37
 * @Description
 * @Email 1457453696@qq.com
 */
public class BufferedInputFile {

    public static String read(String fileName) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String s;
        StringBuilder sb = new StringBuilder();
        while (null != (s = in.readLine())) {
            sb.append(s + "\n");
        }
        in.close();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(read("/Users/zhq/TestApplications/RecyclerViewExercise/customwidget/src/main/java/cn/xxt/customwidget/thinkinginjava/io/file18_1/Directory.java "));
    }
}
