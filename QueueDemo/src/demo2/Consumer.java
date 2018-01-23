package demo2;

/**
 * @see ����ƻ��������
 * @author Herman.Xiong
 */
public class Consumer implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String instance;
    private Basket basket;

    public Consumer(String instance, Basket basket) {
        this.instance = instance;
        this.basket = basket;
    }

    public void run() {
        try {
            while (true) {
                // ����ƻ��
                System.out.println("������׼������ƻ����" + instance);
                System.out.println(basket.consume());
                System.out.println("!����������ƻ����ϣ�" + instance);
                // ����1000ms
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            System.out.println("Consumer Interrupted");
        }
    }
}
