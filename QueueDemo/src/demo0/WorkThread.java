package demo0;


/**
 * @see ����ȡ���������ݺ��ҵ���߼�
 * @author Herman.Xiong
 * @date 2014��2��26�� 11:56:56
 * @version V1.0
 * @since jdk 1.6
 */
public class WorkThread extends Thread{
    public static int number = 0;
	public void run() {
		try {
			number = number + 1;
			Thread.sleep(100);
			System.out.println("number = "+number);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

