package com.tdarquier.asciiyt.services;

public interface YTDLPService{
    /**
     *
     * Solicita la url de un video de youtube.com y retorna el enlace
     * para obtener el stream del contenido audiovisual correspondiente
     *
     * @param videoUrl url del video que se desea visualizar en la terminal
     * @return url del stream de contenido del video especificado
     * @throws Exception
     */
    String getStreamUrl(String videoUrl) throws Exception;
}
