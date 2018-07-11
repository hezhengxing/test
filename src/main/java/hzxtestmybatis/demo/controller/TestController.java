package hzxtestmybatis.demo.controller;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author:HeZhengXing
 * @Descripton:
 * @Date: Created in 15:19 2018/6/28
 * @Modify By:
 */
public class TestController {
    public static void main(String[] args) {
        Date day=new Date();

        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");

        System.out.println(df.format(day));
        TestController testController = new TestController();
        String path = "D:/删除重复数据sql.txt";
        String content = "社会人混社会,香蕉你个巴拉";
        testController.writrFile(path,content);
        File file = new File(path);
        BufferedReader reader;
        int lineNumber;
        String line;
        try {
            try (InputStreamReader read = new InputStreamReader(new FileInputStream(path))) {
                reader = new BufferedReader(read);
                lineNumber = 2;
                line = readLine(lineNumber, reader);
                System.out.println(line);
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String result = testController.readFile(path);
        System.out.println(result);
    }

    private static String readLine(int lineNumber,BufferedReader reader)throws Exception{
        String line="";
        int i=0;
        while(i<lineNumber){   // 循环读取数据
            line=reader.readLine();
            i++;
        }
        return line;
    }

    public void writrFile (String filePath, String content) {
        FileOutputStream fos = null;
        try {
            //把路径转换为输出流
            fos = new FileOutputStream(filePath);
            byte[] bytes = content.getBytes();
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

    public String readFile(String filePath) {
        FileInputStream fis = null;
        String result = null;
        try {
            //吧地址示例化为一个输入流的对象
            fis = new FileInputStream(filePath);
            //读取数据中的字节
            int size = fis.available();
            byte[] array = new byte[size];
            fis.read(array);
            result = new String(array);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if ( fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return  result;
    }
}
