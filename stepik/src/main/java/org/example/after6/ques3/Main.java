package org.example.after6.ques3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {

        List<CannedVegetable> vegetables = new ArrayList<>();
//        method(vegetables);
        // нарушает типобезопасность, добавить в список консервированных овощей морковь
        // нет наследования никакого чтобы кастило


        // скомпилится, но при этом выдаст ошибку во время выполнения ArrayStoreException,
        // при попытке задать элемент, который может закаститься в консервированный овощь
        CannedVegetable[] vb = new CannedVegetable[2];
        method2(vb);
    }
    public static void method(List<Vegetable> vegetables) {
        vegetables.add(new Potato());
    }

    public static void method3(List<Object> objects) {

    }

    public static void method2(Vegetable[] vegetables) {
        vegetables[0] = new Potato();
    }
}


class Vegetable {
}
class CannedVegetable extends Vegetable{
}

class Potato extends Vegetable {
}