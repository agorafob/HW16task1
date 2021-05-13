package ua.ithillel.task12;

import java.util.*;

public class MyPhoneBook {

    private List<PhoneRecord> phoneNumbers = new ArrayList<>();


    public static class PhoneRecord {
        private String name;
        private String phone;

        public PhoneRecord(String name, String phone) {
            setName(name);
            setPhone(phone);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
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

    public List<PhoneRecord> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void addPhoneNumber(String name, String phone) {
        this.phoneNumbers.add(new PhoneRecord(name, phone));
    }

    public void printPhoneBook() {
        for (PhoneRecord ph : phoneNumbers) {
            System.out.println(ph.toString());
        }
    }


    public interface MyComparator {
        void sort();
    }

    public void sortByName() {
        MyComparator comp = new MyComparator() {
            public void sort() {
                getPhoneNumbers().sort(new Comparator<PhoneRecord>() {
                    @Override
                    public int compare(PhoneRecord o1, PhoneRecord o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                });
            }
        };
        comp.sort();
    }

    public void sortByPhoneNumber() {
        MyComparator comp = () -> {
            getPhoneNumbers().sort((o1, o2) -> o1.getPhone().compareTo(o2.getPhone()));
        };
        comp.sort();
    }
}
