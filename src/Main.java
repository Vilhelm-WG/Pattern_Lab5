import decorator.NoteDecorators;
import decorator.Playable;
import executearound.StudioMicrophone;
import factorymethod.BasicAir;
import factorymethod.BasicPro;
import factorymethod.MacBookStore;
import strategy.Musician;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== 1. FP СТРАТЕГІЯ ===");
        Musician musician = new Musician();

        // Передаємо лямбда-вирази замість цілих класів стратегій
        musician.setStrategy((n1, n2) -> System.out.println("Legato FP: " + n1 + " " + n2));
        musician.performNote("До", "Ре");

        musician.setStrategy((n1, n2) -> System.out.println("Staccato FP: " + n1 + " " + n2));
        musician.performNote("Мі", "Фа");


        System.out.println("\n=== 2. FP ФАБРИЧНИЙ МЕТОД ===");
        MacBookStore store = new MacBookStore();

        // Передаємо посилання на конструктор (Supplier)
        store.deliverToStore(BasicAir::new);
        store.deliverToStore(BasicPro::new);


        System.out.println("\n=== 3. FP ДЕКОРАТОР ===");
        // Базова нота
        Playable simpleNote = () -> System.out.println("Грає нота: До (C)");

        // Загортаємо ноту в декоратори як матрьошку
        Playable decoratedNote = NoteDecorators.sharp(NoteDecorators.flat(simpleNote));
        decoratedNote.play();


        System.out.println("\n=== 4. FP НАВКОЛИШНЄ ВИКОНАННЯ (Execute Around) ===");
        // Ми не турбуємося про включення/виключення мікрофона,
        // ми передаємо лише те, ЩО треба записати.
        StudioMicrophone.executeAround(mic -> {
            mic.recordVoice("Ah-ah-ah!");
            mic.recordVoice("Test, one, two.");
            // Навіть якщо тут станеться помилка (Exception), мікрофон безпечно вимкнеться завдяки finally.
        });
    }
}