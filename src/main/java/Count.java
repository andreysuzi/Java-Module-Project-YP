import java.util.Scanner;

public class Count {
    int peoples = 2;

    public void getPeoples(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("На сколько человек разделить счет?");
        while (true) {
            int number = scanner.nextInt();
            if (number == 1) {
                System.out.println("Расчет для одного человека не производится. Введите корректное число человек.");
            }
            else if (number < 1) {
                System.out.println("Введите корректное число человек.");
            }
            else {
                peoples = number;
                break;
            }
        }
    }

}
