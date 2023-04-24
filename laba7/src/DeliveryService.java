import java.util.Observable;
import java.util.Observer;

public class DeliveryService  implements Observer {
    private String item;
    private Observable shop;
    private Observable warehouse;
    public DeliveryService(Observable shop, Observable warehouse)
    {
        this.shop = shop;
        this.warehouse = warehouse;
        shop.addObserver(this);
        warehouse.addObserver(this);
    }
    public void update(Observable o, Object args){
        if (o.equals(warehouse)) {
            if (((Warehouse) o).isHaveItem())
                System.out.println(item + " отправлен");;
        } else
            item = ((Shop) o).getItem();


    }




}
