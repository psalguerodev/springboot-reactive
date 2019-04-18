package me.psalguero.init;

import me.psalguero.bean.UserBean;
import me.psalguero.service.GithubLookupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class AppRunner implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(AppRunner.class);

	private GithubLookupService githubLookupService;

	public AppRunner(GithubLookupService githubLookupService) {
		this.githubLookupService = githubLookupService;
	}

	@Override
	public void run(String... args) throws Exception {
		long start = System.currentTimeMillis();

		CompletableFuture<UserBean> page1 = githubLookupService.findUser("psalguerodev");
		CompletableFuture<UserBean> page2 = githubLookupService.findUser("PivotalSoftware");
		CompletableFuture<UserBean> page3 = githubLookupService.findUser("CloudFoundry");

		CompletableFuture.allOf(page1, page2, page3).join();

		logger.info("Elapsed time " + (System.currentTimeMillis() - start));
		logger.info("---> " + page1.get());
		logger.info("---> " + page2.get());
		logger.info("---> " + page3.get());

	}
}
