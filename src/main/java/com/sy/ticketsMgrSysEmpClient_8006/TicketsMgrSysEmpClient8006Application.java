package com.sy.ticketsMgrSysEmpClient_8006;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.sy.ticketsMgrSysEmpClient_8006.util.DateUtils;



@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.sy.ticketsMgrSysEmpClient_8006.feignClientService")
public class TicketsMgrSysEmpClient8006Application {

	public static void main(String[] args) {
		SpringApplication.run(TicketsMgrSysEmpClient8006Application.class, args);
	} 
	
	/**
	 * 定义格式化器
	 */
	@Bean
	public Converter<String,Date> getDateFormatConverter(){
		return new Converter<String,Date>(){
			@Override
			public Date convert(String source) {
				return DateUtils.parseYMDStr2Date(source);
			}
			
		};
	}
	
}
