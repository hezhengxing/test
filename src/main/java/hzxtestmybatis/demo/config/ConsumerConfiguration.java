package hzxtestmybatis.demo.config;

import com.rabbitmq.client.AMQP;
import hzxtestmybatis.demo.rabbit.ReceiveMsgHandler;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author:HeZhengXing
 * @Descripton:
 * @Date: Created in 11:53 2018/6/25
 * @Modify By:
 */
@Configuration
public class ConsumerConfiguration {
    // 指定队列名称 routingkey的名称默认为Queue的名称，使用Exchange类型为DirectExchange
    protected String springQueueDemo = "spring-queue-async";
    // 创建链接
    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(
                "192.168.3.2");
        connectionFactory.setUsername("szhuilian");
        connectionFactory.setPassword("szhuilian");
        connectionFactory.setPort(AMQP.PROTOCOL.PORT);
        return connectionFactory;
    }

    // 创建rabbitAdmin 代理类
    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    // 创建rabbitTemplate 消息模板类
    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        template.setRoutingKey(this.springQueueDemo);
        template.setQueue(this.springQueueDemo);
        return template;
    }

    public Queue helloWorldQueue() {
        return new Queue(this.springQueueDemo);
    }

//    @Bean
//    public SimpleMessageListenerContainer listenerContainer() {
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory());
//        container.setQueueNames(this.springQueueDemo);
//        container.setMessageListener(new MessageListenerAdapter(
//                new ReceiveMsgHandler()));
//        return container;
//    }
}
