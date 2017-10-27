package laura.bnr;

public class Currency {
    //    create variables
    String currencyName;
    double rateRON;

    //create constructors
    public Currency(String currencyName, double rateRON) {
        this.currencyName = currencyName;
        this.rateRON = rateRON;
    }

    // create a getter Method
    public String getDescription() {
        return String.format("%s: %s", currencyName, Double.toString(rateRON));
    }
}
