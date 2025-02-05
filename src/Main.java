import codr7.tyred.*;
import codr7.tyred.columns.StringColumn;

public class Main {
    static class DB extends Schema {
        final Table users = add(new Table("users"));
        final StringColumn userName = new StringColumn(users, "name", 100, Option.PrimaryKey);

        final Table admins = add(new Table("admins"));
        final ForeignKey adminUserKey = new ForeignKey(admins, "user", users, Option.PrimaryKey);
    }

    public static void main(final String[] args) {
        try {
            Class.forName("org.h2.Driver");
        } catch (final ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        final var cx = new Context("frihda", "frihda", "frihda");
        final var db = new DB();
        db.migrate(cx);
    }
}