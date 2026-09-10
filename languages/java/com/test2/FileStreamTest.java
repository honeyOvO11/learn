package com.test2;

import java.io.*;

public class FileStreamTest {
    public static void main(String[] args) {
        // 定义要写入的字符串
        String content = "这是一个使用文件字节流进行读写操作的测试文件。\nHello, FileInputStream and FileOutputStream!";

        // 定义文件名
        String fileName = "FileStreamTest.txt";

        // 使用FileOutputStream写入文件
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            // 将字符串转换为字节数组
            byte[] bytes = content.getBytes();

            // 使用write()方法将字节数组写入文件
            fos.write(bytes);

            System.out.println("数据已成功写入文件: " + fileName);
            System.out.println("写入的内容: " + content);

        } catch (IOException e) {
            System.out.println("写入文件时发生错误: " + e.getMessage());
            return;
        }

        // 使用FileInputStream读取文件
        try (FileInputStream fis = new FileInputStream(fileName)) {
            // 创建字节数组来存储读取的数据
            byte[] buffer = new byte[fis.available()];

            // 使用read()方法读取文件数据到字节数组
            int bytesRead = fis.read(buffer);

            // 将字节数组转换为字符串
            String readContent = new String(buffer, 0, bytesRead);

            System.out.println("\n从文件读取的数据:");
            System.out.println("读取的字节数: " + bytesRead);
            System.out.println("转换后的字符串: " + readContent);

        } catch (IOException e) {
            System.out.println("读取文件时发生错误: " + e.getMessage());
        }
    }
}
