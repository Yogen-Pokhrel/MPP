package Lab2.prob2A;

public class Student {
    private String name;
    private GradeReport gradeReport;

    public Student(String name, String grade){
        this.name  = name;
        gradeReport = new GradeReport(this, grade);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GradeReport getGradeReport() {
        return gradeReport;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Grade: " + gradeReport.getGrade();
    }
}
