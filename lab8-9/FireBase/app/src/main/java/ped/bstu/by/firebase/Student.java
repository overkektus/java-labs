package ped.bstu.by.firebase;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Egor on 30.11.2017.
 */

public class Student implements Parcelable {

    private String profileImageUrl;
    private String Faculty, Course, Group;
    private String FirstName, MiddleName, LastName;
    private String Birthday, Address, Type;


    public Student() {
        profileImageUrl = "default.jpg";
        Faculty = "";
        Course = null; Group = null;
        FirstName = ""; MiddleName = ""; LastName = "";
        Birthday = "";
        Address = "";
        Type = "";
    }

    public Student(String img,
                   String faculty, String course, String group,
                   String firstName, String middleName, String lastName,
                   String birthday, String address, String type) {
        profileImageUrl = img;
        Faculty = faculty; Course = course; Group = group;
        FirstName = firstName; MiddleName = middleName; LastName = lastName;
        Birthday = birthday; Address = address; Type = type;
    }

    public Student(Parcel in) {
        String[] data = new String[10];
        in.readStringArray(data);
        profileImageUrl = data[0];
        Faculty = data[1];
        Course = data[2];
        Group = data[3];
        FirstName = data[4];
        MiddleName = data[5];
        LastName = data[6];
        Birthday = data[7];
        Address = data[8];
        Type = data[9];
    }

    public String getFaculty() {
        return Faculty;
    }

    public void setFaculty(String faculty) {
        Faculty = faculty;
    }

    public String getCourse() {
        return Course;
    }

    public void setCourse(String course) {
        Course = course;
    }

    public String getGroup() {
        return Group;
    }

    public void setGroup(String group) {
        Group = group;
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
        dest.writeStringArray(new String[] { profileImageUrl, Faculty, Course, Group, FirstName, MiddleName, LastName, Birthday, Address, Type });
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
        return "Student{ "
                + "profileImageUrl" + profileImageUrl + "; "
                + "Faculty: " + Faculty + "; "
                + "Course: " + Course + "; "
                + "Group: " + Group + "; "
                + "FirstName: " + FirstName + "; "
                + "MiddleName: " + MiddleName + "; "
                + "LastName: " + LastName + "; "
                + "Birthday: " + Birthday + "; "
                + "Address: " + Address + "; "
                + "Type: " + Type
                + " }";
    }

}
