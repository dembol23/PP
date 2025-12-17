package L10.Decoration;

enum DecorationType {
    BUBBLES,
    LIGHTS,
    ANGEL,
    CHAIN
}

public class DecorationFactory {
    public static Decoration getDecoration(String name) {
        DecorationType type;
        try {
            type = DecorationType.valueOf(name.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new UnknownDecorationException("Nieznana dekoracja: " + name);
        }
        return switch (type) {
            case BUBBLES -> new Bubbles();
            case LIGHTS -> new Lights();
            case ANGEL -> new Angel();
            case CHAIN -> new Chain();
        };
    }
}