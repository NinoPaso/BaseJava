package game;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;

/**
 * @Author wyj
 * TODO: 飞机游戏的主窗口
 */
public class MyGameFrame extends Frame {

    //获取图片
    Image plane = GameUtil.getImage("images/plane.png");
    Image bg = GameUtil.getImage("images/bg.jpg");
    //定义飞机对象
    Plane p = new Plane(plane,250,250,3);
    //定义炮弹对象
    //Shell s = new Shell();
    //定义集合存放多个炮弹对象
    ArrayList<Shell> shells = new ArrayList<>();
    //声明爆炸类
    Explode exp;
    //定义游戏其实结束时间
    Date startTime = new Date();
    Date endTime;
    //游戏持续时间
    int period;
    @Override
    public void paint(Graphics g){ //自动被调用，g相当于一只画笔
        //获取原本颜色
        Color c = g.getColor();
        g.drawImage(bg,0,0,null);
        p.drawSelf(g);
        for(Shell shell:shells){
            shell.drawSelf(g);
            boolean peng = shell.getRect().intersects(p.getRect());
            if(peng){
                p.live = false;
                if(exp == null){
                    exp = new Explode(p.x,p.y);
                    endTime = new Date();
                    period = (int)((endTime.getTime() - startTime.getTime())/1000);
                }
                exp.draw(g);
            }
            if(!p.live){
                g.setColor(Color.RED);
                Font f = new Font("宋体",Font.BOLD,50);
                g.setFont(f);
                g.drawString("时间：" + period + "秒", Constant.GAME_WIDTH/4, Constant.GAME_HEIGHT/2);
            }
            g.setColor(c);
        }
    }

    /*
      定义内部类的实现
      反复的重复画窗口
     */
    class PaintThread extends Thread{
        @Override
        public void run() {
            while(true){
                repaint();
                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /*
     定义键盘内部类
     */
    class KeyMonitor extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            p.addDrection(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            p.minusDrection(e);
        }
    }
    /*
      初始化主窗口
     */
    public void launchFrame(){
        this.setTitle("飞机大战");
        //设置窗口是否可见
        this.setVisible(true);
        //设置窗口的宽高
        this.setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
        this.setLocation(300,300);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        new PaintThread().start();

        this.addKeyListener(new KeyMonitor());//给窗口增加键盘的监听
        //初始化50个炮弹
        for(int i=0;i<50;i++){
            Shell s = new Shell();
            shells.add(s);
        }
    }
    //双缓冲技术
    private Image offScreenImage = null;

    @Override
    public void update(Graphics g){
        if(offScreenImage == null){
            offScreenImage = this.createImage(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
        }
        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage,0,0,null);
    }

    public static void main(String[] args) {
        MyGameFrame f = new MyGameFrame();
        f.launchFrame();
    }

}
