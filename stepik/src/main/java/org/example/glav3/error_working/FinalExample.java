package org.example.glav3.error_working;

import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import java.util.Arrays;

public class FinalExample {
    public static void main(String[] args) {

        ClassWithFinalMethod classWithFinalMethod =  new ClassWithFinalMethod();
        ClassWithFinalMethodExtends classWithFinalMethodExtends = new ClassWithFinalMethodExtends();

        classWithFinalMethod.finalMethod();
        classWithFinalMethod.notFinalMethod();

        // вызывается родительский метод
        classWithFinalMethodExtends.finalMethod();
        classWithFinalMethodExtends.notFinalMethod();


        // пример final на полях
        ClassWithFinalField classWithFinalField = new ClassWithFinalField();
        classWithFinalField.setConstInt(1);


        // пример с final в параметрах
        int[] mas = new int[] {1, 2, 3};
        int x = 5;
        ClassWithFinalField.Person person1 = new ClassWithFinalField.Person(1, "person1");
        System.out.println("\nperson и массив до метода:");
        System.out.println(person1);
        System.out.println(Arrays.toString(mas));

        testFinalInParams(x, person1, mas);
        System.out.println("person и массив после метода:");
        System.out.println(person1);
        System.out.println(Arrays.toString(mas));


        // пример передачи final параметов
        final int[] mas2 = new int[] {1,1,1};
        final int x2 = 0;
        final ClassWithFinalField.Person person2 = new ClassWithFinalField.Person(2, "person2");
        System.out.println("\nperson2 и массив2 до метода:");
        System.out.println("x2: " + x2);
        System.out.println(person2);
        System.out.println(Arrays.toString(mas2));

        testFinalInParams2(x, person2, mas2);
        System.out.println("person2 и массив2 после метода:");
        System.out.println("x2: " + x2);
        System.out.println(person2);
        System.out.println(Arrays.toString(mas2));
    }

    // final параметры метода
    public static void testFinalInParams(final int x, final ClassWithFinalField.Person pers, final int[] arr) {
//        ошибка! нельзя изменить значение final примитива
//        x = 3;

        pers.name = "DJIGIT";

//        ошибка нельзя изменить ссылку на final объект
//        pers = new ClassWithFinalField.Person(12, "qwerty");


        arr[0] = 99;
//        ошибка нельзя изменить ссылку на final массив
//        arr = new int[] {3, 4, 5};
        System.out.println("person и массив в методе:");
        System.out.println(pers);
        System.out.println(Arrays.toString(arr));
    }

    // передача final переменных в метод
    public static void testFinalInParams2(int x, ClassWithFinalField.Person person, int[] arr) {
        x = 4;

        person.name = "aaaa";
        person = new ClassWithFinalField.Person(10, "JJJ");

        arr[0] = 55;
        arr = new int[] {6, 6, 6};

        System.out.println("person и массив в методе:");
        System.out.println("x2: " + x);
        System.out.println(person);
        System.out.println(Arrays.toString(arr));
    }
}



// пример с final классом
final class FinalClass {

}

//class B extends FinalClass {
//          // ошибка - нельзя наследоваться от final класса
//}



// пример с final методом
class ClassWithFinalMethod {

    public final void finalMethod() {
        System.out.println("final method");
    }

    public void notFinalMethod() {
        System.out.println("not final method");
    }
}

class ClassWithFinalMethodExtends extends ClassWithFinalMethod {

//    @Override
//    public void finalMethod() {
//       // 'finalMethod()' cannot override 'finalMethod()' in 'org.example.glav3.error_working.ClassWithFinalMethod'; overridden method is final
//       // ошибка: нельзя переопределить final метод
//    }
    @Override
    public void notFinalMethod() {
        System.out.println("override not final method");
    }
}



// пример с final полем
class ClassWithFinalField {

    private final int CONST_INT = 4;
    private final int[] arr = new int[] {1, 2, 3};

    private final Person person = new Person(21, "Lev");

    public void setConstInt(int constInt) {
        // ошибка, нельзя менять значение final поля
        // this.CONST_INT = constInt;

        // при этом значения в массиве или поля объекта, который в final поле поменять можно
        arr[0] = 2;
        person.age = 20;
        person.name = "Roman";

        System.out.println(Arrays.toString(arr));
        System.out.println(person);

        // сам объект заменить нельзя
//        arr = new int[] {2, 3, 4};
//        person = new Person(12, "Denis");
    }


    public static class Person {
        public int age;
        public String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
