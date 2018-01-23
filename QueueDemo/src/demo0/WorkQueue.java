package demo0;

import java.util.LinkedList;
/**
 * @author Herman.Xiong
 * @see ���̻߳��߳�ȥ���ж�������
 * @date 2014��2��26�� 11:53:46
 * @version V1.0
 * @since Jdk1.6
 */
@SuppressWarnings({"unused","unchecked"})
public class WorkQueue{
    
	private final int nThreads;//ͬʱ���ִ�е��̸߳���
    private final PoolWorker[] threads;//�̳߳�
	private final LinkedList queue;//�̶߳���

    public WorkQueue(int nThreads)
    {
        this.nThreads = nThreads;
        queue = new LinkedList();
        threads = new PoolWorker[nThreads];
        for (int i=0; i<nThreads; i++) {
            threads[i] = new PoolWorker();
            threads[i].start();
        }
    }

    public void execute(Runnable r) {
        synchronized(queue) {
            queue.addLast(r);
            queue.notify();
        }
    }

    /**
     * @ͬ��ȥȡ���׶���
     * @author Herman.Xiong
     * @date 2014��2��26�� 11:55:16   
     */
    private class PoolWorker extends Thread {
        public void run() {
            Runnable r;
            while (true) {
                synchronized(queue) {
                    while (queue.isEmpty()) {
                        try{
                            queue.wait();
                        }catch (InterruptedException e){
                        	e.printStackTrace();
                        }
                    }
                    r = (Runnable) queue.removeFirst();
                }
                try {
                    r.run();
                }catch (RuntimeException e) {
                	e.printStackTrace();
                }
            }
        }
    }
}

