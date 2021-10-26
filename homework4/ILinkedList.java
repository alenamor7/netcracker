package homework4;
import java.util.*;

public interface ILinkedList<E> extends Iterable{

    int size();

    void add(E element);

    void add(int index, E element);

    void clear();

    E get(int index);

    int indexOf(E element);

    E remove(int index);

    E set(int index, E element);

    E[] toArray();

    String toString();

}
