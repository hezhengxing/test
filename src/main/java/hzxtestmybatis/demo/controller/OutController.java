package hzxtestmybatis.demo.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author:HeZhengXing
 * @Descripton:
 * @Date: Created in 17:04 2018/6/28
 * @Modify By:
 */
public class OutController {
    public static void main(String[] args) {
        String s = "D:删除重复数据sql.txt";
        File file = new File(s);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            String s1 = "我是一个边缘人物,过于现实,哈哈哈";
            byte[] bytes = s1.getBytes();
            fos.write(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != fos) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
