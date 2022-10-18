package game;

import java.awt.*;

public class Shell extends game.GameObject {

    //定义小球出现的角度
    double degree;

    //构造小球
    public Shell() {
        x = 200;
        y = 200;
        width = 10;
        height = 10;
        speed = 3;
        degree = Math.random()*Math.PI*2;
    }

    /**
     *     小球动画实现方法
     */
    @Override
    public void drawSelf(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.fillOval((int)x,(int)y,width,height);
        //设置炮弹的飞行轨迹
        x += speed*Math.cos(degree);
        y += speed*Math.sin(degree);
        //定义炮弹遇到边界反弹
        if(x<0 || x> Constant.GAME_WIDTH-width){
            degree = Math.PI - degree;
        }
        if(y<30 || y> Constant.GAME_HEIGHT-height){
            degree = -degree;
        }

        g.setColor(c);
    }
}
