package com.tdarquier.asciiyt.services;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Service
public class YTDLPServiceImpl implements YTDLPService {

    /**
     *
     * @param videoUrl url del video que se desea visualizar en la terminal
     * @return URL del contenido del video, que difiere de la de la web del mismo
     * @throws Exception
     */
    @Override
    public String getStreamUrl(String videoUrl) throws Exception {
        ProcessBuilder pb = new ProcessBuilder("yt-dlp", "-f", "best" ,"--get-url", videoUrl);
        Process process = pb.start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String streamUrl = reader.readLine();
        process.waitFor();
        return streamUrl;
    }
}