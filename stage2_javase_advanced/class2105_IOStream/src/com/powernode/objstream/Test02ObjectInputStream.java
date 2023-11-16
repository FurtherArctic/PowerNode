package com.powernode.objstream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * @author wangjunchen
 * 使用ObjectInputStream进行反序列化
 */
public class Test02ObjectInputStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("/Volumes/ExternalHD/Projects/java/PowerNode/stage2_javase_advanced/class05_IOStream/resource/oos.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        List<Person> list = (List<Person>) ois.readObject();
        for (Person person : list) {
            System.out.println(person);
        }

    }
}