package AdanaC;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import AdanaC.App;

/**
 * Created by AdanaC on 20.02.2017.
 */
public class UserChoos implements Serializable {

    static Map<String, String> userS_Name_Map = new LinkedHashMap<String, String>();
    static Map<String, String> temp_UserS_Name_Map = new LinkedHashMap<String, String>();
    String name = "";


    public static Set<String> usersSets(){

        /**метод должен предоставить список пользователей которые сейчас есть в сериализовааном файле
         * */
        temp_UserS_Name_Map = SerializeblWorker.unSerialUsers("C:/1/Users", "User_LIST.xxx");
        Set<String> userSet=temp_UserS_Name_Map.keySet();
        return userSet;
    }

    public static byte newUserCreatedMetod(String name){
        /**
        * Вызываем этот метод из NewUserCreatOverwiewController
         * он возвращает
         *                  0 если пользователь добавлен
         *                  1 если пользователь с таким именем уже есть
         *                  2 если что-то не так с именем
         *
         */
        byte identif;
        String checkUser="";
        String errorMessage = "";
        temp_UserS_Name_Map = SerializeblWorker.unSerialUsers("C:/1/Users", "User_LIST.xxx");



        if (name == null || name.length() == 0) {
            identif = 2;
        } else if (temp_UserS_Name_Map.containsKey(name)) {
            identif = 1;
            }
            else{ newUser(temp_UserS_Name_Map,name
        ); identif = 0;

        }
    return identif;
    }




    /*public static String userCHoos() {



        * Вызываем этот метод из

        temp_UserS_Name_Map = SerializeblWorker.unSerialUsers("C:/1/Users", "User_LIST.xxx");
        System.out.println(temp_UserS_Name_Map.size());
        System.out.println("Insert name UserWords");
        Scanner sc = new Scanner(System.in);
        // создаём объект класса Scanner


        String nameUser = sc.nextLine();

       String nameUser="";
       String checkUser="";
        System.out.println("name UserWords is:"+ nameUser);

        if (temp_UserS_Name_Map.containsKey(nameUser)) {
            checkUser=nameUser;
            System.out.println("Пользователь "+checkUser+" выбран");
            // возвращает в Арр имя пользователя


        } else {
            System.out.println("UserWords with this name not found");
            System.out.println("Do you wont create new users profile? (y/n)");
            Scanner sc2 = new Scanner(System.in);
            String temp = sc2.nextLine();
            if (temp.equals("y")) {
                System.out.println("Insert name of user");
                Scanner sc3 = new Scanner(System.in); // вводим имя нового пользователя
                String sc3Temp = sc3.nextLine();
                newUser(temp_UserS_Name_Map,sc3Temp);
                System.out.println("Пользователь с именем " + sc3Temp + " добавлен");
                checkUser=sc3Temp;
            } else{}

        } return checkUser;
    }
*/

    public static void newUser(Map<String, String> mapNewUser,String newUserName) {
        try {
            Map<String, String> map;
            map=SerializeblWorker.unSerialUsers("C:/1/Users", "User_LIST.xxx");
            map.put(newUserName,"");
            String pathTemp = "C:/1/Users" + "/" + "User_LIST.xxx";
            FileOutputStream fos = new FileOutputStream(pathTemp);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(map);
            oos.flush();
            oos.close();
            // System.out.println("Карта  записана");






        } catch (Exception E) {
            System.out.println("Сериализация фала User_List не прошла");
            E.fillInStackTrace();
        }
    }
}








           /* if(){
                System.out.println("Пользователь с таким именем существует");
                UserChoos.newUser();
                 } else {);
                System.out.println("Пользователь с именем "+nameUser+" добавлен");

            }
            SerializeblWorker.serialUsers(userS_Name_Map, "C:/1/Users", "User_LIST.xxx");
            SerializeblWorker.serializblMetodUserList(UserWords.userWordsList, "", nameUser);
        }


        } else {System.out.println("Bed format");
        UserChoos.newUser();
        }
    }


    public static String userChoosValidation(String name) {

        return null;
    }

    ;

}
System.out.println("Пользователь с таким именем существует");
        UserChoos.newUser();*/