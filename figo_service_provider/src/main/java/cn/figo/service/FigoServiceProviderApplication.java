package cn.figo.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("cn.figo.service.mapper") //mapper接口的包扫描
@EnableDiscoveryClient  //启用eureka客户端，也可以用 @EnableEurekaClient
public class FigoServiceProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(FigoServiceProviderApplication.class, args);
	}

}
