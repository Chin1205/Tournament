package com.sevensevengsi.Tournament.RecordSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = {"com.sevensevengsi.Tournament.RecordSystem"})
@EnableJpaRepositories(basePackages = {"com.sevensevengsi.Tournament.RecordSystem.repository"})
@EntityScan(basePackages = {"com.sevensevengsi.Tournament.RecordSystem.model"})
public class TournamentRecordSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(TournamentRecordSystemApplication.class, args);
	}

}
