import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Unit {
	int x,y;
	public static final int SIZE = 30;
	
	public static final int SPEED= 30;
	public boolean stoped = false;
	//С�������Ͻǵ�����
	public Unit(int x,int y) {
		this.x=x;
		this.y=y;
	}
	//����С����
	public void draw(Graphics  g) {
		Color c =g.getColor();
		g.setColor(Color.RED);
		g.drawRect(x, y, SIZE, SIZE);
		g.setColor(c);
	}
	//����
	public void drop() {
		y+=SPEED;
		
	}
	//��⵱ǰ״̬
	public void changeStatus() {
		//�����ľ�������곬�������·�stop���ش�
		if(y + SIZE >= Eluosi.CORRECT_Y + Eluosi.GAME_HEIGHT) {
			stoped = true;
		}
	}
	//����
	public void keyPressed(KeyEvent e) {
		//��ȡ������code��ֵ
		int key = e.getKeyCode();
		switch(key){
		case KeyEvent.VK_LEFT://�����
			moveLeft();
			break;
		case KeyEvent.VK_RIGHT://�ҷ����
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

