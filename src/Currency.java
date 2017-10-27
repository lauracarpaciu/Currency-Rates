public class Currency {
    String currencyName;
    double rateRON;

    public Currency(String currencyName, double rateRON) {
        this.currencyName = currencyName;
        this.rateRON = rateRON;
    }
    public String getDescription() {
        return String.format("%s: %s", currencyName, Double.toString(rateRON));
    }
}
