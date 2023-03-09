import java.util.ArrayList;
import java.util.Scanner;

public class Count {
    int peoples = 2;
    ArrayList<Good> goods = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void count() {
        getPeoples();
        getGoods();
        calculate();
    }

    public void getPeoples(){

        System.out.println("На сколько человек разделить счет?");
        while (true) {
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                if (number == 1) {
                    System.out.println("Расчет для одного человека не производится, введите корректное число человек");
                    scanner.nextLine();
                } else if (number < 1) {
                    System.out.println("Введите корректное число человек");
                    scanner.nextLine();
                } else {
                    peoples = number;
                    scanner.nextLine();
                    break;
                }
            }
            else
            {
                System.out.println("Необходимо ввести целое число");
                scanner.nextLine();
            }
        }
    }

    public void getGoods() {
        while (true) {
            String name = "";
            double price;
            while (name.length() == 0) {
                System.out.println("Введите название товара");
                name = scanner.nextLine().toUpperCase().trim();
            }
            System.out.println("Введите цену товара");
            while (true) {
                if (scanner.hasNextDouble()) {
                    price = scanner.nextDouble();
                    if (price <= 0) {
                        System.out.println("Цена должна быть больше 0, введите корректную цену");
                        scanner.nextLine();
                    } else {
                        break;
                    }
                } else {
                    System.out.println("Необходимо ввести корректную цену");
                    scanner.nextLine();
                }
            }
            goods.add(new Good(name, price));
            System.out.println("Вы добавили товар " + name + " с ценой " + Formatter.complexFormat(price) + "\nВведите любой символ, чтобы продолжить, или \"завершить\", чтобы перейти к подсчету");
            scanner.nextLine();
            if(scanner.nextLine().equalsIgnoreCase("завершить")) break;
        }
    }

    public void calculate(){
        double sum = 0.00;
        System.out.println("У вас " + goods.size() + Formatter.declension(goods.size()) + ":");
        for(int i = 0; i < goods.size(); i++) {
            Good good = goods.get(i);
            sum = sum + good.price;
            System.out.println((i+1) + ". " + good.name);
        }
        System.out.println("Общая сумма составляет " + Formatter.complexFormat(sum));
        System.out.println("Каждый человек должен заплатить " + Formatter.complexFormat(sum / peoples) + "\nВведите любой символ, чтобы завершить программу");
        while (true) {
            scanner.nextLine();
            break;
        }
    }
}
