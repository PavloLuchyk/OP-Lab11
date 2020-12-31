package lab11;

public class Lab11 {

    public static void main(String[] args) {
        Institute kpi = new Institute("NTUU KPI");
        printResults(kpi);
        kpi.testFill();
        printResults(kpi);
    }
    
    //Метод виводу результатів
    public static void printResults(Institute institute){
        try{
            System.out.println("Task 1.Total number of students: " + institute.getTotalNumberOfStudents());
            System.out.println("Task 2.Faculty with the biggest number of students : " + institute.getbiggestFaculty());
            System.out.println("Task 3.List of student with the highest marks: " + institute.getStudentWithHighestMarks());
        } catch(NullPointerException | IllegalArgumentException e){
            System.out.println("Exception! "+ e.getMessage());
        }
    }   
}
