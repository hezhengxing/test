package hzxtestmybatis.demo.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author:HeZhengXing
 * @Descripton:
 * @Date: Created in 16:58 2018/6/28
 * @Modify By:
 */
public class IOController {
    public static void main(String[] args) {
        String filePath = "D:删除重复数据sql.txt";
        FileInputStream fis = null;
        try{
            fis = new FileInputStream(filePath);
            int size = fis.available();
            byte[] ba = new byte[size];
            fis.read(ba);
            String s = new String(ba);
            System.out.println(s);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null!= fis) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
