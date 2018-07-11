package hzxtestmybatis.demo.rabbit;

import hzxtestmybatis.demo.config.RabbitMqConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author:HeZhengXing
 * @Descripton:
 * @Date: Created in 11:51 2018/6/25
 * @Modify By:
 */
public class Producer {
    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(RabbitMqConfig.class);
    }
}
