package AdanaC;

/**
 * Created by AdanaC on 04.02.2017.
 */


        import java.util.*;


public class Raiting {


    private long eng_freq;              //частота в англ языке
    private long film_freq;             //частота в фильме
    private long raiting_E_F;           //частота придуманая
    private long raitingTO_Find;        //частота для поиска, ориентир для ф-ции SHOW

    public long getEng_freq(){
        return eng_freq;
    }
    public void setEng_freq(long eng_freq){
        this.eng_freq=eng_freq;
    }


    public long getFilm_freq() {
        return film_freq;
    }

    public void setFilm_freq(long film_freq) {
        this.film_freq = film_freq;
    }

    public long getRaiting_E_F(){return  raiting_E_F;}
    public void  setRaiting_E_F(long eng_freq, long film_freq){
        raiting_E_F = (eng_freq/3000000)*film_freq;
        if (raiting_E_F <1){raiting_E_F = 1;}

    }

    public long getRaitingTO_Find() {
        return raitingTO_Find;
    }

    public void setRaitingTO_Find(long raitingTO_Find) {
        this.raitingTO_Find = raitingTO_Find;
    }

    static Map<String, Raiting> mapReiting = new LinkedHashMap<String, Raiting>();


    public static void filingReitingMap(Map<String, Long> subtitl,Map<String, Long> repydEN) {
        for (String key : subtitl.keySet()) {
            Raiting raiting = new Raiting();

            if (!Raiting.mapReiting.containsKey(key)){
                raiting.setEng_freq(repydEN.get(key));
                raiting.setFilm_freq(subtitl.get(key));
                raiting.setRaiting_E_F(raiting.getEng_freq(),raiting.getFilm_freq());

                Raiting.mapReiting.put(key,raiting);

            }
            else {
            }
        }

    }


    public static <K, V extends Comparable<? super V>> Map<K, V>   sortByValuek(Map<K, V> map )   {
        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
        Collections.sort( list, new Comparator<Map.Entry<K, V>>()      {
            @Override
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return (o2.getValue()).compareTo( o1.getValue() );
            }
        } );

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list)
        {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }


}