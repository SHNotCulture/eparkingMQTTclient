package com.mqttclient.thread;


import com.mqttclient.properties.MqttConfiguration;
import com.mqttclient.util.*;
import com.mqttclient.util.MQTT.MqttPushClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Async
@Component
public class MqttThread {
    private static final Logger logger = LoggerFactory.getLogger(MqttThread.class);
    @Autowired
    private static MqttConfiguration mqttConfiguration;
    /**
     * 间隔5S触发
     */
    @Scheduled(cron = "*/5 * * * * ? ")
    public void checkMqtt(){
        mqttConfiguration= SpringUtils.getBean(MqttConfiguration.class);
        if(MqttPushClient.getClient()==null)
        {
            logger.info("本地MQTT初始化连接...");
            MqttPushClient.connect(mqttConfiguration.getHost(),mqttConfiguration.getClientid(),mqttConfiguration.getUsername(),mqttConfiguration.getPassword(),mqttConfiguration.getTimeout(),mqttConfiguration.getKeepalive());
        }
        if(!MqttPushClient.connected()){
            logger.info("本地MQTT尝试重新连接...");
            MqttPushClient.connect(mqttConfiguration.getHost(),mqttConfiguration.getClientid(),mqttConfiguration.getUsername(),mqttConfiguration.getPassword(),mqttConfiguration.getTimeout(),mqttConfiguration.getKeepalive());
        }
    }


}
