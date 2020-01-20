package com.wyj.game;

import java.awt.*;

/*
    爆炸类
 */
public class Explode {
    //定义爆炸坐标
    double x,y;
    //定义图片计数变量
    int count = 0;
    //定义静态数组加载图片
    static Image[] images = new Image[16];
    //定义静态初始化块
    static{
        for(int i = 0;i<16;i++){
            images[i] = GameUtil.getImage("images/boom/e" + (i+1) +".gif");
            images[i].getWidth(null);
        }
    }

    //爆炸类画画方法
    public void draw(Graphics g){
        if(count <= 15){
            g.drawImage(images[count],(int)x,(int)y,null);
            count++;
        }
    }
    //爆炸类构造方法
    public Explode(double x,double y){
        this.x = x;
        this.y = y;
    }
}
