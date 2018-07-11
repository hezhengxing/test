package hzxtestmybatis.demo.controller;

import java.io.*;

/**
 * @author:HeZhengXing
 * @Descripton:
 * @Date: Created in 17:12 2018/6/28
 * @Modify By:
 */
public class BufferController {
    public static void main(String[] args) {
        String s = "D:清除待分配案件sql.txt";
        FileInputStream fis = null;
        BufferedReader bufferedReader = null;
        try {
            fis = new FileInputStream(s);
            InputStreamReader inputStreamReader = new InputStreamReader(fis);
            bufferedReader = new BufferedReader(inputStreamReader);
            int j = 29;
            String result = "";
            for (int i = 0;i<j;i++ ){
                result = bufferedReader.readLine();
                System.out.println(result);
                i++;
            }
//            result.charAt(5);
            System.out.println(result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != bufferedReader) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
