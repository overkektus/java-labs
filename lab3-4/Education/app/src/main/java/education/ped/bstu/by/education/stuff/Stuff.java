package education.ped.bstu.by.education.stuff;

import java.util.ArrayList;
import education.ped.bstu.by.education.units.*;

/**
 * Created by Egor on 26.09.2017.
 */

public class Stuff {

    private ArrayList<Person> personlist;

    public Stuff() {
        personlist = new ArrayList<Person>();
    }

    //TODO: constr with ArrayList
    public Stuff(ArrayList<Person> persons) {

    }

    public ArrayList<Person> getPersonlist() {
        return personlist;
    }

}
