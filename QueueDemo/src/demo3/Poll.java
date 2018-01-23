package demo3;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;

/**
 * @see ����
 * @author Herman.Xiong
 *
 */
public class Poll implements Runnable{
	private ConcurrentLinkedQueue<Integer> queue=null;
	private CountDownLatch latch=null;
	
	public Poll(ConcurrentLinkedQueue<Integer> queue,CountDownLatch latch){
		this.queue=queue;
		this.latch=latch;
	}
	
	public void run() {
		/*������ConcurrentLinkedQueue��APIԭ��.size()
		��Ҫ����һ�鼯�ϵģ��ѹ���ô����
		���Ծ���Ҫ������size������isEmpty().*/
		/*while (queue.size()>0) {
			System.out.println(queue.poll());
		}
		latch.countDown();*/
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
        latch.countDown();
    }
}
