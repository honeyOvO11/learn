package com.test1;

import java.io.*;

public class FileOperation {
        public static void main(String[] args) throws IOException {
                // 创建File对象dir，表示目录
                File dir = new File("D:/source");
                if (!dir.exists()) {
                        dir.mkdir();
                }
                File[] file = new File[5];
                // 如果目录不存在
                // 创建目录
                for (int i = 0; i < file.length; i++) {
                        // 定义文件数组file
                        // 循环
                        // 定义文件名，并以test1～test5命名文件
                        String fileName = String.format("test%d.txt", i + 1);
                        // 在dir下创建File对象，并添加到file中，表示文件
                        file[i] = new File(dir, fileName);
                        if (!file[i].exists()) {
                                // 如果文件不存在
                                try {
                                        file[i].createNewFile();
                                } catch (IOException e) {
                                        // 创建一个新文件
                                        // 捕获IOException异常
                                        System.out.println(e.getMessage());
                                }
                        }
                }
                // 重命名文件数组中的第一个文件
                file[0].renameTo(new File(dir, "test1.doc"));
                System.out.println(file[0]);
                String[] list = dir.list();
                // 获取dir下的所有文件名
                System.out.println("D:/source 目录下包含的文件：");
                for (int i = 0; i < list.length; i++)
                        System.out.println(list[i]);
                // 删除文件数组中的所有文件
                for (int i = 0; i < file.length; i++) {
                        if (file[i].exists())
                                file[i].delete();
                }
                list = dir.list();
                // 获取删除文件后dir下的所有文件名
                System.out.println("删除文件数组中的文件后，" +
                                "D:/source 目录下包含的文件：");
                // 输出删除文件后dir下的所有文件名
                for (int i = 0; i < list.length; i++)
                        System.out.println(list[i]);
        }
}
