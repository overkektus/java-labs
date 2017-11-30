package ped.bstu.by.educationui.FileHelper;

import android.os.Environment;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import ped.bstu.by.educationui.Student.Student;

/**
 * Created by Egor on 20.10.2017.
 */

public class FileHelper {

    private static final int REQUEST_PERMISSION_WRITE = 1001;
    private static final String TAG_READJSON = "FileHelper(ReadJSON)";
    private static final String TAG_WRITEJSON = "FileHelper(WriteJSON)";
    private static final String TAG_FILEEXIST = "FileHelper(FileExist)";

    private static boolean  permissionGranted;

    public static boolean isPermissionGranted() {
        return permissionGranted;
    }

    public static void setPermissionGranted(boolean permissionGranted) {
        FileHelper.permissionGranted = permissionGranted;
    }

    private BufferedWriter bw;
    private static FileReader fr;

    public static String ReadJSON(File fileDir, String FILENAME) {
        String data = null;
        File file = new File(fileDir, FILENAME);
        char buf[] = new char[(int) file.length()];
        try {
            fr = new FileReader(file);
            fr.read(buf);
            data = new String(buf);
            Log.d(TAG_READJSON, "файл успешно прочитан " + data);
        }
        catch (IOException e) {
            Log.d(TAG_READJSON, "не удалось прочитать файл " + FILENAME + " ошибка: " + e.getMessage());
        }
        Log.d(TAG_READJSON, new String(buf));
        return data;
    }

    public static boolean WriteJSON(File fileDir, String FILENAME, ArrayList<Student> obj) {
        FileOutputStream fos = null;
        try {
            File file = new File(fileDir, FILENAME);
            fos = new FileOutputStream(file);
            String json = new Gson().toJson(obj);
            fos.write(json.getBytes());
        }
        catch(IOException e) {
            Log.d(TAG_WRITEJSON, "не удалось записать файл " + FILENAME + " ошибка: " + e.getMessage());
            return false;
        }
        finally {
            try {
                if(fos != null)
                    fos.close();
            }
            catch(IOException e){
                Log.d(TAG_WRITEJSON, "не удалось записать файл " + FILENAME + " ошибка: " + e.getMessage());
                return false;
            }
        }
        return true;
    }

    public static boolean FileExist(File filesDir, String FILENAME) {
        boolean rc = false;
        File f = new File(filesDir, FILENAME);
        if (rc = f.exists()) {
            Log.d(TAG_FILEEXIST, "Файл " + FILENAME + " существует");
        } else {
            Log.d(TAG_FILEEXIST, "Файл " + FILENAME + " не найден");
        }
        return rc;
    }

    // проверяем, доступно ли внешнее хранилище для чтения и записи
    public static boolean isExternalStorageWriteable(){
        String state = Environment.getExternalStorageState();
        return  Environment.MEDIA_MOUNTED.equals(state);
    }
    // проверяем, доступно ли внешнее хранилище хотя бы только для чтения
    public static boolean isExternalStorageReadable(){
        String state = Environment.getExternalStorageState();
        return  (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state));
    }

}
