package executearound;

import java.util.function.Consumer;

public class StudioMicrophone {

    // Приватний конструктор, щоб ніхто не міг створити мікрофон без нашого патерну
    private StudioMicrophone() {
        System.out.println("[Setup] Увімкнення фантомного живлення. Мікрофон готовий.");
    }

    public void recordVoice(String lyrics) {
        System.out.println("🎙️ Запис вокалу: " + lyrics);
    }

    private void turnOff() {
        System.out.println("[Teardown] Збереження запису. Вимкнення мікрофона.");
    }

    // Той самий метод Execute Around
    public static void executeAround(Consumer<StudioMicrophone> action) {
        StudioMicrophone mic = new StudioMicrophone(); // Дія ДО
        try {
            action.accept(mic); // Виконання переданої бізнес-логіки
        } finally {
            mic.turnOff(); // Дія ПІСЛЯ (гарантовано виконається)
        }
    }
}
