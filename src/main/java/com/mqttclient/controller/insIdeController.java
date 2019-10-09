package com.mqttclient.controller;

import com.mqttclient.service.MqttBaseService;
import com.mqttclient.util.MQTT.MQTTTaskData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "inside")
public class insIdeController {
    @Autowired
    MqttBaseService mqttBaseService;

    /**
     * 发送MQTT任务
     * @param mqttTaskData
     * @return
     */
    @PostMapping(value = "/sendTask")
    public String SendTask(@RequestBody MQTTTaskData mqttTaskData){
        mqttBaseService.SendTask(mqttTaskData);
        return "发送任务成功";
    }
}
