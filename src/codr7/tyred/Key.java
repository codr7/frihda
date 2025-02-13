package codr7.tyred;

import java.util.stream.Stream;

public class Key extends BaseConstraint implements Constraint {
    public Key(final Table table, final String name, final Stream<TableColumn> columns, final Option...options) {
        super(table, name, columns, options);
    }

    @Override
    public String constraintType() {
        return (this == table().primaryKey()) ? "PRIMARY KEY" : "UNIQUE";
    }
}
