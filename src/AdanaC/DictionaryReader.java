package AdanaC;

/**
 * Created by AdanaC on 04.02.2017.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;


public class DictionaryReader implements Serializable {

    static Map<String, Long> mapDict = new LinkedHashMap<String, Long>();

    public static Map<String, Long> read(String filePath) throws Exception{
        String sCurrentLine;
        BufferedReader br =  new BufferedReader(new FileReader(filePath));

        while ((sCurrentLine = br.readLine()) != null) {

            //System.out.println(sCurrentLine);
            //System.out.println("probel");
            String[] tokens = sCurrentLine.split("\t");
            if (tokens.length!=2){throw new Exception("bed format");}
            mapDict.put(tokens[0],Long.valueOf(tokens[1]));


        }



        return  mapDict;
    }
}