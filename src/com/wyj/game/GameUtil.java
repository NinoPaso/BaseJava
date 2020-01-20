package com.wyj.game;

import com.sun.istack.internal.NotNull;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;

public class GameUtil {
    //私有静态工具类的构造器
    private GameUtil(){
    }

    public  static Image getImage(String path){
        BufferedImage bi = null;
        try {
            URL u = GameUtil.class.getClassLoader().getResource(path);
            bi = ImageIO.read(u);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bi;
    }
}
