/**
 * CareerApplication.java
 * @since		2025-04-23
 * @version		1.0.0
 * @author		Kwon Yujin
 * @see			@link org.springframework.boot.SpringApplication
 * @see			@link org.springframework.boot.autoconfigure.SpringBootApplication
 */
package com.gpipi.career;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class CareerApplication extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(CareerApplication.class);
	}
	
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(CareerApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
        
        String profiles = System.getProperty("spring.profiles.active", "default");
        log.info("▶ CareerApplication Start (Active Profiles : {})", profiles);
    }

}
