package se.lexicon.course_manager.data.dao;



import se.lexicon.course_manager.data.sequencers.StudentSequencer;
import se.lexicon.course_manager.model.Student;

import java.util.Collection;
import java.util.HashSet;


public class StudentCollectionRepository implements StudentDao {



    private Collection<Student> students;

    public StudentCollectionRepository(Collection<Student> students) {
        this.students = students;
    }

    @Override
    public Student createStudent(String name, String email, String address) {
        int id = StudentSequencer.nextStudentId();
        Student newStudent = new Student(id, name, email, address);
        students.add(newStudent);
        return newStudent;
    }

    @Override
    public Student findByEmailIgnoreCase(String email) {
        return null;
    }

    @Override
    public Collection<Student> findByNameContains(String name) {
        return null;
    } // Do last

    @Override
    public Student findById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    @Override
    public Collection<Student> findAll() {
        return null;
    }

    @Override
    public boolean removeStudent(Student student) {
        if (students.contains(student)){
            students.remove(student); // Is this enough? Just remove the object Student
            //which is passed in here? Do we need to worry about how the student will be
            //removed for example by id? That is probably already implemented and no need
            //to worry about it?
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        this.students = new HashSet<>();
    }
}
