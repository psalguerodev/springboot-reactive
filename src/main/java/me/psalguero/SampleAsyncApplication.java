package me.psalguero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@SpringBootApplication
@EnableAsync
@EnableScheduling
public class SampleAsyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleAsyncApplication.class, args);
	}

	@Bean
	public Executor taskExecutor() {
		ThreadPoolTaskExecutor poolExecutor = new ThreadPoolTaskExecutor();
		poolExecutor.setCorePoolSize(2);
		poolExecutor.setMaxPoolSize(2);
		poolExecutor.setQueueCapacity(500);
		poolExecutor.setThreadNamePrefix("github-");
		poolExecutor.initialize();
		return poolExecutor;
	}

}
