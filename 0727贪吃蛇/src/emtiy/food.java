package emtiy;

import java.util.Random;

public class food {
	int num;
	private Point[] food=new Point[1];
	public food() {
		super();
		this.num = 1;
	}
	public void givefood(Point[] ps){
		System.out.println("�����½�ʳ��");
		boolean ranfood=true;
		while (ranfood) {
			Random Random=new Random();
			int x=Random.nextInt(9)+2;
			int y=Random.nextInt(9)+2;
			Point point=new Point(x,y);
			int i=0;
			for(i=0;i<ps.length;i++){
				if(point.x==ps[i].x&&point.y==ps[i].y){
					System.out.println("ʳ��ײ����������");
					break;
				}
			}
			System.out.println("��ʱiֵΪ��"+i);
			if(i==ps.length){
				ranfood=false;
				getFood()[0]=point;
			}
			else{
				ranfood=true;
			}	
			System.out.println("���ʳ�"+getFood()[0]);
		}	
	}
	public Point[] getFood() {
		return food;
	}
	public void setFood(Point[] food) {
		this.food = food;
	}
}
