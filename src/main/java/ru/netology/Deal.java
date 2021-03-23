package ru.netology;

public class Deal {
    private final int price;
    private final int length;
    private final int width;

    public Deal(int price, int length, int width) {
        this.price = price;
        this.length = length;
        this.width = width;
    }

    public int getPricePerSqMetre() {
        return price / (length * width);
    }

    @Override
    public String toString() {
        return "Deal{" +
                "Total price=" + price +
                ", length=" + length +
                ", width=" + width +
                ", price per square metre=" + getPricePerSqMetre() +
                '}';
    }
}
