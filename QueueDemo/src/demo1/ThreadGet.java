package demo1;

import java.util.concurrent.ArrayBlockingQueue;

public class ThreadGet extends Thread{
	ArrayBlockingQueue<String> abq = null ;
	
	public ThreadGet(ArrayBlockingQueue<String> abq) {
		this.abq = abq ;
	}
	
	public void run(){
		while (true) {
			try {
				//ÿ��ʮ���ӻ���������ݳ�����
				Thread.sleep(10000);
				System.err.println("��Ҫ�Ӷ�����ȡ������");
				String msg = abq.remove();
				System.err.println("��������ȡ�õ������ǣ�" + msg + " �����л������ݸ������е� ��" + abq.size());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
