package educationmanager;

import java.io.File;
import java.io.IOException;

import exception.MyExcp;
import staff.Staff;

/**
 * Created by Egor on 05.10.2017.
 */

public interface IAction {
    Staff createGroup() throws IOException;
    Staff generateCourse(int maxstudCount, int maxlistCount) throws MyExcp;
    int sumRanges(Staff anyCourse);
    int countListener(Staff anyCourse);
    Staff sortbyYear(Staff anyCourse);
}
