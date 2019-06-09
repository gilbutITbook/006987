package com.apress.prospring5.ch3;

public class FtpArtworkSender implements ArtworkSender {
    @Override
    public void sendArtwork(String artworkPath, Recipient recipient) {
        // ftp 로직을 여기에 구현
    }

    @Override
    public String getFriendlyName() {
        return "파일 전송 프로토콜";
    }

    @Override
    public String getShortName() {
        return "ftp"; 
    }
}
