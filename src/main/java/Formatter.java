public class Formatter {

    public static String complexFormat(double price) {
        return round(price) + declension(price);
    }
    public static String declension(double price) {
        int roundPrice = (int) price;
        if (roundPrice % 100 < 20 && roundPrice % 100 > 4)
            return " рублей";
        else if (roundPrice % 10 == 1)
            return " рубль";
        else if (roundPrice % 10 < 5 && roundPrice % 10 > 1)
            return " рубля";
        else
            return " рублей";
    }

    public static String declension(int goods) {
        if (goods % 100 < 20 && goods % 100 > 4)
            return " товаров";
        else if (goods % 10 == 1)
            return " товар";
        else if (goods % 10 < 5 && goods % 10 > 1)
            return " товара";
        else
            return " товаров";
    }

    public static String round(double price) {
        return String.format("%.2f", price);
    }
}
