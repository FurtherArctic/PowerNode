package com.powernode.homework;

public class TestAll {
    public static void main(String[] args) {
        //testStudent();

        testEmployee();
    }

    private static void testStudent() {
        Student student2 = new Student("apple", 65, 23);
        Student student1 = new Student("apple", 65, 23);
        System.out.println(student1.equals(student2));
    }

    public static void testEmployee() {
        Company company = new Company();
        company.add(new Employee("Google", 21, 12000));
        company.add(new Employee("Apple", 21, 12002));
        company.add(new Employee("Facebook", 22, 12300));
        company.add(new Employee("Oracle", 20, 12030));
        company.add(new Employee("Microsoft", 42, 12700));
        company.add(new Employee("IBM", 21, 17400));


        company.showAll();
        company.containsName("Google");
        company.containsName("Apple2");
        System.out.println("================================================================");
        //company.deleteByName("Google");
        company.showAll();
        company.sortByName();
        company.showAll();
        System.out.println("================================================================");
        company.sortByAgeAndSalary();
        company.showAll();

    }
}