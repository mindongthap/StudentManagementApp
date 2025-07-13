package service;

import model.Student;
import java.util.ArrayList;

public class StudentService {
    private ArrayList<Student> students = new ArrayList<>();

    public boolean addStudent(Student s) {
        if (students.size() >= 100) return false;
        for (Student st : students) {
            if (st.getId() == s.getId()) return false;
        }
        if (s.getGpa() < 0 || s.getGpa() > 4.0) return false;
        students.add(s);
        return true;
    }

    public boolean deleteStudent(int id) {
        return students.removeIf(s -> s.getId() == id);
    }

    public ArrayList<Student> searchByName(String name) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (s.getFullName().toLowerCase().contains(name.toLowerCase())) {
                result.add(s);
            }
        }
        return result;
    }

    public void displayAll() {
        System.out.println("ID    | Full Name                      | GPA ");
        System.out.println("------------------------------------------------");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
