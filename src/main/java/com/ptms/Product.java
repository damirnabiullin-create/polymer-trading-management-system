package com.ptms;

public class Product implements Comparable<Product> {
    private final String name;
    private double price;

    public Product(String name, double price) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя не должно быть пустым.");
        }
        this.name = name;
        setPrice(price);
    }

    @Override
    public int compareTo(Product other) {
        return this.name.compareTo(other.getName());
    }

    @Override
    public boolean equals(Object o) {
        return o == this || (o instanceof Product && ((Product) o).getName().equals(this.name));
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double newPrice) {
        if (newPrice > 0) {
            this.price = newPrice;
        } else {
            throw new IllegalArgumentException("Цена должна быть больше 0");
        }
    }

    public static Product applyDiscount(Product product, double percent) {
        if (product == null) {
            throw new IllegalArgumentException("Не получен товар для применения скидки");
        }
        if (percent >= 0 && percent < 100) {
            return new Product(product.getName(),
                    (product.getPrice() - product.getPrice() * percent / 100));
        }
        throw new IllegalArgumentException("Скидка должна быть больше или равна 0% и меньше 100%");
    }

    public static double calculateTotal(int quantity, double price) {
        return quantity * price;
    }

    public static double calculateTotal(int quantity, double price, double discount) {
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Скидка должна быть в пределах от 0% до 100%");
        }
        return calculateTotal(quantity, price) * (1 - discount / 100);
    }

    public void printInfo() {
        System.out.println("Товар: " + name + ", цена: " + price + " тг/кг");
    }
}
