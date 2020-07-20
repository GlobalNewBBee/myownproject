package com.myown.game.test.multiThread;

public class MainThread {
    public static void main(String[] args) {
        PicDownloadThread thread1 = new PicDownloadThread("https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=false&word=%E7%81%AB%E5%BD%B1%E5%BF%8D%E8%80%85%E5%A3%81%E7%BA%B8&hs=0&pn=2&spn=0&di=1210&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&ie=utf-8&oe=utf-8&cl=2&lm=-1&cs=2356759438%2C3963692362&os=2729232382%2C207351720&simid=4270526130%2C652588598&adpicid=0&lpn=0&ln=30&fr=ala&fm=&sme=&cg=wallpaper&bdtype=0&oriquery=%E7%81%AB%E5%BD%B1%E5%BF%8D%E8%80%85%E5%A3%81%E7%BA%B8&objurl=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2%2F5271d1ef64db9.jpg&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3Botg9aaa_z%26e3Bv54AzdH3Fowssrwrj6_kt2_9d8ll_l_z%26e3Bip4s&gsm=3&islist=&querylist=",
                "1.jpg");
        PicDownloadThread thread2 = new PicDownloadThread("https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=false&word=%E7%81%AB%E5%BD%B1%E5%BF%8D%E8%80%85%E5%A3%81%E7%BA%B8&hs=0&pn=2&spn=0&di=56980&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&ie=utf-8&oe=utf-8&cl=2&lm=-1&cs=1419973686%2C575370551&os=2563652562%2C2020870217&simid=3321911120%2C353418305&adpicid=0&lpn=0&ln=30&fr=ala&fm=&sme=&cg=wallpaper&bdtype=0&oriquery=%E7%81%AB%E5%BD%B1%E5%BF%8D%E8%80%85%E5%A3%81%E7%BA%B8&objurl=http%3A%2F%2Fimage.namedq.com%2Fuploads%2F20190821%2F21%2F1566395320-oqlagcTSfM.jpg&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3Bgw4j1q_z%26e3Bv54AzdH3F3zAzdH3Fdncbcn_z%26e3Bip4s&gsm=1&islist=&querylist=",
                "2.jpg");
        PicDownloadThread thread3 = new PicDownloadThread("https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=false&word=%E7%81%AB%E5%BD%B1%E5%BF%8D%E8%80%85%E5%A3%81%E7%BA%B8&hs=0&pn=5&spn=0&di=58190&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&ie=utf-8&oe=utf-8&cl=2&lm=-1&cs=1022929514%2C3293360437&os=2122147983%2C1889127887&simid=3372697164%2C35387345&adpicid=0&lpn=0&ln=30&fr=ala&fm=&sme=&cg=wallpaper&bdtype=0&oriquery=%E7%81%AB%E5%BD%B1%E5%BF%8D%E8%80%85%E5%A3%81%E7%BA%B8&objurl=http%3A%2F%2Faijpg.oss-cn-shenzhen.aliyuncs.com%2Fforum%2F201611%2F05%2F192752f5x0d7ex4qclqle4.jpg&fromurl=ippr_z2C%24qAzdH3FAzdH3Fwt3r2_z%26e3Bv54AzdH3Fu5674_z%26e3Brir%3F451%3Detjopi6jw1%26pt1%3Ddddnc&gsm=6&islist=&querylist=",
                "3.jpg");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
