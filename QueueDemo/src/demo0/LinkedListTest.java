package demo0;

/**
 * @see LinkedList���в�����(���̺߳Ͷ��߳�)
 * @author Herman.Xiong
 * @since jdk 1.6
 * @date 2014��2��26�� 11:58:10
 * @version V1.0
 */
public class LinkedListTest {

	public static void main(String[] args) {
		LinkedListTest tm=new LinkedListTest();
		tm.test1();//ֻ����ͬʱ����1���߳�
		//tm.test5();//ֻ����ͬʱ����5���߳�
	}
	
	//ֻ����ͬʱ����1���߳�
	void test1(){
		//ֻ����ͬʱ����1���߳�
		WorkQueue workQueue = new WorkQueue(1);
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			WorkThread wThread = new WorkThread();
			workQueue.execute(wThread);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	//ֻ����ͬʱ����5���߳�
	void test5(){
		//ֻ����ͬʱ����5���߳�
		WorkQueue workQueue =new WorkQueue(5);
		for (int i = 0; i < 30; i++) {
			WorkThread wThread=new WorkThread();
			workQueue.execute(wThread);
		}
	}
}
