package com.tdarquier.asciiyt.services;

public class FFmpegService {
    /**
     *
     * Utiliza la herramienta FFmpeg para obtener via streaming
     * el video desde su url de contenido.
     *
     * @param videoUrl URL del contenido del video, No es lo mismo que la url de la pagina del video
     * @return process referido al stream de contenido
     * @throws Exception
     */
    public static Process startStreaming(String videoUrl) throws Exception {
        ProcessBuilder pb = new ProcessBuilder(
                "ffmpeg", "-i", videoUrl, "-vf", "fps=5,scale=256:144",//256:144
                "-vsync", "1", "-pix_fmt", "rgb24", "-flush_packets", "1",// Asegura que la imagen tenga un formato estándar
                "-f", "image2pipe", "-vcodec", "png", "pipe:1"
        );
        return pb.start();
    }
}
