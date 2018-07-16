import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Eluosi extends Frame{
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		Color c = g.getColor();
		g.setColor(Color.BLACK);
		//游戏界面
		g.drawRect(CORRECT_X,CORRECT_Y,GAME_WIDTH,GAME_HEIGHT);
		g.setColor(c);
		//画出unit对象
		u.draw(g);
		//引用判定函数
		u.changeStatus();
		//如果unit中stoped的取反为true
		if(!u.stoped) {
			u.drop();
		}

	}
	int x=300;
	int y=100;
	
	public static final int Width=500;
	public static final int Heigth=700;
	
	//游戏界面左上角的坐标
	public static final int CORRECT_X=20;
	public static final int CORRECT_Y=50;
	//游戏界面宽和高
	public static final int GAME_WIDTH=300;
	public static final int GAME_HEIGHT=600;
	//做一个Unit的实例，小方块的坐标
	Unit u = new Unit(CORRECT_X+90,CORRECT_Y-30);
	
	public void lancher(){
		//窗口出现的位置
		this.setLocation(x, y);
		//窗口的大小
		this.setSize(Width, Heigth);
		//窗口的名字
		this.setTitle("俄罗斯方块");
		//窗口大小不可变，换成true为可变
		this.setResizable(false);
		//清空布局，用于确认组件与容器左上角的坐标，可有可无
		this.setLayout(null);
		//设置背景色
		this.setBackground(new Color(181,181,181));
		//窗口监听器
		this.addWindowListener(new WindowAdapter(){
			@Override
			//退出窗口
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		//启动线程
		new Thread(new paintThread()).start();
		//启动paint方法进行画图
		this.setVisible(true);
		//添加按键监控
		this.addKeyListener(new KeyMoniter());

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Eluosi().lancher();
	}
	
	public class paintThread implements Runnable{
		//执行线程
		public void run() {
			while(true) {
				//重绘（刷新）
				repaint();
				//引用sleep必须引用try
				//睡眠时间，可以理解为多长时间刷新，也可以理解为下落速度，可以改一下数值试一试
				try {
					Thread.sleep(400);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	}
//按键时间内部类
	private class KeyMoniter extends KeyAdapter{
		//引用Unit中控制键盘的左右函数
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			u.keyPressed(e);
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			super.keyReleased(arg0);
		}
		
	}
}
