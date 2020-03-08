package cn.figo.figo_zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class FigoZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(FigoZuulApplication.class, args);
	}

}
