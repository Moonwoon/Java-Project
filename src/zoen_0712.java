dimport java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
class wenjian{
	int tableNumber;
	String orderedmenu;
	int price;
	int orderedNum;
	void load() throws IOException{
		FileReader fReader=new FileReader("c:/order.txt");
		BufferedReader bReader=new BufferedReader(fReader);
		String str=null;
		while((str=bReader.readLine())!=null){
			System.out.println(str);	
		}
		bReader.close();
		fReader.close();
	}
}
public class zoen_0712 {
	private String OrderedMenu;
	private int tableNum;
	private double price;
	int count;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		FileInputStream fi1=new FileInputStream("c:/order.txt");
		int ch1;
		byte[] bt= new byte[1024];
		int i=0;
		while((ch1=fi1.read())!=-1){
			bt[i]=(byte)ch1;i++;
		}
		System.out.print(new String(bt));
		fi1.close();
		FileReader fReader=new FileReader("c:/order.txt");
		BufferedReader bReader=new BufferedReader(fReader);
		String str=null;
		while((str=bReader.readLine())!=null){
			System.out.println(str.split(",")[1]);	
		}
		bReader.close();
		fReader.close();
		
	}
}



