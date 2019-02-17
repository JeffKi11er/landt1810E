package com.t3h.ngoaile;

public class Main {
    public static void main(String[] args) {
//        Main main = new Main();
//        main.exception();
        MyException exception = new MyException();
        exception.print();
    }

    private void exception(){
        try {
            String s = "232";
            int v = Integer.parseInt(s);
            System.out.println(v);
            char c = s.charAt(100);
            System.out.println(c);
        }catch (Exception ex){
            System.out.println("XAY RA NGOAI LE");
            ex.printStackTrace();
        }
        System.out.println("Ket thuc");
    }
}
