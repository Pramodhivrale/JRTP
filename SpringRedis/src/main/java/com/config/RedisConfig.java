package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.bindings.Binding;

@Configuration
public class RedisConfig {

	@Bean
	public JedisConnectionFactory jedisConnection() {
		JedisConnectionFactory jconn=new JedisConnectionFactory();
		// Redis server properties
		return jconn;
	}
	
	@Bean
	public RedisTemplate<String, Binding> redisTemp(){
		
		RedisTemplate<String, Binding> redis=new RedisTemplate<>();
		redis.setConnectionFactory(jedisConnection());
		
		return redis;
	}
}
