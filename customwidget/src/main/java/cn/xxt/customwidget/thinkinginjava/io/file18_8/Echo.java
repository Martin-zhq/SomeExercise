package cn.xxt.customwidget.thinkinginjava.io.file18_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author zhq
 * @Date 2019-12-02-18:01
 * @Description
 * @Email 1457453696@qq.com
 */
public class Echo {

    public static void main(String[] args) throws IOException {
        BufferedReader sdin = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = sdin.readLine()) != null && s.length() != 0) {
            System.out.println(s);
        }
    }
}
