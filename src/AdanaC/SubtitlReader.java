package AdanaC;

/**
 * Created by AdanaC on 04.02.2017.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

import static jdk.nashorn.internal.objects.NativeString.toLowerCase;

/**
 * Created by zer0 on 28.01.2017.
 */
public class SubtitlReader {


    static Map<String, Long> mapSubt = new LinkedHashMap<String, Long>();

    public static Map<String, Long> read(Map<String, Long> mapTemp,String filePath) throws Exception {


        String sCurrentLine;
        BufferedReader br = new BufferedReader(new FileReader(filePath));

        while ((sCurrentLine = br.readLine()) != null) {
            String Str = sCurrentLine;
            //System.out.println("38");
            // делим строчку на слова с помощю split, и сравнивем с каждым ключом из mapDict
            // если соответствует добавляем ключ и значение ++1 в mapSubt

            for (String retval : Str.split("[^a-zA-Z]")) {
                retval = toLowerCase(retval);
                // System.out.println("44");
                // System.out.println(retval);

                if (mapTemp.containsKey(retval)) {   // проверяем есть ли в коллекции частот такое слово
                    if (mapSubt.containsKey(retval)) {  // проверяем есть ли в создаваемой коллекции такое слово
                        mapSubt.put(retval, Long.valueOf(mapSubt.get(retval) + 1)); //увеличиваем значение на 1

                    } else {
                        mapSubt.put(retval, Long.valueOf(1));    // устанавливаем пару ключ значение
                    }
                }
            }
        }
        return mapSubt;
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            @Override
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }


}
