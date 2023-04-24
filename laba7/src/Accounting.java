import java.util.Observable;
import java.util.Observer;

/**
 * Класс "Бухгалтерия"
 */
public class Accounting implements Observer {
    private static Accounting  accounting;
    private int income = 0;
    private final String PASSWORD = "admin";
    private int prise;
    private Observable shop;
    private Observable warehouse;

    /**
     * Метод распечатывает доход по паролю
     * @param psw - пароль
     */
    public void getIncome(String psw){
        if (psw.equals(PASSWORD)) {System.out.println("Your income is " + income);}
        else {
            System.out.println("Неверный пароль");
        }
    }

    private Accounting(Observable shop, Observable warehouse)
    {
        this.shop = shop;
        this.warehouse = warehouse;
        shop.addObserver(this);
        shop.addObserver(this);
    }

    public  static Accounting getInstance(Observable shop, Observable warehouse)
    {
        if (accounting == null)
            accounting = new Accounting( shop, warehouse);
        return accounting;
    }


    public void update(Observable o, Object args){
        if (o.equals(warehouse) ) {
            if (((Warehouse) o).isHaveItem())
                income += prise;
        }
        else
            prise = ((Shop) o).getPrise();
    }
}
