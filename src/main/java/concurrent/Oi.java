package concurrent;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Oi {
    int id;
    int phone;
    String name;
    int age;
    Sex sex;
    boolean winer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public boolean isWiner() {
        return winer;
    }

    public void setWiner(boolean winer) {
        this.winer = winer;
    }

    public Oi(int id, int phone, String name, int age, Sex sex) {
        this.id = id;
        this.phone = phone;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public static void main(String[] args) {
        Random random = new Random();
        List<Oi> us = new ArrayList<>(1000);
        for (int i = 0; i < 10; i++) {
            us.add(new Oi(i, i * random.nextInt(1000), "user" + i, 17 + random.nextInt(120), random.nextInt(10) % 2 == 1 ? Sex.FAM : Sex.MAN));
        }





        boolean correct = true;



        System.out.println(correct);

        var d = us.stream().filter(x->x.getAge() > 28).distinct().peek(x->x.setWiner(true)).collect(Collectors.toMap(
                Oi::getPhone,
                Oi::getName

        ));
        System.out.println(d);

    }
}

enum Sex {
    MAN,
    FAM
}
