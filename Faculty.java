package lab11;
import java.util.TreeSet;
import java.util.Objects;

class Faculty implements Comparable<Faculty>{
    private String name;
    private TreeSet<Student> students;
    
    public Faculty(String name){
        this.name = name;
        students = new TreeSet<>(new Student.StudentComparator());
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeSet<Student> getStudents() {
        return students;
    }

    public void setStudents(TreeSet<Student> students) {
        this.students = students;
    }
    
    //Метод знаходження числа студетів на факультеті
    public int getNumberOfStudents(){
        return students.size();
    }
    
    //Методи додавання студента
    public void addStudent(Student student){
        if (student == null){
            throw new NullPointerException("Null value cannot be added");
        } 
        students.add(student);
    }
    
    public void addStudent(String firstName, String lastName, String gradeBookId, double averageMark){
        Student student = new Student(firstName, lastName, gradeBookId, averageMark);
        addStudent(student);   
    }
    
    //Метод видалення студента
    public void removeStudent(Student student){
        if (students.isEmpty()){
            throw new NullPointerException("List of students of faculty: " + name + " is empty");
        }
        if (student == null){
            throw new NullPointerException("Null value cannot be removed");
        }
        students.remove(student);
    }
    
    @Override
    public String toString() {
        return "Name of the faculty: " + name + ". Number of students: " + getNumberOfStudents();
    } 

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
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
        final Faculty other = (Faculty) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
    
    @Override
    public int compareTo(Faculty o) {
       return this.name.compareToIgnoreCase(o.getName());
    }
}