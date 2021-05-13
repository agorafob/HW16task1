package ua.ithillel.task3;

public class Runner {
    public void run() {
        System.out.println("Runner from task3");
        MyPhone phone = new MyPhone();
        MyPhone.SimCard sc = new MyPhone.SimCard();
        sc.setProviderName("'Life'");
        sc.setMemory(100);
        sc.greeting();
        phone.switchOn();
        sc.memoryStatus();
        phone.call(99999);
    }
}
