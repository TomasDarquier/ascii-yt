package com.tdarquier.asciiyt;

import com.tdarquier.asciiyt.services.AsciiConverterService;
import com.tdarquier.asciiyt.services.FFmpegService;
import com.tdarquier.asciiyt.services.YTDLPService;
import com.tdarquier.asciiyt.services.YTDLPServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.TextMessage;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

@SpringBootApplication
public class AsciiytApplication {


	public static void main(String[] args) {
        SpringApplication.run(AsciiytApplication.class, args);

        YTDLPService service = new YTDLPServiceImpl();
        try {
            String videoUrl = service.getStreamUrl("https://www.youtube.com/watch?v=AZdHSGHQd2Q");
            Process process = FFmpegService.startStreaming(videoUrl);

            InputStream inputStream = new BufferedInputStream(process.getInputStream());

            while (process.isAlive()) {
                if (inputStream.available() > 0) {
                    String ascii = AsciiConverterService.convertToAscii(inputStream);

                    if (ascii != null) {
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println(ascii);
                        Thread.sleep(200);
                    }
                } else {
                    System.out.println("Esperando datos...");
                }
            }

            System.out.println("FIN DEL VIDEO...");
        } catch (
                Exception e) {
            e.printStackTrace();
        }

    }

}
