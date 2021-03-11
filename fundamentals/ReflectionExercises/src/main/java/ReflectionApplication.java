import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ReflectionApplication {

    public static void main(String [] args) throws ClassNotFoundException {

        String personClassName = "com.davidjdickinson.reflection.model.Person";
        Class<?> personClass = Class.forName(personClassName);

        System.out.println("Person class = " + personClass);

        Field[] fields = personClass.getFields();
        System.out.println("Fields:");
        System.out.println(Arrays.toString(fields));

        Field[] declaredFields = personClass.getDeclaredFields();
        System.out.println("Declared Fields:");
        System.out.println(Arrays.toString(declaredFields));

        Method[] methods = personClass.getMethods();
        System.out.println("Methods:");
        for (Method m : methods) {
            System.out.println(m);
        }

        Method[] declaredMethods = personClass.getDeclaredMethods();
        System.out.println("Declared Methods:");
        for (Method dm : declaredMethods) {
            System.out.println(dm);
        }

        System.out.println("Static Declared Methods:");
        Arrays.stream(declaredMethods)
                .filter(m -> Modifier.isStatic(m.getModifiers()))
                .forEach(System.out::println);
    }
}
