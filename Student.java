package lab11;
import java.util.Comparator;
import java.util.Objects;

class Student{
    
    private String firstName;
    private String lastName;
    private String gradebookId;
    private double averageMark;
     
    public Student(String firstName, String lastName, String gradebookId, double averageMark) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gradebookId = gradebookId;
        this.averageMark = averageMark;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firsName) {
        this.firstName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGradebookId() {
        return gradebookId;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }

    @Override
    public String toString() {
        return "\n\tFull name: " + firstName + " " + lastName + ", gradebook's Id: " + gradebookId + ", average mark= " + averageMark;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (!Objects.equals(this.gradebookId, other.gradebookId)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.gradebookId);
        return hash;
    }
    
    static class StudentComparator implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getGradebookId().compareToIgnoreCase(o2.getGradebookId());
        }   
    } 
}