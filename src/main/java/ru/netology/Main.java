package ru.netology;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static double DELTA = 0.1;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int normalPrice = getInfo("Введите 'честное' значение стоимости за м.кв. (Проверка проводится в диапазоне +/- 10%) :", scanner);
        List<Deal> deals = getDeals(scanner);
        informationAboutDeals(deals, normalPrice);
    }

    private static List<Deal> getDeals(Scanner scanner) {
        List<Deal> deals = new ArrayList<>();
        while (true) {
            int length = getInfo("Введите длину (или 0 для выхода) : ", scanner);
            if (length == 0) break;
            int width = getInfo("Введите ширину (или 0 для выхода) : ", scanner);
            if (width == 0) break;
            int price = getInfo("Введите общую стоимость (или 0 для выхода) : ", scanner);
            if (price == 0) break;
            deals.add(new Deal(price, length, width));
        }
        return deals;
    }

    private static int getInfo(String msg, Scanner scanner) {
        System.out.println(msg);
        return scanner.nextInt();
    }

    private static void informationAboutDeals(List<Deal> deals, int normalPrice) {
        deals.stream()
                .forEach(d -> System.out.println(d + " is clear: " + dealIsClear(d, normalPrice)));
    }

    private static boolean dealIsClear(Deal deal, int normalPrice) {
        return (normalPrice - normalPrice*DELTA <= deal.getPricePerSqMetre() && normalPrice + normalPrice*DELTA >= deal.getPricePerSqMetre());
    }
}
