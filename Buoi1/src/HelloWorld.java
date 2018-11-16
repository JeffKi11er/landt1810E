public class HelloWorld {

    void sayHello() {
        System.out.println("Hello world");
        System.out.println("Hello java");
    }

    void sayHelloByDay(int day) {
        if (day == 2) {
            System.out.println("Hello world");
        } else if (day == 3) {
            System.out.println("Hi world");
        } else if (day == 4) {
            System.out.println("Good morning world");
        } else if (day == 5) {
            System.out.println("Good afternoon world");
        } else if (day == 6) {
            System.out.println("Good night world");
        } else if (day == 7 || day == 8) {
            System.out.println("Good evening world");
        } else {
            System.out.println("Good bye world");
        }
    }

    void sayHelloByDayWithSwitch(int day) {
        switch (day) {
            case 2:
                System.out.println("Hello world");
                break;
            case 3:
                System.out.println("Hi world");
                break;
            case 4:
                System.out.println("Good morning world");
                break;
            case 5:
                System.out.println("Good afternoon world");
                break;
            case 6:
                System.out.println("Good night world");
                break;
            case 7:
            case 8:
                System.out.println("Good evening world");
                break;
            default:
                System.out.println("Good bye world");
                break;
        }
    }
}
