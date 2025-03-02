package com.tdarquier.asciiyt.services;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Service
public class YTDLPServiceImpl implements YTDLPService {

    @Override
    public String getStreamUrl(String videoUrl) throws Exception {
        ProcessBuilder pb = new ProcessBuilder("yt-dlp", "--get-url", videoUrl);
        Process process = pb.start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String streamUrl = reader.readLine();
        process.waitFor();
        return streamUrl;
    }
}