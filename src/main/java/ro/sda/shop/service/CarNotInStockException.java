package ro.sda.shop.service;

public class CarNotInStockException extends RuntimeException{
    public CarNotInStockException() {
    }

    public CarNotInStockException(String message) {
        super(message);
    }

    public CarNotInStockException(Throwable cause) {
        super(cause);
    }
}
