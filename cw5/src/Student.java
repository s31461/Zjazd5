import java.util.ArrayList;
import java.util.Date;
public class Student {
    String firstName;
    String lastName;
    String email;
    String address;
    String phone;
    Date Date;
    String index;
    String status;
    StudyProgramme studyProgramme;
    static int studentIdx = 0;
    ArrayList<Grade> grades = new ArrayList();
    int currentSemester = 1;
    public Student(String firstName, String lastName, String email, String address, String phone, Date Date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.Date = Date;
        this.index = generateIndex();
        this.status = getStatusBySemester();
    }
    private String generateIndex() {
        return "s" + studentIdx++;
    }
    private String getStatusBySemester() {
        if (currentSemester == 1) {
            return "Candidate";
        } else if (currentSemester > 1) {
            return "Student";
        } else if (currentSemester >= 7) {
            return "Graduate";
        } else {
            return "";
        }}
    public void enrollStudent(StudyProgramme programme) {
        studyProgramme = programme;
    }
    public void addGrade(int grade, String subject) {
        Grade newGrade = new Grade(grade, subject);
        grades.add(newGrade);
    }
    public int getNumberOfITNs() {
        int count = 0;
        for (int i = 0; i < grades.size(); i++) {
            if (grades.get(i).grade == 2) {
                count++;
            }}
        return count;
    }
    private static ArrayList<Student> student = new ArrayList<>();
        public static void promoteAllStudents() {
            for(int i = 0; i < student.size(); i++) {
                Student currentStudent = student.get(i);
                boolean canBePromoted = currentStudent.getNumberOfITNs() < currentStudent.studyProgramme.allowedITN && currentStudent.status != "Graduate";
                if (canBePromoted) {
                    currentStudent.currentSemester++;
                } else {
                    System.out.println("Can't be promoted.");
                    return;
}}}
    public static void displayInfoAboutAllStudents() {
        for(int i = 0; i < student.size(); i++) {
            Student currentStudent = student.get(i);
            System.out.println(currentStudent.firstName + " " + currentStudent.lastName + " - " + currentStudent.currentSemester);
        }}}