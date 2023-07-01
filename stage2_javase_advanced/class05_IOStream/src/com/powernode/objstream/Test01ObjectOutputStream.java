package com.powernode.objstream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wangjunchen
 * 演示ObjectOutputStream实现对象序列化
 */
public class Test01ObjectOutputStream {
    public static void main(String[] args) throws IOException {
        Person person1 = new Person("Apple", 24, new Pet("bob"), "123456", "male");
        Person person2 = new Person();
        person2.name = "google";
        person2.age = 18;
        person2.pet = new Pet("kobe1");
        person2.gender = "female";
        person2.password = "password";

        FileOutputStream fos = new FileOutputStream("/Volumes/ExternalHD/Projects/java/PowerNode/stage2_javase_advanced/class05_IOStream/resource/oos.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        //创建存储Perosn对象的List集合
        List<Person> list = new ArrayList<>();
        //把多个Person对象添加到list集合中
        Collections.addAll(list, person1, person2);
        //把list集合存储到oos中
        oos.writeObject(list);

        oos.close();
    }
}