package demo2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BlockingQueueTest {
	/**
	 * LinkedBlockingQueue��������û�����޵�
	 * (˵�Ĳ�׼ȷ���ڲ�ָ��ʱ����ΪInteger.MAX_VALUE����ҪȻ�Ļ���putʱ��ô��������)��
	 * ����Ҳ����ѡ��ָ����������������ǻ�������Ķ��У��˶��а� FIFO(�Ƚ��ȳ�)����Ԫ�ء�
	 * ����LinkedBlockingQueueʵ�����̰߳�ȫ�ģ�ʵ�����Ƚ��ȳ������ԣ�
	 * ����Ϊ�����������ߵ���ѡ��LinkedBlockingQueue ����ָ��������Ҳ���Բ�ָ����
	 * ��ָ���Ļ���Ĭ�������Integer.MAX_VALUE��������Ҫ�õ�put��take������
	 * put�����ڶ�������ʱ�������ֱ���ж��г�Ա�����ѣ�
	 * take�����ڶ��пյ�ʱ���������ֱ���ж��г�Ա���Ž�����
	 */
	public static void main(String[] args) {
		BlockingQueueTest test=new BlockingQueueTest();
		test.test0();
	}
	
	void test0(){
		// ����һ��װƻ��������
        Basket basket = new Basket();
        ExecutorService service = Executors.newCachedThreadPool();
        Producer producer = new Producer("������001", basket);
        Producer producer2 = new Producer("������002", basket);
        Consumer consumer = new Consumer("������001", basket);
        service.submit((producer));
        service.submit(producer2);
        service.submit(consumer);
        // ��������50s����������ֹͣ
        try {
            Thread.sleep(1000 * 50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.shutdownNow();
	}
}
