package com.tdarquier.asciiyt.services;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.InputStream;


import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class AsciiConverterService {
    private static final char[] CHARACTERS = {'@', '#', 'S', '%', '?', '*', '+', ';', ':', ',', '.'};

    public static String convertToAscii(InputStream imageStream) throws Exception {
        // Leer la imagen desde el InputStream
        BufferedImage img;

        try {
         img = ImageIO.read(imageStream);
        }catch (Exception e) {
            return null;
        }

        // Si no se pudo leer la imagen, retornar un mensaje de error
        if (img == null) {
            return null;
        }

        // Convertir la imagen en texto ASCII
        StringBuilder ascii = new StringBuilder();

        for (int y = 0; y < img.getHeight(); y += 4) {
            for (int x = 0; x < img.getWidth(); x += 2) {
                int pixel = img.getRGB(x, y);
                int brightness = (pixel >> 16) & 0xff; // Solo usamos el valor de rojo para el brillo
                ascii.append(CHARACTERS[brightness * CHARACTERS.length / 256]);
            }
            ascii.append("\n");
        }

        if(ascii.length() > 3000) {
            System.out.println(ascii.toString());
            return ascii.toString();
        }

        return null;
    }
}
