package demo1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * @see demo1 ArrayBlockingQueueʵ���������
 * @author Herman.Xiong
 * @date 2014��2��26�� 15:59:29
 * @version V1.0
 * @since jdk 1.6
 */
public class ArrayBlockQueueTest {
	
	/**
	 * ArrayBlockingQueue
	 * �ڹ���ʱ��Ҫָ������,������ѡ���Ƿ���Ҫ��ƽ��,
	 * �����ƽ����������true,�ȴ�ʱ������̻߳����ȵõ�����
	 * (��ʵ����ͨ����ReentrantLock����Ϊtrue�� �ﵽ���ֹ�ƽ�Ե�:���ȴ�ʱ������̻߳��Ȳ���)��
	 * ͨ��,��ƽ�Ի�ʹ���������ϸ�������,ֻ���ڵ�ȷ�ǳ���Ҫ��ʱ����ʹ������
	 * ���ǻ������������ѭ������,�˶��а� FIFO(�Ƚ��ȳ�)ԭ���Ԫ�ؽ�������
	 */
	
	public static void main(String[] args) {
		ArrayBlockQueueTest test = new ArrayBlockQueueTest() ;
		test.main();
	}
	
	void main() {
		/**
		 * newCachedThreadPool
		 * -�����ͳ��ӣ��Ȳ鿴������û����ǰ�������̣߳�����У���reuse(����).���û�У��ͽ�һ���µ��̼߳������
		 * -�����ͳ���ͨ������ִ��һЩ�����ں̵ܶ��첽������
		 * -�����һЩ�������ӵ�daemon(�ػ�����)��SERVER���õò��ࡣ
		 * -��reuse���̣߳�������timeout IDLE(���е�)�ڵĳ����̣߳�
		 * -ȱʡtimeout��60s,�������IDLEʱ�����߳�ʵ��������ֹ���Ƴ��ء�
		 * -ע�⣬����CachedThreadPool���̲߳��ص��������������TIMEOUT���������Զ�����ֹ��
		 */
		ExecutorService es = Executors.newCachedThreadPool() ;
		ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<String>(10) ;
		ThreadGet t1 = new ThreadGet(abq);
		Thread t2 = new Thread(new ThreadPut(abq));
		es.execute(t1);
		es.execute(t2);
	}

	void test0(){
		/**
		 * -newFixedThreadPool��cacheThreadPool��࣬Ҳ����reuse���ã���������ʱ���µ��߳�
		 * -�����֮��:����ʱ��㣬���ֻ���й̶���Ŀ�Ļ�̴߳��ڣ���ʱ������µ��߳�Ҫ������
		 * -ֻ�ܷ�������Ķ����еȴ���ֱ����ǰ���߳���ĳ���߳���ֱֹ�ӱ��Ƴ�����
		 * -��cacheThreadPool��ͬ��FixedThreadPoolû��IDLE���ƣ�����Ҳ�У�����Ȼ�ĵ�û�ᣬ�϶��ǳ�����
		 * -���������ϲ��TCP��UDP IDLE����֮��ģ�������FixedThreadPool�������һЩ���ȶ��̶ܹ������沢���̣߳������ڷ�����
		 * -�ӷ�����Դ���뿴��cache�غ�fixed �ص��õ���ͬһ���ײ�أ�ֻ����������ͬ:
		 * -fixed���߳����̶���������0��IDLE����IDLE��cache���߳���֧��0-Integer.MAX_VALUE(��Ȼ��ȫû������������Դ������������60��IDLE  
		 */
		ExecutorService es = Executors.newFixedThreadPool(10);
		ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<String>(10) ;
		ThreadGet t1 = new ThreadGet(abq);
		Thread t2 = new Thread(new ThreadPut(abq));
		es.execute(t1);
		es.execute(t2);
	}
	
	void test1(){
		/**
		 * newScheduledThreadPool
		 * -�������̳߳�
		 * -�����������߳̿��԰�schedule����delayִ�У�������ִ��
		 */
		ExecutorService es = Executors.newScheduledThreadPool(10);
		ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<String>(10) ;
		ThreadGet t1 = new ThreadGet(abq);
		Thread t2 = new Thread(new ThreadPut(abq));
		es.execute(t1);
		es.execute(t2);
	}
	
	void test2(){
		/**
		 * newSingleThreadExecutor
		 * -�����̣߳�����ʱ�����ֻ����һ���߳�
		 * -�õ��Ǻ�cache�غ�fixed����ͬ�ĵײ�أ����߳���Ŀ��1-1,0��IDLE����IDLE��
		 */
		ExecutorService es = Executors.newSingleThreadExecutor();
		ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<String>(10) ;
		ThreadGet t1 = new ThreadGet(abq);
		Thread t2 = new Thread(new ThreadPut(abq));
		es.execute(t1);
		es.execute(t2);
	}
}
