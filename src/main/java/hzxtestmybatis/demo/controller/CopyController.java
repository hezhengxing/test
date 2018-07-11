package hzxtestmybatis.demo.controller;

import java.io.*;

/**
 * @author:HeZhengXing
 * @Descripton:
 * @Date: Created in 17:32 2018/6/28
 * @Modify By:
 */
public class CopyController {
    public static void main(String[] args) {
        String s1 = "D:/博盛金服logo.png";
        String s2 = "C:/博盛金服logo.png";
        File file = new File(s2);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream(s1);
            int size = fileInputStream.available();
            byte[] bytes = new byte[size];
            fileInputStream.read(bytes);
            fileOutputStream = new FileOutputStream(s2);
            fileOutputStream.write(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
