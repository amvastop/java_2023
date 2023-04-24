/** Проект Shop содержит 3 класса: Shop - взаимодействует с покупателем,
 * Warehouse - склад
 * Accounting - бухгалтерия
 * Из консоли можно купить мебель, посмотреть товары, посмотреть доход, завершить работу программы.
 */

/* TODO:1. Используя один из шаблонов проектирования, реорганизуйте код класса бухгалтерии таким образом,
 *  чтобы можно было создать только один экземпляр бухгалтерии;
 *  2. Добавьте в проект класс DeliveryService (Доставка), который также должен получать уведомления о покупках;
 *  3. Используя один из шаблонов проектирования, реорганизуйте код проекта так, чтобы между классами была слабая связь
 *  (возможно, данный шаблон нужно использовать дважды).
 *  4. Проверьте правильность расчета дохода, исправьте при необходимости.
 */

import java.util.*;
/**
 * Класс "Магазин" осуществляет продажу мебели и уведомляет бухгалтерию и склад о новой покупке
 */
public class Shop extends Observable implements Observer{


    private boolean isSell;
    private String item;
    private int prise;

    public String getItem() {
        return item;
    }

    public int getPrise() {
        return prise;
    }

    public void update(Observable o, Object args){
        isSell = ((Warehouse) o).isHaveItem();
    }

    public  void  buyItem(String item, int prise)
    {
        this.item = item;
        this.prise = prise;
        setChanged();
        notifyObservers();
    }
    public static void main(String[] args){
        System.out.println("Добро пожаловать в магазин мебели! В наличии столы, диваны, шкафы, кухни, кресла и многое другое!");
        System.out.println("Если Вы хотите совершить покупку, введите название мебели!");
        System.out.println("Для вывода в консоль текущей выручки введите \"income\",\" \"  и пароль администратора");
        System.out.println("Для просмотра количества товара на складе введите \"товары\"");
        System.out.println("Для завершения работы введите \"break\"");
        String item;
        Map <String, Integer> price = new HashMap<>(); //ценник
        price.put("стол", 10000);
        price.put("шкаф", 50000);
        price.put("кресло", 7500);
        price.put("кухня", 150000);
        price.put("диван", 35000);
        price.put("кровать", 25000);
        Shop shop = new Shop();
        Warehouse wh = new Warehouse(shop);
        shop.addObserver(wh);
        wh.addObserver(shop);
        Accounting acc = Accounting.getInstance(shop, wh);
        wh.addObserver(acc);
        shop.addObserver(acc);
        DeliveryService deliveryService = new DeliveryService(shop, wh);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            item = scanner.nextLine();
            if (item.equals("break")){
                break;
            } else if (item.equals("товары")) {wh.printWarehouse();}
                else {
                if (item.contains("income")) {
                    acc.getIncome(item.substring(item.indexOf(" ")+1));
                } else {
                    if (price.containsKey(item)) {
                        shop.buyItem(item, price.get(item));
                        if (! shop.isSell)
                            price.remove(item);
                    }else {System.out.println("Товара \"" + item + "\" нет на складе.");}
                }
            }
        }
    }


}
