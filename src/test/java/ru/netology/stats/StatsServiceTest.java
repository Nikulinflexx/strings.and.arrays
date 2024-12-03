package ru.netology.stats;

import org.junit.Test;
import static org.junit.Assert.*;

public class StatsServiceTest {

    private final long[] sales = {8L, 15L, 13L, 15L, 17L, 20L, 19L, 20L, 7L, 14L, 14L, 18L};

    @Test
    public void testCalculateTotalSales() {
        StatsService service = new StatsService();
        long expected = 180;
        assertEquals(expected, service.calculateTotalSales(sales));
    }

    @Test
    public void testCalculateAverageMonthlySales() {
        StatsService service = new StatsService();
        double expected = 15.0;
        assertEquals(expected, service.calculateAverageMonthlySales(sales), 0.01);
    }

    @Test
    public void testFindMaxSalesMonth() {
        StatsService service = new StatsService();
        int expected = 6;
        assertEquals(expected, service.findMaxSalesMonth(sales));
    }

    @Test
    public void testFindMinSalesMonth() {
        StatsService service = new StatsService();
        int expected = 9;
        assertEquals(expected, service.findMinSalesMonth(sales));
    }

    @Test
    public void testCountMonthsBelowAverage() {
        StatsService service = new StatsService();
        int expected = 5;
        assertEquals(expected, service.countMonthsBelowAverage(sales));
    }

    @Test
    public void testCountMonthsAboveAverage() {
        StatsService service = new StatsService();
        int expected = 5;
        assertEquals(expected, service.countMonthsAboveAverage(sales));
    }

    // Дополнительный тестовый случай для пустого массива продаж
    @Test
    public void testEmptyArray() {
        long[] emptySales = {};
        StatsService service = new StatsService();

        assertEquals(0, service.calculateTotalSales(emptySales));
        assertEquals(0, service.calculateAverageMonthlySales(emptySales), 0.01);
        assertEquals(-1, service.findMaxSalesMonth(emptySales));
        assertEquals(-1, service.findMinSalesMonth(emptySales));
        assertEquals(0, service.countMonthsBelowAverage(emptySales));
        assertEquals(0, service.countMonthsAboveAverage(emptySales));
    }

    // Тестовый случай для массива с одинаковыми значениями
    @Test
    public void testAllEqualValues() {
        long[] equalSales = {10L, 10L, 10L, 10L, 10L, 10L, 10L, 10L, 10L, 10L, 10L, 10L};
        StatsService service = new StatsService();

        assertEquals(120, service.calculateTotalSales(equalSales));
        assertEquals(10, service.calculateAverageMonthlySales(equalSales), 0.01);
        assertEquals(1, service.findMaxSalesMonth(equalSales));
        assertEquals(1, service.findMinSalesMonth(equalSales));
        assertEquals(0, service.countMonthsBelowAverage(equalSales));
        assertEquals(0, service.countMonthsAboveAverage(equalSales));
    }

    // Тестовый случай для массива с одним элементом
    @Test
    public void testSingleElement() {
        long[] singleSale = {100L};
        StatsService service = new StatsService();

        assertEquals(100, service.calculateTotalSales(singleSale));
        assertEquals(100, service.calculateAverageMonthlySales(singleSale), 0.01);
        assertEquals(1, service.findMaxSalesMonth(singleSale));
        assertEquals(1, service.findMinSalesMonth(singleSale));
        assertEquals(0, service.countMonthsBelowAverage(singleSale));
        assertEquals(0, service.countMonthsAboveAverage(singleSale));
    }
    @Test
    public void testNegativeValues() {
        long[] negativeSales = {-8L, -15L, -13L, -15L, -17L, -20L, -19L, -20L, -7L, -14L, -14L, -18L};
        StatsService service = new StatsService();

        assertEquals(-150, service.calculateTotalSales(negativeSales));
        assertEquals(-12.5, service.calculateAverageMonthlySales(negativeSales), 0.01);
        assertEquals(11, service.findMaxSalesMonth(negativeSales));
        assertEquals(6, service.findMinSalesMonth(negativeSales));
        assertEquals(5, service.countMonthsBelowAverage(negativeSales));
        assertEquals(5, service.countMonthsAboveAverage(negativeSales));
    }
}


