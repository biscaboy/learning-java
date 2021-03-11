import com.davidjdickinson.reflection.model.Person;
import com.davidjdickinson.reflection.annotation.ColumnField;
import com.davidjdickinson.reflection.util.MetaModel;
import com.davidjdickinson.reflection.annotation.PrimaryKeyField;

import java.lang.reflect.Field;
import java.util.List;

public class PlayWithMetamodel {
    public static void main(String [] args) {
        MetaModel<Person> metaModel = MetaModel.of(Person.class);

        PrimaryKeyField primaryKeyField = metaModel.getPrimaryKey();
        List<ColumnField> columnFields = metaModel.getColumns();

        System.out.println("Primary key name = " + primaryKeyField.getName() +
                ", type = " + primaryKeyField.getType().getSimpleName());

        for (ColumnField columnField : columnFields) {
            System.out.println("Column name = " + columnField.getName() +
                    ", type = " + columnField.getType().getSimpleName());
        }

    }
}
