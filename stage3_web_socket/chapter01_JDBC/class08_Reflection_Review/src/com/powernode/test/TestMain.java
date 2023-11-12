package com.powernode.test;

import com.powernode.entity.Student;
import com.powernode.util.ScoreUtil;

public class TestMain {
    public static void main(String[] args) throws Exception {
        Student student = new Student();
        ScoreUtil.set(student, "score", 32);
        System.out.println(ScoreUtil.get(student, "score"));
    }
}
