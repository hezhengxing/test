package hzxtestmybatis.demo.rabbit;

/**
 * @author:HeZhengXing
 * @Descripton:
 * @Date: Created in 11:53 2018/6/25
 * @Modify By:
 */
public class ReceiveMsgHandler {
    public void handleMessage(String text) {
        System.out.println("Received: " + text);
    }
}
