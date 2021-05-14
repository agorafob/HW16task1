package ua.ithillel.task4;

public class MyTestClass {

    private int testClass = 10;

    public int getTestClass() {
        return testClass;
    }

    public void setTestClass(int testClass) {
        this.testClass = testClass;
    }

    public void test() {
        System.out.println("Изначальное поле класса MyTestClass: " + getTestClass());
        System.out.println("Изначальное поле класса MyStaticNested: " + new MyStaticNested().getStaticNested());
        System.out.println("Изначальное поле класса MyInner: " + new MyInner().getInner());
        System.out.println("Новое поле класса MyStaticNested из MyTestClass: " + testStatic(200));
        System.out.println("Новое поле класса MyInner из MyTestClass: " + testInner(300));
        System.out.println("Новое поле класса MyTestClass из MyStaticNested : " + new MyStaticNested().testMyTestClass(100));
        System.out.println("Новое поле класса MyInner из MyStaticNested : " + new MyStaticNested().testInner(350));
        System.out.println("Новое поле класса MyTestClass из MyInner : " + new MyInner().testMyTestClass(150));
        System.out.println("Новое поле класса MyStaticNested из MyInner: " + new MyInner().testStatic(250));
        System.out.println("----");
        System.out.println("MyLocal из MyTestClass:");
        testLocal(400);
        System.out.println("----");
        System.out.println("MyLocal из MyStaticNested:");
        new MyStaticNested().testLocal(450);
        System.out.println("----");
        System.out.println("MyLocal из MyInner:");
        new MyInner().testLocal(500);
        System.out.println("----");
    }

    public int testStatic(int digit) {
        MyStaticNested st = new MyStaticNested();
        st.setStaticNested(digit);
        return st.getStaticNested();
    }

    public int testInner(int digit) {
        MyInner inr = new MyInner();
        inr.setInner(digit);
        return inr.getInner();
    }

    public void testLocal(int digit) {
        methodForLocal(digit);
    }


    public static class MyStaticNested {
        private int staticNested = 20;

        public int getStaticNested() {
            return staticNested;
        }

        public void setStaticNested(int staticNested) {
            this.staticNested = staticNested;
        }

        public int testMyTestClass(int digit) {
            MyTestClass tst = new MyTestClass();
            tst.setTestClass(digit);
            return tst.getTestClass();
        }

        public int testInner(int digit) {
            MyTestClass tst = new MyTestClass();
            return tst.testInner(digit);
        }

        public void testLocal(int digit) {
            MyTestClass tst = new MyTestClass();
            tst.testLocal(digit);
        }
    }


    public class MyInner {
        private int inner = 30;

        public int getInner() {
            return inner;
        }

        public void setInner(int inner) {
            this.inner = inner;
        }

        public int testMyTestClass(int digit) {
            setTestClass(digit);
            return getTestClass();
        }

        public int testStatic(int digit) {
            MyStaticNested st = new MyStaticNested();
            st.setStaticNested(digit);
            return st.getStaticNested();
        }

        public void testLocal(int digit) {
            MyTestClass tst = new MyTestClass();
            tst.testLocal(digit);
        }
    }


    public void methodForLocal(int newMyLocal) {
        class MyLocal {
            private int myLocal = 40;

            public int getMyLocal() {
                return myLocal;
            }

            public void setMyLocal(int myLocal) {
                this.myLocal = myLocal;
            }

            public int testMyTestClass(int digit) {
                setTestClass(digit);
                return getTestClass();
            }

            public int testStatic(int digit) {
                MyStaticNested st = new MyStaticNested();
                st.setStaticNested(digit);
                return st.getStaticNested();
            }

            public int testInner(int digit) {
                MyTestClass.MyInner tst = new MyTestClass.MyInner();
                tst.setInner(digit);
                return tst.getInner();
            }
        }
        MyLocal tst = new MyLocal();
        System.out.println("Изначальное поле класса MyLocal:" + tst.getMyLocal());
        tst.setMyLocal(newMyLocal);
        System.out.println("Новое поле класса MyLocal : " + tst.getMyLocal());
        System.out.println("Новое поле класса MyTestClass из MyLocal : " + tst.testMyTestClass(1000));
        System.out.println("Новое поле класса MyTestStatic из MyLocal : " + tst.testStatic(2000));
        System.out.println("Новое поле класса MyInner из MyLocal : " + tst.testInner(3000));
    }


}
