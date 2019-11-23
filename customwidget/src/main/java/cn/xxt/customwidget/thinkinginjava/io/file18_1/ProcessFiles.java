package cn.xxt.customwidget.thinkinginjava.io.file18_1;

import java.io.File;
import java.io.IOException;

/**
 * @Author zhq
 * @Date 2019-11-23-09:20
 * @Description
 * @Email 1457453696@qq.com
 */
public class ProcessFiles {

    public interface Strategy {
        void process(File file);
    }

    private Strategy strategy;

    private String ext;

    public ProcessFiles(Strategy strategy, String ext) {
        this.strategy = strategy;
        this.ext = ext;
    }

    public void start(String[] args) {
        try {
            if (args.length == 0) {
                processDirectoryTree(new File("."));
            } else {
                for (String arg : args) {
                    File fileArg = new File(arg);
                    if (fileArg.isDirectory()) {
                        processDirectoryTree(fileArg);
                    } else {
                        if (!arg.endsWith("." + ext)) {
                            arg += "." + ext;
                        }
                        strategy.process(new File(arg).getCanonicalFile());
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void processDirectoryTree(File root) throws IOException {
        for (File file : Directory.walk(root.getAbsolutePath(), ".*\\." + ext)) {
            strategy.process(file.getCanonicalFile());
        }
    }


    public static void main(String[] args) {
        new ProcessFiles(new ProcessFiles.Strategy() {
            @Override
            public void process(File file) {
                System.out.println(file.getName());
            }
        }, "java").start(args);
    }
}
