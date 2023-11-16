package com.powernode.map.hash;

import java.util.HashMap;
import java.util.Objects;

public class Test07HashMapKey {
    public static void main(String[] args) {
        //定义HashMap集合存储< Car小汽车, 车主姓名>
        HashMap<Car, String> hashMap = new HashMap<>();

        hashMap.put(new Car("Benz", 100), "zhou");
        hashMap.put(new Car("MBW", 80), "wang");
        hashMap.put(new Car("Audi", 60), "li");
        hashMap.put(new Car("BYD", 30), "wu");
        hashMap.put(new Car("Hongqi", 200), "chen");
        hashMap.put(new Car("Changan", 18), "zhang");
        Car car = new Car("Changcheng", 26);
        hashMap.put(car, "zheng");

        hashMap.forEach((k, v) -> System.out.println(k + "属于:" + v));

        System.out.println(hashMap.containsKey(car));     //true
        car.price = 16;
        System.out.println(hashMap.containsKey(car));     //false
    }

    //以静态内部类的形式定义Car小汽车类, 重写equals()/hashCode()
    static class Car {
        String brand;
        int price;

        public Car(String brand, int price) {
            this.brand = brand;
            this.price = price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Car car = (Car) o;
            return price == car.price &&
                    Objects.equals(brand, car.brand);
        }

        @Override
        public int hashCode() {
            return Objects.hash(brand, price);
        }

        @Override
        public String toString() {
            return "Car{" +
                    "brand='" + brand + '\'' +
                    ", price=" + price +
                    '}';
        }
    }
}