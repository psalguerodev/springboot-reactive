package me.psalguero.taks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduleTask {
	private final Logger logger = LoggerFactory.getLogger(ScheduleTask.class);

	private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(fixedRate = 4000L)
	public void reportCurrentTime() {
		logger.info("The time is now {}", simpleDateFormat.format(new Date()));
	}
}
