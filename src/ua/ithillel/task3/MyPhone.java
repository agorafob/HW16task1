package ua.ithillel.task3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MyPhone {
    public MyPhoneBook phonebook;

    MyPhone() {
        phonebook = new MyPhoneBook();
    }

    private interface MyComparator {
        void sort();
    }

    class MyPhoneBook {

        private List<MyPhoneBook.PhoneRecord> phoneNumbers = new ArrayList<>();


        private  class PhoneRecord {
            private String name;
            private String phone;

            private PhoneRecord(String name, String phone) {
                setName(name);
                setPhone(phone);
            }

            private String getName() {
                return name;
            }

            private void setName(String name) {
                this.name = name;
            }

            private String getPhone() {
                return phone;
            }

            private void setPhone(String phone) {
                this.phone = phone;
            }


            @Override
            public String toString() {
                return "PhoneRecord{" +
                        "name='" + getName() + '\'' +
                        ", phone='" + getPhone() + '\'' +
                        '}';
            }
        }

        public List<MyPhoneBook.PhoneRecord> getPhoneNumbers() {
            return phoneNumbers;
        }

        private void addPhoneNumber(String name, String phone) {
            this.phoneNumbers.add(new MyPhoneBook.PhoneRecord(name, phone));
        }

        private void printPhoneBook() {
            for (MyPhoneBook.PhoneRecord ph : phoneNumbers) {
                System.out.println(ph.toString());
            }
        }




        private void sortByName() {
            MyComparator comp = new MyComparator() {
                public void sort() {
                    getPhoneNumbers().sort(new Comparator<MyPhoneBook.PhoneRecord>() {
                        @Override
                        public int compare(MyPhoneBook.PhoneRecord o1, MyPhoneBook.PhoneRecord o2) {
                            return o1.getName().compareTo(o2.getName());
                        }
                    });
                }
            };
            comp.sort();
        }

        private void sortByPhoneNumber() {
            MyComparator comp = () -> {
                getPhoneNumbers().sort((o1, o2) -> o1.getPhone().compareTo(o2.getPhone()));
            };
            comp.sort();
        }
    }

    static class SimCard {
        private String providerName;
        private int memory;
        private MyPhoneBook phonebook;

        public String getProviderName() {
            return providerName;
        }

        public void setProviderName(String providerName) {
            this.providerName = providerName;
        }

        public int getMemory() {
            return memory;
        }

        public void setMemory(int memory) {
            this.memory = memory;
        }

        public void memoryStatus() {
            System.out.println("Memory used: " + phonebook.phoneNumbers.size() + '/' + "Memory left: " + (getMemory() - phonebook.phoneNumbers.size()));
        }

        public void greeting() {
            System.out.println("Welcome to " + getProviderName());
        }
    }

    public void switchOn() {
        System.out.println("Loading PhoneBook records…");
        phonebook.addPhoneNumber("Alex", "44444");
        phonebook.addPhoneNumber("Rabota", "22222");
        phonebook.addPhoneNumber("Bingo", "33333");
        phonebook.addPhoneNumber("Cafe", "11111");
        phonebook.addPhoneNumber("Dom", "55555");
        phonebook.addPhoneNumber("Epicentr", "88888");
        phonebook.addPhoneNumber("Genadiy Petrovich", "77777");
        phonebook.addPhoneNumber("Veterinar", "99999");
        phonebook.addPhoneNumber("Volodya Rabota", "66666");
        phonebook.addPhoneNumber("Internet", "01010");
        System.out.println("Loading is complete");
    }

    public void call(int phoneNumber) {
        int counter = 0;
        for (int i = 0; i < phonebook.phoneNumbers.size(); i++) {
            if (phonebook.phoneNumbers.get(i).getPhone().equals(String.valueOf(phoneNumber))) {
                System.out.println("Calling to " + phonebook.phoneNumbers.get(i).toString());
                counter++;
            }
        }
        if (counter == 0) {
            System.out.println("No such number");
        }
    }
}
