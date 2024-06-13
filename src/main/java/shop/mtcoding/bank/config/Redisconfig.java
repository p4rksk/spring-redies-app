package shop.mtcoding.bank.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Getter
@EnableRedisHttpSession
@Configuration
public class Redisconfig {

    @Value("${spring.data.redis.host}")//yml에 설정된 값을 땡겨온다.(경로를 적으면 된다.)
    private String redisHost;

    @Value("${spring.data.redis.port}")
    private int redisPort;

    @Value("${spring.data.redis.password}")
    private String redisPassword;

    @Bean //IOC에 등록해놔야지 꺼내 쓰니 등록해놓기
    public RedisConnectionFactory redisConnectionFactory(){
        System.out.println("서버 실행시 동작 : RedisConnectionFactory");
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
        config.setHostName(redisHost);
        config.setPort(redisPort);
        config.setPassword(redisPassword);
        return new LettuceConnectionFactory(config);
    }
}
