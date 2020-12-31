package lab11;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.Objects;

class Institute{
    private String name;
    private TreeSet<Faculty> faculties;
    
    public Institute(String name){
        this.name = name;
        this.faculties = new TreeSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeSet<Faculty> getFaculties() {
        return faculties;
    }
    
    //Метод додавання факультету
    public void addFaculty(Faculty faculty){
        if (faculty == null){
            throw new NullPointerException("Faculty cannot be null!");
        }
        faculties.add(faculty);
    }
    //Метод видалення факультету
    public void removeFaculty(Faculty faculty){
        if (faculty == null){
            throw new NullPointerException("Null value cannot be removed");
        }
        faculties.remove(faculty);
    }
    
    @Override
   public String toString(){
        return "Name ot the institute: " + name + ". List of the faculties: " + faculties;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Institute other = (Institute) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
   
   //Метод знаходження загального числа студентів
   public int getTotalNumberOfStudents(){
       if (faculties.isEmpty()){
           throw new NullPointerException("There is no faculties");
       }
       int number = 0;
       for (Faculty faculty: faculties){
          number += faculty.getNumberOfStudents();
       }
       return number;
   }
   
   //Метод знаходження факультету з найбільшим числом студентів
   public Faculty getbiggestFaculty(){
       if (faculties.isEmpty()){
           throw new NullPointerException("There is no faculties");
       }
       Faculty max = new Faculty("Empty");
       Faculty faculty;
       for(Iterator<Faculty> i = faculties.iterator(); i.hasNext();){
           faculty = i.next();
           if (max.getNumberOfStudents() < faculty.getNumberOfStudents()){
               max = faculty;
           }
       }
       return max;
   }
   
   //Метод знаходження студентів з найвищими балами
   public TreeSet<Student> getStudentWithHighestMarks(){
       if (faculties.isEmpty()){
           throw new NullPointerException("There is no faculties");
       }
       TreeSet<Student> highMarks = new TreeSet<>(new Student.StudentComparator());
       for(Iterator i = faculties.iterator(); i.hasNext();){
           Object obj = i.next();
           if (obj instanceof Faculty){
                Faculty faculty = (Faculty) obj;
                TreeSet<Student> students = faculty.getStudents();
                for (Iterator j = students.iterator(); j.hasNext(); ){
                    Object o = j.next();
                    if (o instanceof Student){
                        Student student = (Student) o;
                        if (student.getAverageMark() >= 95 && student.getAverageMark() <= 100){
                            highMarks.add(student);
                        }
                    }
                    }
           }
       }
       return highMarks;
   }
    
   
   //Метод тестового заповнення
   public void testFill(){
       Faculty fict = new Faculty("FICT");
       fict.addStudent(new Student("Ivan", "Ivanov", "IT-321", 90.1));
       fict.addStudent(new Student("Petro", "Fedorenko", "IT-232", 95.9));
       fict.addStudent(new Student("Ivan", "Oleksandrenko", "IT-21", 75));
       fict.addStudent("Anastasiya", "Vasileva", "IL -001", 95.0);
       fict.addStudent("Anna", "Makarenko", "UI-301", 100.0);
       Faculty iasa = new Faculty("IASA");
       iasa.addStudent(new Student("Valeriy", "Mensa", "KA-123", 96.7));
       iasa.addStudent(new Student("Petro", "Melenko", "AK-901", 80.5));
       iasa.addStudent(new Student("Vasyl", "Romanko", "PH-21", 75));
       Faculty tef = new Faculty("IAT");
       tef.addStudent(new Student("Serhiy", "Korolev", "RE-1", 100.0));
       tef.addStudent(new Student("Volodymyr", "Lidovskiy", "Am-321", 95.91));
       tef.addStudent(new Student("Ihor", "Molochar", "KE-3223", 60));
       tef.addStudent(new Student("Oleksiy", "Dovbush", "AE-434", 86.1));
       this.addFaculty(fict);
       this.addFaculty(iasa);
       this.addFaculty(tef);
   }
}