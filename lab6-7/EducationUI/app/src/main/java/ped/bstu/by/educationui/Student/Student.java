package ped.bstu.by.educationui.Student;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Egor on 20.11.2017.
 */

public class Student implements Parcelable {

    private String FirstName;
    private String MiddleName;
    private String LastName;
    private String Birthday;
    private String Address;
    private String Type;

    public Student() {
        FirstName = "";
        MiddleName = "";
        LastName = "";
        Birthday = "";
        Address = "";
        Type = "";
    }

    public Student(String firstName, String middleName, String lastName, String birthday, String address, String type) {
        FirstName = firstName;
        MiddleName = middleName;
        LastName = lastName;
        Birthday = birthday;
        Address = address;
        Type = type;
    }

    public Student(Parcel in) {
        String[] data = new String[6];
        in.readStringArray(data);
        FirstName= data[0];
        MiddleName = data[1];
        LastName = data[2];
        Birthday = data[3];
        Address = data[4];
        Type = data[5];
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String age) {
        Birthday = age;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[] { FirstName, MiddleName, LastName, Birthday, Address, Type });
    }

    public static final Parcelable.Creator<Student> CREATOR = new Parcelable.Creator<Student>() {

        @Override
        public Student createFromParcel(Parcel source) {
            return new Student(source);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    @Override
    public String toString() {
        return "Student{ FirstName: " + FirstName + "; "
                        + "MiddleName: " + MiddleName + "; "
                        + "LastName: " + LastName + "; "
                        + "Birthday: " + Birthday + "; "
                        + "Address: " + Address + "; "
                        + "Type: " + Type
                + " }";
    }
}