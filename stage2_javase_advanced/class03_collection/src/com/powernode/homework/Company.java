package com.powernode.homework;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Company {
    private List<Employee> employeeList = new ArrayList<>();

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    /**
     * 添加员工, 通过参数接收员工, 返回布尔值表示添加成功与否
     *
     * @param employee 员工集合
     * @return 添加成功或者失败
     */
    public boolean add(Employee employee) {
        return employeeList.add(employee);
    }

    /**
     * 提供方法显示员工，遍历
     */
    public void showAll() {
        System.out.println("--------------------员工信息----------------------");
        for (Iterator<Employee> iterator = employeeList.iterator(); iterator.hasNext(); ) {
            Employee next = iterator.next();
            System.out.println(next);
        }
    }

    /**
     * 提供方法,判断是否包含指定姓名的员工
     * 注意: 方法形参是引用对象,在方法体中调用形参对象的方法或者访问形参对象的属性前,
     * 通常会先判断形参对象是否为null,为了避免出现空指针异常
     *
     * @param name 员工姓名
     */
    public void containsName(String name) {
        for (Employee e : employeeList) {
            if (e.getName().equals(name)) {
                System.out.println("包含");
                return;
            }
        }
        System.out.println("不包含");
    }

    /**
     * 删除指定姓名的员工
     *
     * @param name 员工姓名
     * @return 删除成功与否
     */
    public boolean deleteByName(String name) {
        for (Iterator<Employee> iterator = employeeList.iterator(); iterator.hasNext(); ) {
            Employee next = iterator.next();
            if (next.getName().equals(name)) {
                iterator.remove();
                System.out.println("删除成功");
                return true;
            }
        }
        System.out.println("员工不存在，删除失败");
        return false;
    }

    /**
     * 根据姓名升序排序
     */
    public void sortByName() {
        employeeList.sort((o1, o2) -> {
            if (o1.getName() == null) return 1;
            if (o2.getName() == null) return -1;
            return o1.getName().compareTo(o2.getName());
        });
    }

    /**
     * 根据年龄升序排序, 如果年龄相同再根据工资降序
     */
    public void sortByAgeAndSalary() {
        employeeList.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getAge() != o2.getAge()) return Integer.compare(o1.getAge(), o2.getAge());
                return Double.compare(o2.getSalary(), o1.getSalary());
            }


        });
    }

}