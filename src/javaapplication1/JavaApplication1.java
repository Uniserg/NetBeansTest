package javaapplication1;

import cafe.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import employees.*;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 *
 * @author Serg
 */
public class JavaApplication1 {
    
    public static Order generateOrder(ArrayList<Food> menu){
        Random random = new Random();
        int n = menu.size();
        
        Order order = new Order(new Date());
        for (int i = 0; i < 7; i++) {
            order.add(menu.get(random.nextInt(n)));
        }
        
        return order;
    }
   
    public static void main(String[] args) {
        ArrayList<Food> menuForBar = new ArrayList<>(
                Arrays.asList(
                        new Food("Коктейль", "-", 110, 120),
                        new Food("Кола", "-", 100, 1000),
                        new Food("Пиво", "-", 130, 250)    
                ));
        ArrayList<Food> menuForKitchen = new ArrayList<>(
                Arrays.asList(
                        new Food("Креветки", "-", 150, 250),
                        new Food("Бургер", "-", 150, 120),
                        new Food("Шашлык", "-", 240, 150),
                        new Food("Пицца", "-", 350, 250),
                        new Food("Блинчики", "-", 160, 200)        
                ));
        
        ArrayList<Food> stopListOfCafe = new ArrayList<>(
                Arrays.asList(
                        menuForKitchen.get(0),
                        menuForKitchen.get(2),
                        menuForBar.get(0)
                ));
        
        Cafe cafe = new Cafe(menuForKitchen, menuForBar, stopListOfCafe);
        
        cafe.setKitchen(menuForKitchen); // Создание нового меню
        
        
        System.out.println("\nДОБАВЛЕНИЕ ЗАКАЗОВ\n");
        
        //Добавление блюд в заказ с учетом стоп листа из меню бара
        for (int i = 0; i < 10; i++) {
            cafe.addOrder(generateOrder(cafe.getBarToday()));
        }
        
        //Добавление блюда из меню кухни
        for (int i = 0; i < 10; i++) {
            cafe.addOrder(generateOrder(cafe.getKitchenToday()));
        }

        cafe.getOrders().forEach(order1 -> {System.out.println(order1 + "\n");});
        
        
        System.out.println("\nЗАКРЫТИЕ ЗАКАЗОВ\n");
        for (int i = 0; i < 4; i++) {
            cafe.closeOrder(cafe.getOrders().get(i));
        }
        
        cafe.getOrders().forEach(order1 -> {System.out.println(order1 + "\n");});
        
//        Date md = new GregorianCalendar(2001, 3 , 23).getTime();
//        System.out.println(md);
//        
//        PerHour emp1 = new PerHour("Tony", "Gatte", md, "Java programmer", 1000);
//        PerHour emp2 = new PerHour("Fill", "Bonte", new GregorianCalendar(2001, 2, 30).getTime(), "Java programmer", 1000);
//        
//        Employees listEmp = new Employees();
//        listEmp.add(emp1);
//        listEmp.add(emp2);
//        
//        System.out.println(listEmp);
//        listEmp.orderBySalary().
//                forEach((e)-> System.out.print(String.format("%20d %20s %20s %20s %20s %20.2f\n", e.id, e.lastName, e.firstName, new SimpleDateFormat("dd.MM.Y").format(e.dateOfBirth) , e.job, e.getSalary())));
//         
    }
    
}
