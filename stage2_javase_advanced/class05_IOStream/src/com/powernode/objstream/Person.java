package com.powernode.objstream;

import java.io.Serial;
import java.io.Serializable;

/**
 * 1.定义Person类实现Serializable接口，Person对象就可以进行序列化。Serializable接口没有任何抽象方法，是一个标志接口。当对象需要序列化时，要求对象的类实现该接口；
 * 2.对象序列化时，要求对象的属性也必须是可序列化的，如果对象的属性是基本类型数据则可以直接序列化；如果对象的属性是引用类型数据，则要求属性的类也要实现Serializable接口；
 * 3.使用transient把属性修饰为瞬态的，则这个属性不进行序列化；
 * 4.一般情况下，类实现了Serializable接口后，会手动在类中添加序列化版本号。
 */
public class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = -8475687445762723844L;
    /**
     * 姓名是String字符串引用 类型,String类已经实现了Serializable接口,是可序列化的
     */
    String name;
    /**
     * 基本类型数据可以直接序列化
     */
    int age;
    /**
     * 人有宠物属性,要求自定义的Pet宠物类也要实现Serializable接口,Person对象才能序列化
     */
    Pet pet;
    /**
     * 有时会使用transient把敏感数据修饰为瞬态的, 不对敏感数据序列化
     */
    transient String password;
    String gender;
    int id;

    public Person(String name, int age, Pet pet, String password, String gender) {
        this.name = name;
        this.age = age;
        this.pet = pet;
        this.password = password;
        this.gender = gender;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", pet=" + pet +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}

class Pet implements Serializable {
    //@Serial
    //private static final long serialVersionUID = -6960825477052520783L;
    String nickname;

    public Pet(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "nickname='" + nickname + '\'' +
                '}';
    }
}