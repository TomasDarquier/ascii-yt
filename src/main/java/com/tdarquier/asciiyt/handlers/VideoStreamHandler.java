package com.tdarquier.asciiyt.handlers;

import com.tdarquier.asciiyt.services.AsciiConverterService;
import com.tdarquier.asciiyt.services.FFmpegService;
import com.tdarquier.asciiyt.services.YTDLPService;
import com.tdarquier.asciiyt.services.YTDLPServiceImpl;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.BufferedInputStream;
import java.io.InputStream;

public class VideoStreamHandler extends TextWebSocketHandler {
    /**
     *
     * Maneja la recepcion de la URL a reproducir y se encarga
     * de enviar los frames al cliente
     *
     * @param session
     * @param message
     * @throws Exception
     */
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String videoUrl = message.getPayload();
        System.out.println("Recibida URL: " + videoUrl);

        YTDLPService service = new YTDLPServiceImpl();
        try {
            // Obtener la URL de streaming
            String streamUrl = service.getStreamUrl(videoUrl);
            Process process = FFmpegService.startStreaming(streamUrl);
            InputStream inputStream = new BufferedInputStream(process.getInputStream());

            System.out.println("Transfiriendo video en ASCII...");

            while (session.isOpen()) {
                if (inputStream.available() > 0) {
                    String ascii = AsciiConverterService.convertToAscii(inputStream, 256, 144);
                    if (ascii != null) {
                        session.sendMessage(new TextMessage("\033[H\033[2J" + ascii));  // Enviar el frame al cliente
                        Thread.sleep(200); // Controlar velocidad de envío
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


