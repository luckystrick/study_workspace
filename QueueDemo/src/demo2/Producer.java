package demo2;


/**
 * @see ����ƻ��������
 * @author Herman.Xiong
 */
public class Producer implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String instance;
    private Basket basket;

    public Producer(String instance, Basket basket) {
        this.instance = instance;
        this.basket = basket;
    }

    public void run() {
        try {
            while (true) {
                // ����ƻ��
                System.out.println("������׼������ƻ����" + instance);
                basket.produce();
                System.out.println("!����������ƻ����ϣ�" + instance);
                // ����300ms
                Thread.sleep(300);
            }
        } catch (InterruptedException ex) {
            System.out.println("Producer Interrupted");
        }
    }
}
