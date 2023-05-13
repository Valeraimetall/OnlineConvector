import org.jetbrains.annotations.NotNull;


public class Info {

    public static void welcome() {
        System.out.println("Доброго дня.");
        System.out.println("Вас вітає розрахунковий додоток конвертації коштів");
    }

    public static void currencySelection(){
        System.out.println("Оберіть валюту для якої хотіли б зробити розрахунок:");
        System.out.println("1 - Злоти (PLN)");
        System.out.println("2 - Долар США (USD)");
        System.out.println("3 - Євро (EUR)");
    }


    public static void whatAmount (@NotNull User user) {
        System.out.println("Введіть суму, на яку ви розраховуєте придбати " + user.getCurrency().toString() + ":");
    }

    public static void course (@NotNull User user) {
        System.out.println("Чудово, наразі курс за яким ви можете придбати 1 " + user.getCurrency() + " дорівнює " + String.format("%.2f",(1.0/user.getRate())) + " грн.");
    }

    public static void printResult(@NotNull User user) {
        System.out.println("Чудово, ви можете придбати " + String.format("%.2f",user.getResult()) + " " + user.getCurrency().name());
    }

    public static void goodbye() {
        System.out.println("Дякую, що скористалися нашим додатком.");
        System.out.println("Гарного дня!");
    }
}




