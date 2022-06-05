package File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class FileUtil {
    public static boolean isNullOrEmpty(Object object){
        return object == null;
    }
    public static boolean isNullOrEmpyList(List<Object> objects){
        return objects == null && objects.size() == 0;
    }
    public void writeData(List<Object> objects , String file){
        if(isNullOrEmpyList(objects)){
            return;
        }
        try {
            ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(file));
            oss.writeObject(objects);
            oss.close();
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
