package com.cg.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages= {"com.cg.movie"})
@EntityScan(basePackages="com.cg.movie.beans")
@EnableJpaRepositories(basePackages="com.cg.movie.daoservices")
@EnableWebMvc
public class CgMovieSpringBootRestjpaDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(CgMovieSpringBootRestjpaDataApplication.class, args);
	}

}
