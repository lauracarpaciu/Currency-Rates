package laura.bnr;
import java.util.ArrayList;


public class Main {


    public static void main(String[] args) {

        String url = "http://bnr.ro/nbrfxrates.xml";

        String xmlString = new String();

        NetworkManager manager = new NetworkManager();
        try {
            xmlString = manager.getXMLString(url);
        } catch (Exception e) {
            e.getMessage();
        }
// print the result in console
        System.out.println(xmlString);
//------------------------------------------------------------------//

//        create an array with an ArrayList class


ArrayList<Currency> currencies = parseXMLString("INPUT");

        Currency usdCurrency = new Currency("N/A", 0.0);
        Currency eurCurrency = new Currency("N/A", 0.0);

        for (Currency currency : currencies) {
            if (currency.currencyName == "USD") usdCurrency = currency;
            if (currency.currencyName == "EUR") eurCurrency = currency;
        }

        printConversion(100.0, usdCurrency, eurCurrency );
//create objects: consolePrinter and filePrinter; and call print method  on main class
        ConsolePrinter consolePrinter = new ConsolePrinter();
        consolePrinter.print(currencies);

        FilePrinter filePrinter = new FilePrinter();
        filePrinter.print(currencies);
    }

// create an array , and populate this with objects;
    public static ArrayList<Currency> parseXMLString(String input) {
        ArrayList<Currency> currencies = new ArrayList<Currency>();
        currencies.add(new Currency("EUR", 4.5340));
        currencies.add(new Currency("CHF", 4.1952));
        currencies.add(new Currency("USD", 4.1702));
        return currencies;
    }

//    create method for currency conversion , and call this method on main class
    public static void printConversion(Double units, Currency fromCurrency, Currency toCurrency) {
        Double rate = fromCurrency.rateRON / toCurrency.rateRON;

        String text = String.format("%s %s = %s %s.", units, fromCurrency.currencyName, Double.toString(rate * units), toCurrency.currencyName);
        System.out.println(text);
    }

}




