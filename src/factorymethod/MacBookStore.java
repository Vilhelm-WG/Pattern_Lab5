package factorymethod;

import java.util.function.Supplier;

public class MacBookStore {

    // Замість абстрактного класу і наслідування, ми просто передаємо "фабрику" як аргумент
    public void deliverToStore(Supplier<MacBook> macBookFactory) {
        MacBook mac = macBookFactory.get(); // Викликаємо фабричний метод
        mac.assemble();
        System.out.println("Ноутбук запаковано і відправлено з Apple Store!");
    }
}