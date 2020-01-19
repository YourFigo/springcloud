package cn.figo.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer  //启用Eureka服务端
public class FigoEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FigoEurekaApplication.class, args);
	}

}
