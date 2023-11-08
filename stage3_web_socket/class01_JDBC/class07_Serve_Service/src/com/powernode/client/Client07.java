package com.powernode.client;

import com.powernode.entity.Dept;
import com.powernode.service.DeptService;
import com.powernode.serviceImpl.TwoServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Client07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DeptService deptService = new TwoServiceImpl();
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
                    result = deptService.insertService(new Dept(deptNo, deptName, location));
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
                    result = deptService.updateService(new Dept(deptNo, deptName, location));
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
                    result = deptService.deleteService(deptNo);
                    System.out.println(result + " user has been deleted");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error");
                }
            }
            case 4 -> {
                System.out.println("show all information");
                try {
                    List<Dept> deptList = deptService.findAll();
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
