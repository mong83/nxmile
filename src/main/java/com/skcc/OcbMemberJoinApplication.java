package com.skcc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class OcbMemberJoinApplication {

	private static final String PROPERTIES =
			"spring.config.location="
					+ "classpath:/config/application/";

	public static void main(String[] args) {
		new SpringApplicationBuilder(OcbMemberJoinApplication.class)
				.properties(PROPERTIES)
				.run(args);
	}

}
