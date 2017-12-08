package units;

import organization.Organizations;

/**
 * Created by Egor on 05.10.2017.
 */

public class Listener extends Person {

    private Organizations org;

    public Listener(String name, String surname, int year, Organizations org) {
        super(name, surname, year);
        this.org = org;
        setMoney(org.getMoney());
    }


    public String toString()
    {
        StringBuilder str = new StringBuilder();
        str.append(this.getFirstName() + " " + this.getLastName() + " " + this.getYear() + " " + org + " " + org.getMoney());
        return str.toString();
    }
}
