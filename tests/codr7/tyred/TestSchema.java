package codr7.tyred;

import codr7.tyred.columns.LongColumn;
import codr7.tyred.columns.StringColumn;

import java.util.stream.Stream;

public class TestSchema extends Schema {
    public final Sequence userIds = add(new Sequence("UserIds", 1));

    public final Table users = add(new Table("TestUsers"));
    public final LongColumn userId = new LongColumn(users, "id", Option.PrimaryKey);
    public final StringColumn userName = new StringColumn(users, "Name", 100, Option.Nullable);
    public final Index userNameIndex = new Index(users, "UserName", true, Stream.of(userName));

    public final Table admins = add(new Table("TestAdmins"));
    public final ForeignKey adminUserKey = new ForeignKey(admins, "User", users, Option.PrimaryKey);
}
