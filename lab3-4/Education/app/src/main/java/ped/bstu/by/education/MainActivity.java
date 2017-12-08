package ped.bstu.by.education;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;

import educationmanager.Manager;
import exception.MyExcp;
import staff.Staff;

public class MainActivity extends AppCompatActivity {

    Type itemsListType = new TypeToken<Staff>() {}.getType();
    private final static String FILENAME_STUD = "educ.json";
    File path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        path = new File(Environment.getExternalStorageDirectory(), FILENAME_STUD);
        try {
            Manager m = new Manager();
            Staff staff = m.generateCourse(3, 5);
            System.out.println(staff.toString());
            System.out.println("Total money: " + m.sumRanges(staff));
            System.out.println("Guys: " + m.countListener(staff));
            staff = m.sortbyYear(staff);
            System.out.println("After sorting by year:");
            System.out.println(staff.toString());

            saveStaff(staff);

            /*
            staff = m.createGroup();
            staff = m.sortbyName(staff);
            System.out.println("\nAfter sorting by name:");
            System.out.println(staff.toString());
            */
        } catch (MyExcp exp) {
            System.out.println("Exception cathced: " + exp.getNumber() + " " + exp.getMessage());
        }
    }

    public void saveStaff(Staff staff){
        FileOutputStream fos = null;

        File file = path;

        try {
            fos = new FileOutputStream(file);
            Gson gson = new Gson();
            String json = gson.toJson(staff);
            fos.write(json.getBytes());
        }
        catch(IOException exp) {
            System.out.println("Exception in 'saveFile'" + exp.getMessage());
        }
        finally {
            try {
                if(fos != null)
                    fos.close();
            }
            catch(IOException exp){
                System.out.println("Exception in 'saveFile'" + exp.getMessage());
            }
        }
    }
}
