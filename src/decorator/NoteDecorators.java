package decorator;

public class NoteDecorators {

    // Декоратор Бемоль: приймає базову ноту і повертає нову
    public static Playable flat(Playable note) {
        return () -> {
            System.out.print("[Бемоль ♭] Знижено -> ");
            note.play();
        };
    }
    public static Playable sharp(Playable note) {
        return () -> {
            System.out.print("[Дієз ♯] Підвищено -> ");
            note.play();
        };
    }
}
