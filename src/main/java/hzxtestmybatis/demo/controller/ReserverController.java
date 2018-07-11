package hzxtestmybatis.demo.controller;

import java.util.Scanner;

/**
 * @author:HeZhengXing
 * @Descripton:
 * @Date: Created in 17:54 2018/6/28
 * @Modify By:
 */
public class ReserverController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        StringBuffer stringBuffer = new StringBuffer(s);
        stringBuffer.reverse();
        for (int i=0;i< stringBuffer.length();i++) {
            if (s.charAt(i) == stringBuffer.charAt(i)) {
                System.out.println(s.charAt(i)+"目前是回文的");
                continue;
            } else {
                System.out.println("不是回文的");
                break;
            }
        }
        String s1 = new String(stringBuffer);
        if (s.equals(s1)) {
            System.out.println("是回文");
        } else {
            System.out.println("不是回文");
        }
    }
}
