package net.lainiao.myqq;

import net.lainiao.myqq.netty.NettyServer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;


public class ApplicationStartup  implements ApplicationListener<ContextRefreshedEvent> {
    public static ApplicationContext context=null;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        ApplicationStartup.context=contextRefreshedEvent.getApplicationContext();
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                new NettyServer().run();
            }
        });
        thread.start();
    }
}
