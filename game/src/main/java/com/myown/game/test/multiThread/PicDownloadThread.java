package com.myown.game.test.multiThread;

import java.io.File;
import java.net.URL;

public class PicDownloadThread extends Thread{

    private String url;

    private String filename;

    public PicDownloadThread(String url,String filename){
        this.url = url;
        this.filename = filename;
    }

    @Override
    public void run() {
        WebDownLoader.download(url,filename);
        System.out.println(filename);
    }
}
