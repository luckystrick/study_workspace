package demo1;

import java.util.concurrent.ArrayBlockingQueue;

public class ThreadPut extends Thread{
	private ArrayBlockingQueue<String> abq = null ;
	public ThreadPut (ArrayBlockingQueue<String> abq) {
		this.abq = abq ;
	}
	public void run() {
		while (true) {
			try {
				System.out.println("��Ҫ�����������������");
				//ÿ��5�����������һ������
				Thread.sleep(5000) ;
				//���������������
				abq.put("1") ;
				System.out.println("��ǰ�Ķ��������ŵ����ݵĸ����ǣ�" + abq.size());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
	}
}
