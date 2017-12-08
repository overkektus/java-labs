package filehelper;

import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Egor on 17.10.2017.
 */

public class FileHelper {

    private BufferedWriter bw;
    private static FileReader fr;

    public static boolean fileExist(File filesDir, String FILENAME) {
        boolean rc = false;
        File f = new File(filesDir, FILENAME);
        if (rc = f.exists()) {
            Log.d("Log_02", "Файл " + FILENAME + " существует");
        } else {
            Log.d("Log_02", "Файл " + FILENAME + " не найден");
        }
        return rc;
    }

    public static void WriteLine(String str, File filesDir, String FILENAME) {
        File file = new File(filesDir, FILENAME);
        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bufferWriter = new BufferedWriter(fw);
            bufferWriter.write(str);
            bufferWriter.close();
            Log.d("Log_02", "успешно записан");
        }
        catch (IOException e) {
            Log.d("Log_02", e.getMessage());
        }
    }

    public static String LoadFile(File filesDir, String FILENAME) {
        File file = new File(filesDir, FILENAME);
        char buf[] = new char[(int) file.length()];
        try {
            fr = new FileReader(file);
            fr.read(buf);
            Log.d("Log_02", "файл успешно прочитан " + new String(buf));
        }
        catch (IOException e) {
            Log.d("Log_02", "не удалось прочитать файл " + FILENAME);
        }
        Log.d("Log_02", new String(buf));
        return new String(buf);
    }
}
