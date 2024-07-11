package com.props;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "admin")
public class PropertiesConfiguration {
	
	Map<String, String> messages=new HashMap<>();

	public Map<String, String> getMessage() {
		return messages;
	}

	public void setMessage(Map<String, String> message) {
		this.messages = message;
	}
	
	

}
