
public class OnlineConvector {
    public static void main(String[] args) {


        User user = new User();

        Info.welcome(); // вітання

        user.setCurrency(InputScanner.chooseCurrency());    //  вибір та зберігання валюти в User

        HttpExchangeRateRequest httpExchangeRateRequest = new HttpExchangeRateRequest();    //  http-запрос

        user.setRate(httpExchangeRateRequest.exchangeRateRequest(user));    //  отримання актуального курсу обраної валюти

        Info.course(user);  //  інформація про сьогоднішній курс

        user.setSum(InputScanner.inputSum(user));   //  внесення та зберігання бажаної суми

        user.setResult(user.getSum() * user.getRate());    //   розрахунок та зберігання сумми обміну

        Info.printResult(user);

        Info.goodbye();


























    }
}
