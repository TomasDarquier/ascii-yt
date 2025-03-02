package com.tdarquier.asciiyt;

import com.tdarquier.asciiyt.services.YTDLPService;
import com.tdarquier.asciiyt.services.YTDLPServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AsciiytApplication {


	public static void main(String[] args) {
		SpringApplication.run(AsciiytApplication.class, args);

		YTDLPService service = new YTDLPServiceImpl();
        try {
            System.out.println(
                    "-- STREAM URL --\n" +
                    service.getStreamUrl("https://www.youtube.com/watch?v=AZdHSGHQd2Q"));
        } catch (
                Exception e) {
            throw new RuntimeException(e);
        }

    }

}
