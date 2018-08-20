package com.itom.nextGenDemo;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.itom.nextGenDemo.bookmarks.Account;
import com.itom.nextGenDemo.bookmarks.AccountRepository;
import com.itom.nextGenDemo.bookmarks.Bookmark;
import com.itom.nextGenDemo.bookmarks.BookmarkRepository;

@EnableDiscoveryClient
@SpringBootApplication
public class NextGenDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(NextGenDemoApplication.class, args);
	}

	@Bean
	CommandLineRunner init(AccountRepository accountRepository,
	                       BookmarkRepository bookmarkRepository) {
		return args ->
				Arrays.asList("jhoeller","dsyer","pwebb","ogierke","rwinch","mfisher","mpollack","jlong")
						.forEach(username -> {
							Account account = accountRepository.save(new Account(username, "password"));
							bookmarkRepository.save(new Bookmark(account, "http://bookmark.com/1/" + username, "A description"));
							bookmarkRepository.save(new Bookmark(account, "http://bookmark.com/2/" + username, "A description"));
						});
	}

}