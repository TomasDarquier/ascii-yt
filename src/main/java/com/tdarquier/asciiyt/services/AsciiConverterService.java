package com.tdarquier.asciiyt.services;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.InputStream;

public class AsciiConverterService {
    private static final char[] CHARACTERS = {
            '@', '#', '8', '&', '%', '$', '*', '+', '=', '-', ':', '.', ' '
    };


    /**
     *
     * Metodo que convierte los frames de video en ASCII, corrigiendo la altura
     * para evitar que el video quede cuadrado debido a la naturaleza rectangular
     * de los caracteres
     *
     * @param imageStream Stream de contenido proveniente de YT accedido via FFmpeg
     * @param targetWidth
     * @param targetHeight
     * @return Frame en ASCII, basado en su brillo
     * @throws Exception
     */
    public static String convertToAscii(InputStream imageStream, int targetWidth, int targetHeight) throws Exception {
        // Leer la imagen desde el InputStream
        BufferedImage img;
        try {
            img = ImageIO.read(imageStream);
        } catch (Exception e) {
            return null;
        }

        if (img == null) {
            return null;
        }

        if (img.getWidth() != targetWidth || img.getHeight() != targetHeight) {
            System.out.print("...");
            return null;
        }

        StringBuilder ascii = new StringBuilder();

        // Factor de corrección para la altura (debido a la naturaleza vertical de los caracteres)
        double aspectRatio = (double) targetWidth / targetHeight;
        double characterHeightCorrection = 2.0;

        // Recorrer cada pixel y asignar un carácter según la luminosidad
        for (int y = 0; y < img.getHeight(); y += 2) {
            for (int x = 0; x < img.getWidth(); x++) {
                int pixel = img.getRGB(x, y);
                int brightness = (pixel >> 16) & 0xff; // Solo usamos el valor de rojo para el brillo
                ascii.append(CHARACTERS[brightness * CHARACTERS.length / 256]);
            }
            ascii.append("\n");
        }

        // evitar frames incompletos
        if (ascii.length() > 3000) {
            return ascii.toString();
        }

        return null;
    }
}
