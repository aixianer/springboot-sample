//package com.xie.redis;
//
//import com.fasterxml.jackson.annotation.JsonAutoDetect;
//import com.fasterxml.jackson.annotation.PropertyAccessor;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import io.lettuce.core.ReadFrom;
//import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
//import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.RedisSentinelConfiguration;
//import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
//import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
//import org.springframework.data.redis.core.*;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//import java.util.HashSet;
//
//@Configuration
//public class RedisConfig{
//
//    /**
//     * 配置读写分离
//     */
//    @Bean
//    public RedisConnectionFactory lettuceConnectionFactory(RedisProperties redisProperties) {
//        // 配置哨兵节点以及主节点
//        RedisSentinelConfiguration redisSentinelConfiguration = new RedisSentinelConfiguration(
//                redisProperties.getSentinel().getMaster(), new HashSet<>(redisProperties.getSentinel().getNodes())
//        );
//
//        // 配置读写分离
//        LettucePoolingClientConfiguration lettuceClientConfiguration = LettucePoolingClientConfiguration.builder()
//                .poolConfig(getPoolConfig(redisProperties.getLettuce().getPool()))
//                // ReadFrom.REPLICA_PREFERRED 优先读取从节点,如果从节点不可用,则读取主节点
//                .readFrom(ReadFrom.REPLICA_PREFERRED)
//                .build();
//
//        return new LettuceConnectionFactory(redisSentinelConfiguration, lettuceClientConfiguration);
//    }
//    private GenericObjectPoolConfig<?> getPoolConfig(RedisProperties.Pool properties) {
//        GenericObjectPoolConfig<?> config = new GenericObjectPoolConfig<>();
//        config.setMaxTotal(properties.getMaxActive());
//        config.setMaxIdle(properties.getMaxIdle());
//        config.setMinIdle(properties.getMinIdle());
//        if (properties.getTimeBetweenEvictionRuns() != null) {
//            config.setTimeBetweenEvictionRunsMillis(properties.getTimeBetweenEvictionRuns().toMillis());
//        }
//        if (properties.getMaxWait() != null) {
//            config.setMaxWaitMillis(properties.getMaxWait().toMillis());
//        }
//        return config;
//    }
//
//    /**
//     * retemplate相关配置，配置自定义序列化规则为jackson
//     */
//    @Bean
//    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
//        RedisTemplate<String, Object> template = new RedisTemplate<>();
//        // 配置连接工厂
//        template.setConnectionFactory(factory);
//        //使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值（默认使用JDK的序列化方式）
//        Jackson2JsonRedisSerializer jacksonSeial = new Jackson2JsonRedisSerializer(Object.class);
//        ObjectMapper om = new ObjectMapper();
//        // 指定要序列化的域，field,get和set,以及修饰符范围，ANY是都有包括private和public
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        // 指定序列化输入的类型，类必须是非final修饰的，final修饰的类，比如String,Integer等会跑出异常
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jacksonSeial.setObjectMapper(om);
//        // 值采用json序列化
//        template.setValueSerializer(jacksonSeial);
//        //使用StringRedisSerializer来序列化和反序列化redis的key值
//        template.setKeySerializer(new StringRedisSerializer());
//        // 设置hash key 和value序列化模式
//        template.setHashKeySerializer(new StringRedisSerializer());
//        template.setHashValueSerializer(jacksonSeial);
//        template.afterPropertiesSet();
//        return template;
//    }
//}
