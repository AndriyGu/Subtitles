package AdanaC;

/**
 * Created by AdanaC on 07.02.2017.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class EN_RU_DictionaryReader implements Serializable {


    static Map<String, String> mapEN_RU = new LinkedHashMap<String, String>();

    public static Map<String, String> readEN_RU(String filePath) throws Exception {
        String sCurrentLine;
        String[] tokens = {"", "Value not found"};

        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String sorce = "";
        String temp = "";
        while ((sCurrentLine = br.readLine()) != null) {

            if (sCurrentLine.indexOf("   ") == 0) {
                sorce = sorce + "    " + sCurrentLine;
            } else {
                sorce = sorce + sCurrentLine;
            }

        }


        int c = 0;


        for (String retval : sorce.split("\\s\\s\\s\\s\\s\\s\\s(?=[a-z])")) {

            //System.out.println("c = " + c + "  retval=" + retval);
            //System.out.println(retval.length());

            try {
                tokens = retval.split(" ", 2);
               // System.out.println("Tok_0 " + tokens[0]);
               // System.out.println("Tok_1 " + tokens[1]);

                if (tokens.length != 2) {
                    throw new Exception("bed format");
                }
                if (mapEN_RU.containsKey(tokens[0]) || tokens[0].contains("-")) {
                   // System.out.println("Duplicate  " + tokens[0] + "   -");
                } else {

                    if (tokens[0].isEmpty() || tokens[1].isEmpty()) {
                    } else {
                        mapEN_RU.put("" + tokens[0], "" + String.valueOf(tokens[1]));
                    }
                }

                c++;


                // System.out.println(retval);
            } catch (Exception e) {
                System.out.println("from EN_RUdictionary");
            }
        }

       /* for (String key : mapEN_RU.keySet()) {
            System.out.println("Key: " + key);
        }*/

        return mapEN_RU;
    }


}
