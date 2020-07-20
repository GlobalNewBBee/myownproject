package com.myown.game.test.multiThread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/*
* 使用了org.apache.commons.io.FileUtils的copyURlToFile方法
* 下载图片工具类
* */
public class WebDownLoader {

    private static final String base_url = "D:\\";

    public static void download(String fromUrl, String toUrl){
        try {
            URL url = new URL(fromUrl);
            File fileName = new File(base_url+toUrl);
            FileUtils.copyURLToFile(url,fileName);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("下载失败！");
        }

    }
}
