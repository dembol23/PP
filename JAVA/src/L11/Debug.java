package L11;

import java.lang.reflect.Field;
import java.lang.reflect.InaccessibleObjectException;

public class Debug {
    public Debug(){}

    void fields(Object objectGiven) {
        Class<?> objectClass = objectGiven.getClass();
        System.out.println("Klasa: " + objectClass.getSimpleName());
        for (Field i: objectClass.getDeclaredFields()) {
            try {
                i.setAccessible(true);
                System.out.println(i.getName() + ": " + i.getType() + " = " + i.get(objectGiven));
            } catch (InaccessibleObjectException e) {
                System.out.println(i.getName() + ": [BRAK DOSTĘPU - CHRONIONE PRZEZ JVM]");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
