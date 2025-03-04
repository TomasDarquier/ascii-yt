package com.tdarquier.asciiyt;

import com.tdarquier.asciiyt.services.AsciiConverterService;
import com.tdarquier.asciiyt.services.FFmpegService;
import com.tdarquier.asciiyt.services.YTDLPService;
import com.tdarquier.asciiyt.services.YTDLPServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedInputStream;
import java.io.InputStream;

@SpringBootApplication
public class AsciiytApplication {


	public static void main(String[] args) {
        SpringApplication.run(AsciiytApplication.class, args);
    }

}
