package AdanaC;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by AdanaC on 21.06.2017.
 */
public class Direktory {

    public static ArrayList<File> listWithFileNames = new ArrayList<>();

    public static ArrayList<File> getListFiles(String str) {
        File f = new File(str);
        for (File s : f.listFiles()) {
            if (s.isFile()) {
                listWithFileNames.add(s);
                System.out.println(s);
            }
        }
    return listWithFileNames;
    }

    public static void createDirectory(String path, String nameDirectory){

        new File("/"+path+"/"+nameDirectory).mkdir();
    }

}
