package com.powernode.client;

import com.powernode.dao.DeptDao;
import com.powernode.entity.Dept;

import java.util.List;
import java.util.Scanner;

public class Client05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DeptDao deptDao = new DeptDao();
        System.out.println("1. insert");
        System.out.println("2. update");
        System.out.println("3. delete");
        System.out.println("4. showAll");
        int flag = scanner.nextInt();
        int deptNo, result;
        String deptName;
        String location;

        switch (flag) {
            case 1 -> {
                System.out.println("please enter deptNo:");
                deptNo = scanner.nextInt();
                System.out.println("please enter deptName:");
                deptName = scanner.next();
                System.out.println("please enter location:");
                location = scanner.next();
                try {
                    result = deptDao.insertDept(new Dept(deptNo, deptName, location));
                    System.out.println(result + " new user has been registered");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error!!!");
                }
            }
            case 2 -> {
                System.out.println("please enter deptNo:");
                deptNo = scanner.nextInt();
                System.out.println("please enter deptName:");
                deptName = scanner.next();
                System.out.println("please enter location:");
                location = scanner.next();
                try {
                    result = deptDao.updateDao(new Dept(deptNo, deptName, location));
                    System.out.println(result + " user has been updated");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error!!!");
                }
            }
            case 3 -> {
                System.out.println("please enter deptNo:");
                deptNo = scanner.nextInt();
                try {
                    result = deptDao.deleteDao(deptNo);
                    System.out.println(result + " user has been deleted");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error");
                }
            }
            case 4 -> {
                System.out.println("show all information");
                try {
                    List<Dept> deptList = deptDao.findAll();
                    for (Dept dept : deptList) {
                        System.out.println(dept);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            default -> System.out.println("error!!!!");
        }
    }
}
