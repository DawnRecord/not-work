package daily;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Li-Xiaoxu
 * @version 1.0
 * @date 2020/4/28 9:38
 */
public class MThread {
    public static void main(String[] args) {
        // ����һ���̶���С���̳߳�:
        long startTime = System.currentTimeMillis();    //��ȡ��ʼʱ��

        ExecutorService es = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 6; i++) {
            System.out.println("task" + i + "���봦��");
            es.submit(new Task("" + i));
            System.out.println("task" + i + "�ύ��");
        }
        // �ر��̳߳�:
        es.shutdown();
        try {
            es.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        while (!es.isTerminated()){
//            try
//            {
//                Thread.sleep(1000);
//            } catch (InterruptedException e)
//            {
//                e.printStackTrace();
//            }
//
//        }
        long endTime = System.currentTimeMillis();    //��ȡ����ʱ��
        System.out.println("��������ʱ�䣺" + (endTime - startTime) + "ms");    //�����������ʱ��
    }
}

class Task implements Runnable {
    private final String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        System.out.println("start task " + name);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        System.out.println("end task " + name);
    }
}
