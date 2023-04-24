/**
 * Склад
 */


import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

/**
 * Класс "Склад"
 */
public class Warehouse extends  Observable implements Observer {
    private Map<String, Integer> quantity = new HashMap<>();
    private boolean canBuy;
    private Observable shop;

    public Warehouse(Observable shop){
        this.shop = shop;
        quantity.put("стол", 10);
        quantity.put("шкаф", 5);
        quantity.put("кресло", 5);
        quantity.put("кухня", 2);
        quantity.put("диван", 3);
        quantity.put("кровать", 2);
        shop.addObserver(this);
    }

    public boolean isCanBuy() {
        return canBuy;
    }

    public void update(Observable o, Object args){  //обрабаьывает запрос на покупку
        String item = ((Shop) o).getItem();
        int prevValue = quantity.get(item);
        if (prevValue == 0) {
            System.out.println("Товара \"" + item + "\" нет на складе.");
            canBuy = false;
        } else {
            System.out.println("Спасибо за покупку!");
            quantity.put( item, --prevValue);
            canBuy = true;
        }
        setChanged();
        notifyObservers();
    }

    public void printWarehouse(){                      //распечатывает список товаров на складе
        for (var pr: quantity.entrySet()) {
            System.out.println(pr + " шт.");
        }
    }
}
