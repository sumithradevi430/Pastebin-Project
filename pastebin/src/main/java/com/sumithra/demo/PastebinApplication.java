package com.sumithra.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PastebinApplication {


	public static void main(String[] args) {
		String port = System.getenv("PORT");
		if (port == null) { port = "8080";  }
		SpringApplication app = new SpringApplication(PastebinApplication.class);
		app.setDefaultProperties( java.util.Collections.singletonMap("server.port", port) ); app.run(args); }
}
