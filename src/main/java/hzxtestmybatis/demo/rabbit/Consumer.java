package hzxtestmybatis.demo.rabbit;

import hzxtestmybatis.demo.config.ConsumerConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author:HeZhengXing
 * @Descripton:
 * @Date: Created in 11:57 2018/6/25
 * @Modify By:
 */
public class Consumer {
    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
    }
}
