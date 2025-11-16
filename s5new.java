import java.util.*;

class EnumerationIterator<T> implements Iterator<T> {
    private final Enumeration<T> enumeration;

    public EnumerationIterator(Enumeration<T> enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public T next() {
        return enumeration.nextElement();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}

public class Main {
    public static void main(String[] args) {

        Vector<String> v = new Vector<>(Arrays.asList(args));

        Iterator<String> iterator = new EnumerationIterator<>(v.elements());

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
