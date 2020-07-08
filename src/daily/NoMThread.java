package daily;

/**
 * @author Li-Xiaoxu
 * @version 1.0
 * @date 2020/4/28 9:52
 */
public class NoMThread {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();    //��ȡ��ʼʱ��
        for (int i = 0; i < 6; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println("start task " + i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println("end task " + i);
        }
        long endTime = System.currentTimeMillis();    //��ȡ����ʱ��
        System.out.println("��������ʱ�䣺" + (endTime - startTime) + "ms");    //�����������ʱ��  24093ms
    }
}
