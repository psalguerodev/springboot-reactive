package me.psalguero.service;

import me.psalguero.bean.UserBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class GithubLookupService {

	private static final Logger logger = LoggerFactory.getLogger(GithubLookupService.class);

	private final RestTemplate restTemplate;

	public GithubLookupService(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();
	}

	@Async
	public CompletableFuture<UserBean> findUser(String username) throws InterruptedException {
		logger.info("Looking up " + username);
		String url = String.format("https://api.github.com/users/%s", username);
		UserBean resultGithub = restTemplate.getForObject(url, UserBean.class);
		Thread.sleep(500L);
		return CompletableFuture.completedFuture(resultGithub);
	}

}
