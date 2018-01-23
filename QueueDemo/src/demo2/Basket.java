package demo2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @see ����װƻ��������
 * @author Herman.Xiong
 */
public class Basket {
	// ���ӣ��ܹ�����3��ƻ��
    BlockingQueue<String> basket = new LinkedBlockingQueue<String>(3);

    // ����ƻ������������
    public void produce() throws InterruptedException {
        // put��������һ��ƻ������basket���ˣ��ȵ�basket��λ��
        basket.put("An apple");
    }

    // ����ƻ������������ȡ��
    public String consume() throws InterruptedException {
        // take����ȡ��һ��ƻ������basketΪ�գ��ȵ�basket��ƻ��Ϊֹ(��ȡ���Ƴ��˶��е�ͷ��)
        return basket.take();
    }
}
