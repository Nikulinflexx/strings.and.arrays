
package ru.netology.stats;

public class StatsService {

    /**
     * Метод для вычисления общей суммы всех продаж за год
     */
    public long calculateTotalSales(long[] sales) {
        long total = 0;
        for (long sale : sales) {
            total += sale;
        }
        return total;
    }

    /**
     * Метод для вычисления средней суммы продаж в месяц
     */
    public double calculateAverageMonthlySales(long[] sales) {
        if (sales.length == 0) {
            return 0;
        }
        long total = calculateTotalSales(sales);
        return (double) total / sales.length;
    }

    /**
     * Метод для нахождения месяца с максимальной суммой продаж
     */
    public int findMaxSalesMonth(long[] sales) {
        int maxIndex = 0;
        for (int i = 0; i < sales.length; i++) {
            if (sales[i] >= sales[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex + 1;
    }

    /**
     * Метод для нахождения месяца с минимальной суммой продаж
     */
    public int findMinSalesMonth(long[] sales) {
        int minIndex = 0;
        for (int i = 0; i < sales.length; i++) {
            if (sales[i] <= sales[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex + 1;
    }

    /**
     * Метод для подсчета количества месяцев, в которых продажи были ниже среднего значения
     */
    public int countMonthsBelowAverage(long[] sales) {
        double average = calculateAverageMonthlySales(sales);
        int count = 0;
        for (long sale : sales) {
            if (sale < average) {
                count++;
            }
        }
        return count;
    }


    /**
     * Метод для подсчета количества месяцев, в которых продажи были выше среднего значения
     */

    public int countMonthsAboveAverage(long[] sales) {
        double average = calculateAverageMonthlySales(sales);
        int count = 0;
        for (long sale : sales) {
            if (sale > average) {
                count++;
            }
        }
        return count;
    }
}


