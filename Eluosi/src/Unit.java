import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Unit {
	int x,y;
	public static final int SIZE = 30;
	
	public static final int SPEED= 30;
	public boolean stoped = false;
	//小方块左上角的坐标
	public Unit(int x,int y) {
		this.x=x;
		this.y=y;
	}
	//绘制小方块
	public void draw(Graphics  g) {
		Color c =g.getColor();
		g.setColor(Color.RED);
		g.drawRect(x, y, SIZE, SIZE);
		g.setColor(c);
	}
	//下落
	public void drop() {
		y+=SPEED;
		
	}
	//检测当前状态
	public void changeStatus() {
		//如果积木的纵坐标超过界面下方stop开关打开
		if(y + SIZE >= Eluosi.CORRECT_Y + Eluosi.GAME_HEIGHT) {
			stoped = true;
		}
	}
	//键盘
	public void keyPressed(KeyEvent e) {
		//获取按键的code数值
		int key = e.getKeyCode();
		switch(key){
		case KeyEvent.VK_LEFT://左方向键
			moveLeft();
			break;
		case KeyEvent.VK_RIGHT://右方向键
			moveRight();
			break;
		}
		
	}
	private void moveRight() {
		// TODO Auto-generated method stub
		x  += Unit.SIZE;
	}
	private void moveLeft() {
		// TODO Auto-generated method stub
		x  -= Unit.SIZE;
	}
}

