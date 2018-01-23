package demo3;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @author Herman.Xiong
 * 
 */
public class ConcurrentLinkedQueueTest {
	/**
	 * ConcurrentLinkedQueue��Queue��һ����ȫʵ�֣�Queue��Ԫ�ذ�FIFOԭ���������
	 * ����CAS����������֤Ԫ�ص�һ���ԡ� LinkedBlockingQueue��һ���̰߳�ȫ���������У�
	 * ��ʵ����BlockingQueue�ӿڣ�BlockingQueue�ӿڼ̳���java.util.Queue�ӿڣ�
	 * ��������ӿڵĻ�����������take��put�������������������Ƕ��в����������汾��
	 */

	private static ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<Integer>();
	private static int count = 2; // �̸߳���
	// CountDownLatch��һ��ͬ�������࣬�����һ�����������߳���ִ�еĲ���֮ǰ��������һ�������߳�һֱ�ȴ���
	private static CountDownLatch latch = new CountDownLatch(count);

	public static void main(String[] args) throws InterruptedException {
		long timeStart = System.currentTimeMillis();
		ExecutorService es = Executors.newFixedThreadPool(4);
		ConcurrentLinkedQueueTest.offer();
		for (int i = 0; i < count; i++) {
			es.submit(new Poll(queue,latch));
		}
		latch.await(); // ʹ�����߳�(main)����ֱ��latch.countDown()Ϊ��ż���ִ��
		System.out.println("cost time "
				+ (System.currentTimeMillis() - timeStart) + "ms");
		es.shutdown();
	}

	/**
	 * ����
	 */
	public static void offer() {
		for (int i = 0; i < 100000; i++) {
			queue.offer(i);
		}
	}
}
