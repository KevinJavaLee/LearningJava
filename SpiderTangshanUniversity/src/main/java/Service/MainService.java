package Service;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-25-18:08
 */
public class MainService {
    public static void main(String[] args) {
        GetInfo getInfo = new GetInfo();
        Thread thread = new Thread(getInfo);
        Thread thread1 = new Thread(getInfo);
        Thread thread2 = new Thread(getInfo);
        Thread thread3 = new Thread(getInfo);
        Thread thread4 = new Thread(getInfo);
        thread.setName("线程一");
        thread1.setName("线程二");
        thread2.setName("线程三");
        thread3.setName("线程四");
        thread4.setName("线程五");
        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

    }
}
