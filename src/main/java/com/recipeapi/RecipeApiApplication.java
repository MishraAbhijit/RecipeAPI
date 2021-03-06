package com.recipeapi;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
public class RecipeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeApiApplication.class, args);
	}

	/*
	 * @Bean
	 * 
	 * @Primary
	 * 
	 * @ConfigurationProperties(prefix="spring.data.mongodb") public DataSource
	 * primaryDataSource() { return DataSourceBuilder.create().build(); }
	 * 
	 * @Bean
	 * 
	 * @ConfigurationProperties(prefix="spring.datasource") public DataSource
	 * secondaryDataSource() { return DataSourceBuilder.create().build(); }
	 */
}
