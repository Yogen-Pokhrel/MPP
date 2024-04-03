package Lab2.prob2A;

public class GradeReport {
    private String grade;
    private Student student;

    GradeReport(Student stu){
        student = stu;
    }

    GradeReport(Student stu, String grade){
        this.student = stu;
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Student getStudent() {
        return student;
    }
}
