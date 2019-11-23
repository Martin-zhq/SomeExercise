package cn.xxt.customwidget.thinkinginjava.io.file18_1;

import java.io.File;

/**
 * @Author zhq
 * @Date 2019-11-22-17:34
 * @Description
 * @Email 1457453696@qq.com
 */
public class DirectoryDemo {

    public static void main(String[] args) {
        PPrint.pprint(Directory.walk(".").dirs);

        for (File file : Directory.local(".", "T.*")) {
            System.out.println(file.getName());
        }

        for (File file : Directory.walk(".", "T.*\\.java")) {
            System.out.println(file.getName());
        }

        for (File file : Directory.walk(".", ".*[Zz].*\\.class")) {
            System.out.println(file.getName());
        }

    }
}
