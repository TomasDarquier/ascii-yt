package com.tdarquier.asciiyt.services;

public class FFmpegService {
    public static Process startStreaming(String videoUrl) throws Exception {
        ProcessBuilder pb = new ProcessBuilder(
                "ffmpeg", "-i", videoUrl, "-vf", "fps=5,scale=256:144",
                "-vsync", "1", "-pix_fmt", "rgb24", "-flush_packets", "1",// Asegura que la imagen tenga un formato estándar
                "-f", "image2pipe", "-vcodec", "png", "pipe:1"
        );
        return pb.start();
    }
}
