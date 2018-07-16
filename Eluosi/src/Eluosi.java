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
		//��Ϸ����
		g.drawRect(CORRECT_X,CORRECT_Y,GAME_WIDTH,GAME_HEIGHT);
		g.setColor(c);
		//����unit����
		u.draw(g);
		//�����ж�����
		u.changeStatus();
		//���unit��stoped��ȡ��Ϊtrue
		if(!u.stoped) {
			u.drop();
		}

	}
	int x=300;
	int y=100;
	
	public static final int Width=500;
	public static final int Heigth=700;
	
	//��Ϸ�������Ͻǵ�����
	public static final int CORRECT_X=20;
	public static final int CORRECT_Y=50;
	//��Ϸ�����͸�
	public static final int GAME_WIDTH=300;
	public static final int GAME_HEIGHT=600;
	//��һ��Unit��ʵ����С���������
	Unit u = new Unit(CORRECT_X+90,CORRECT_Y-30);
	
	public void lancher(){
		//���ڳ��ֵ�λ��
		this.setLocation(x, y);
		//���ڵĴ�С
		this.setSize(Width, Heigth);
		//���ڵ�����
		this.setTitle("����˹����");
		//���ڴ�С���ɱ䣬����trueΪ�ɱ�
		this.setResizable(false);
		//��ղ��֣�����ȷ��������������Ͻǵ����꣬���п���
		this.setLayout(null);
		//���ñ���ɫ
		this.setBackground(new Color(181,181,181));
		//���ڼ�����
		this.addWindowListener(new WindowAdapter(){
			@Override
			//�˳�����
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		//�����߳�
		new Thread(new paintThread()).start();
		//����paint�������л�ͼ
		this.setVisible(true);
		//��Ӱ������
		this.addKeyListener(new KeyMoniter());

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Eluosi().lancher();
	}
	
	public class paintThread implements Runnable{
		//ִ���߳�
		public void run() {
			while(true) {
				//�ػ棨ˢ�£�
				repaint();
				//����sleep��������try
				//˯��ʱ�䣬�������Ϊ�೤ʱ��ˢ�£�Ҳ�������Ϊ�����ٶȣ����Ը�һ����ֵ��һ��
				try {
					Thread.sleep(400);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	}
//����ʱ���ڲ���
	private class KeyMoniter extends KeyAdapter{
		//����Unit�п��Ƽ��̵����Һ���
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
