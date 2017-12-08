package staff;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import units.Listener;
import units.Person;
import units.Student;

/**
 * Created by Egor on 05.10.2017.
 */

public class Staff {

    private ArrayList<Student> studentsList;
    private ArrayList<Listener> listenersList;

    public Staff() {
        studentsList = new ArrayList<Student>();
        listenersList = new ArrayList<Listener>();
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }

    public List<Listener> getListenerList() {
        return listenersList;
    }

    public void add(Person elem) {
        if(elem instanceof Student)
            studentsList.add((Student) elem);
        if(elem instanceof Listener)
            listenersList.add((Listener) elem);
    }

    public void remove(Person elem) {
        studentsList.remove(elem);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for(Student item : studentsList) {
            str.append(item.toString());
            str.append("\r\n");
        }
        for(Listener item : listenersList) {
            str.append(item.toString());
            str.append("\r\n");
        }
        return str.toString();
    }

}
