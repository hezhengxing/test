package hzxtestmybatis.demo.config;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.ScheduledAnnotationBeanPostProcessor;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author:HeZhengXing
 * @Descripton:
 * @Date: Created in 10:54 2018/6/25
 * @Modify By:
 */
@Configuration
public class RabbitMqConfig {
    private final String helloWorldQueueName =  "spring-queue-async";

    //创建连接
    @Bean
    public CachingConnectionFactory connectionFactory(){
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory("192.168.3.2");
        cachingConnectionFactory.setUsername("szhuilian");
        cachingConnectionFactory.setPassword("szhuilian");
        cachingConnectionFactory.setPort(AMQP.PROTOCOL.PORT);
        return cachingConnectionFactory;
    }

    //创建消息模板
    @Bean
    public RabbitTemplate rabbitTemplate(){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        rabbitTemplate.setRoutingKey(this.helloWorldQueueName);
        return  rabbitTemplate;
    }

    //创建一个调度
    @Bean
    public ScheduledProducer scheduledProducer() {
        return new ScheduledProducer();
    }

    @Bean
    public BeanPostProcessor postProcessor() {
        return new ScheduledAnnotationBeanPostProcessor();
    }

    static class ScheduledProducer {

        @Autowired
        private volatile RabbitTemplate rabbitTemplate;

        //自增整数
        private final AtomicInteger counter = new AtomicInteger();
        /**
         * 每3秒发送一条消息
         *
         * Spring3中加强了注解的使用，其中计划任务也得到了增强，现在创建一个计划任务只需要两步就完成了：
         创建一个Java类，添加一个无参无返回值的方法，在方法上用@Scheduled注解修饰一下；
         在Spring配置文件中添加三个<task:**** />节点；
         参考：http://zywang.iteye.com/blog/949123
         */
//        @Scheduled(fixedRate = 3000)
//        public void sendMessage() {
//            rabbitTemplate.convertAndSend("Hello World " + counter.incrementAndGet());
//        }
    }
}
