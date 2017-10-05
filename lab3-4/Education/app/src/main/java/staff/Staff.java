package staff;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import units.Person;

/**
 * Created by Egor on 05.10.2017.
 */

public class Staff {

    private CopyOnWriteArrayList<Person> studentsList;

    public Staff() {
        studentsList = new CopyOnWriteArrayList<Person>();
    }

    public Staff(CopyOnWriteArrayList<Person> persons) {
        this.studentsList = persons;
    }

    public List<Person> getStudentsList() {
        return studentsList;
    }

    public void setStudlist(CopyOnWriteArrayList<Person> studentsList) {
        this.studentsList = studentsList;
    }

    public void add(Person elem) {
        studentsList.add(elem);
    }

    public void remove(Person elem) {
        studentsList.remove(elem);
    }

}
