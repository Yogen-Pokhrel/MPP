package Lab2.client;

import Lab2.prob2A.Student;

public class Prob2AClient {
    public static void main(String[] args) {
        Student s1 = new Student("Yogen", "A");
        s1.getGradeReport().setGrade("A+");
        Student s2 = new Student("Saurab", "A+");
        s1.getGradeReport().setGrade("A+");
        Student s3 = new Student("Abraham", "A-");
        s3.getGradeReport().setGrade("A+");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
