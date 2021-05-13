package ua.ithillel.task12;

public class Runner {

    public void run() {
        System.out.println("Runner from task12");
        MyPhoneBook pb = new MyPhoneBook();
        pb.addPhoneNumber("Alex", "44444");
        pb.addPhoneNumber("Rabota", "22222");
        pb.addPhoneNumber("Bingo", "33333");
        pb.printPhoneBook();
        System.out.println("------");
        pb.sortByName();
        pb.printPhoneBook();
        System.out.println("------");
        pb.sortByPhoneNumber();
        pb.printPhoneBook();
        System.out.println("------");
    }
}
