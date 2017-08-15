package AdanaC;
import java.util.Scanner;

/**
 * Created by AdanaC on 06.02.2017.
 */
public class Show {

    public static void show() {
        for (int i = 0; i <= 20; i++) {
            UserWords usertemp = UserWords.userWordsList.get(i);
            System.out.println("Знаете ли вы слово " + usertemp.getWordGeneral() + "?");
            System.out.println("Если легко нажмите 3, если тяжело вспоминается нажмите 2, если не знаете 1");
            Scanner sc = new Scanner(System.in); // создаём объект класса Scanner
            int f = 2;
            long temp = 0;
            System.out.print("Введите целое число: ");
            if (sc.hasNextInt() ) { // возвращает истинну если с потока ввода можно считать целое число
                f = sc.nextInt(); // считывает целое число с потока ввода и сохраняем в переменную

                if (f == 3) {  temp = usertemp.getRaiting_E_F() / 50;
                    if (temp < 2) {  temp = 2;
                        System.out.println(temp);}
                    }
                else if (f == 2) { temp = usertemp.getRaiting_E_F() / 10;
                        if (temp < 2) {   temp = 2;   System.out.println(temp);}
                    }
                else if (f == 1) {  temp = usertemp.getRaiting_E_F() - 10;
                        if (temp < 2) {
                            temp = 2; System.out.println(temp);
                        }
                    }
                usertemp.setRaiting_E_F(temp);

                } else {
                    System.out.println("Вы ввели не целое число");
                }

            }
        }
    }

