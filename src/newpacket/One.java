package newpacket;

import java.io.File;

class A{
    String a = "Конструктор без аргументов класса A";

    A(){
        System.out.println(a);
    }

    A(String args){
        System.out.println(a);
    }
}

class B extends A{
    String b  = "Конструктор без аргументов класса B";
    String b1 = "Конструктор с одним аргументом класса B";
    B(){
        this(""); // вызов конструктора с одним аргументом класса B
        System.out.println(b);
    }

    B(String args){
        super(""); // вызов конструктора с одним аргументом класса A
        System.out.println(b1);
    }

    static void Method(){

    }

    void Method(int i){

    }
}

// Тест-класс и вывод
class Test {

    public static void main(String args[]) {
        B b = new B();
    }
}

