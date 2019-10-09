package com.mqttclient.service;

import com.mqttclient.util.MQTT.MQTTTaskData;

public interface MqttBaseService {
    String SendTask(MQTTTaskData mqttTaskData);
}
