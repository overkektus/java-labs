package educationmanager;

import android.os.Environment;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Comparator;
import exception.MyExcp;
import random.MyRandom;
import staff.Staff;
import units.Listener;
import units.Person;
import units.Student;

import static java.util.Comparator.comparingInt;

/**
 * Created by Egor on 05.10.2017.
 */

public class Manager implements IAction {

    Type itemsListType = new TypeToken<Staff>() {}.getType();
    private final static String filenameListener = "listener.json";
    private final static String filenameStudents = "students.json";
    File path;

    public File STUD_FILE;
    public File LIS_FILE;

    @Override
    public Staff createGroup() {
        Staff staff;
        System.out.println("\nJSON file: ");
        staff = openFile();
        return staff;
    }

    public Staff openFile() {

        Staff staff = null;
        Staff staffLis = new Staff();
        Staff staffStud = new Staff();

        FileInputStream finLis = null;
        FileInputStream finStud = null;

        File fileLis = getExternalPath(filenameListener);
        File fileStud = getExternalPath(filenameStudents);

        if(!fileLis.exists() || !fileStud.exists()) return null;
        try {
            finLis =  new FileInputStream(fileLis);
            finStud =  new FileInputStream(fileStud);

            byte[] bytesLis = new byte[finLis.available()];
            byte[] bytesStud = new byte[finStud.available()];

            finLis.read(bytesLis);
            finStud.read(bytesStud);

            String jsonLis = new String (bytesLis);
            String jsonStud = new String (bytesStud);

            staffLis = new Gson().fromJson(jsonLis, itemsListType);
            staffStud = new Gson().fromJson(jsonStud, itemsListType);
        }
        catch(IOException exp) {
            System.out.println("Exception in 'openFile'" + exp.getMessage());
        }
        finally {
            try {
                if(finStud != null)
                    finStud.close();
                if(finLis != null)
                    finLis.close();
            } catch (IOException ex) {
                System.out.println("Exception in close stream" + ex.getMessage());
            }
        }
        return staff;// = Staff.merge(staffLis, staffStud);
    }

    public File getExternalPath(String filename) {
        return(new File(Environment.getExternalStorageDirectory(), filename));
    }

    public Staff generateCourse(int maxstudCount, int maxlistCount) throws MyExcp{
        if(maxstudCount < 0 || maxlistCount < 0) {
            throw new MyExcp("MyException works", 1);
        }
        Staff staff = new Staff();
        for(int i = 0; i < maxstudCount ; i++){
            staff.add(MyRandom.randomStudent());
        }
        for(int i = 0; i < maxlistCount ; i++){
            staff.add(MyRandom.randomListener());
        }
        return staff;
    }

    public int sumRanges(Staff anyCourse) {
        int money = 0;
        for(Person person : anyCourse.getStudentsList()) {
            money += person.getMoney();
        }
        return money;
    }

    public int countListener(Staff anyCourse) {
        return anyCourse.getStudentsList().size();
    }

    @Override
    public Staff sortbyYear(Staff anyCourse) {
        anyCourse.getStudentsList().sort(Comparator.comparingInt(Person::getYear));
        return anyCourse;
    }

    public Staff sortbyName(Staff anyCourse){
        anyCourse.getStudentsList().sort(Comparator.comparing(Person::getFirstName));
        return anyCourse;
    }

}
