package com.mizeshuang.test;


import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * Created by mizeshuang on 2016/4/4.
 */
public class StringsTest {
    public static void main(String[] args) throws IOException {
        File file = new File("e:" + File.separator + "db.zip");
        File outFile = null;
        ZipFile zipFile = new ZipFile(file);
        ZipInputStream zipInput = new ZipInputStream(new FileInputStream(file));
        ZipEntry entry = null;
        InputStream input = null;
        OutputStream output = null;
        while ((entry = zipInput.getNextEntry()) != null) {
            System.out.println("解压缩" + entry.getName() + "文件");
            outFile = new File("e:" + File.separator + entry.getName());
            if (!outFile.getParentFile().exists()) {
                outFile.getParentFile().mkdir();
            }
            if (!outFile.exists()) {
                outFile.createNewFile();
            }
            input = zipFile.getInputStream(entry);
            output = new FileOutputStream(outFile);
            int temp = 0;
            while ((temp = input.read()) != -1) {
                output.write(temp);
            }
            input.close();
            output.close();
        }
    }
}
