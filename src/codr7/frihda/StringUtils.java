package codr7.frihda;

public final class StringUtils {
    public static String toNameCase(final String in) {
        return in.substring(0, 1).toUpperCase() + in.substring(1);
    }
}
