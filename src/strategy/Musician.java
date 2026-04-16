package strategy;

import java.util.function.BiConsumer;

public class Musician {
    // Стратегія тепер є просто функцією (BiConsumer)
    private BiConsumer<String, String> strategy;

    public void setStrategy(BiConsumer<String, String> strategy) {
        this.strategy = strategy;
    }

    public void performNote(String note, String note2) {
        if (strategy == null) {
            System.out.println("Музикант не знає, як грати!");
        } else {
            // Виклик функції
            strategy.accept(note, note2);
        }
    }
}