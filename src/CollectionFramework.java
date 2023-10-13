import java.util.*;

/**
 * There are two fundamental interfaces for collections: Collection and Map
 * Dictionary is an abstract class whereas Map is an interface, hence it is more Java-idiomatic.
 *
 * The List interface defines several methods for random access:
 * void add(int index, E element)
 * void remove(int index)
 * E get(int index)
 * E set(int index, E element)
 *
 *
 * The Set interface is identical to the Collection interface, but the behavior of the
 * methods is more tightly defined. The add method of a set should reject duplicates.
 * The equals method of a set should be defined so that two sets are identical if they
 * have the same elements, but not necessarily in the same order. The hashCode method
 * should be defined so that two sets with the same elements yield the same
 * hash code.
 *
 * The only reason to use a linked list is to minimize
 * the cost of insertion and removal in the middle of the list.
 *
 * If you look back at Table 9.3, you may well wonder if you should always use a
 * tree set instead of a hash set. After all, adding elements does not seem to take
 * much longer, and the elements are automatically sorted. The answer depends on
 * the data that you are collecting. If you don’t need the data sorted, there is no
 * reason to pay for the sorting overhead
 *
 * A double-ended queue, or deque, lets you efficiently add or remove elements at the head and tail. Adding elements in the
 * middle is not supported
 *
 * Should you choose a hash map or a tree map? As with sets, hashing is usually a
 * bit faster, and it is the preferred choice if you don’t need to visit the keys in sorted
 * order.
 *
 * Another approach is to first call the putIfAbsent method. It only puts a value if the
 * key was previously absent (or mapped to null).
 * counts.putIfAbsent(word, 0);
 * counts.put(word, counts.get(word) + 1); // Now we know that get will succeed
 * But you can do better than that. The merge method simplifies this common
 * operation. The call
 * counts.merge(word, 1, Integer::sum);
 * associates word with 1 if the key wasn’t previously present, and otherwise combines
 * the previous value and 1, using the Integer::sum function.
 *
 * . Instead, the keySet method returns an object of a
 * class that implements the Set interface and whose methods manipulate the original
 * map. Such a collection is called a view.
 *
 * You can form subrange views for a number of collections. For example,
 * suppose you have a list staff and want to extract elements 10 to 19. Use the subList
 * method to obtain a view into the subrange of the list:
 * List<Employee> group2 = staff.subList(10, 20);
 *
 * 9.4.3 Unmodifiable Views
 * The Collections class has methods that produce unmodifiable views of collections.
 * These views add a runtime check to an existing collection. If an attempt to modify
 * the collection is detected, an exception is thrown and the collection remains
 * untouched.
 *
 * f you access a collection from multiple threads, you need to ensure that the collection is not accidentally damaged. For example, it would be disastrous if one
 * 512 Chapter 9 Collections
 * From the Library of Hristo Dimov Hristov
 * ptg18360597
 * thread tried to add to a hash table while another thread was rehashing the
 * elements.
 *
 * Collections has pre-implemented  methods for some algorithms like: sort, binary search, shuffle and...
 *
 * */
public class CollectionFramework {
    public static void main(){

        Map<Integer, String> dict = new HashMap<>();
        dict.put(1,"Amy");
        dict.put(2, "Kevin");
        dict.put(3, "Petter");
        dict.put(4, "David");
        dict.put(5, "Alice");
        dict.forEach((k,v)-> System.out.println("Key: "+k+", value: "+v));

        Map<Integer, String> linkedDict = new LinkedHashMap<>();



        ArrayList<Integer> ilist = new ArrayList<>();
        ilist.add(1);
        ilist.add(10);
        ilist.add(111);
        ilist.add(123);

        ilist.removeIf(item -> item.toString().length() < 2);
        ilist.iterator().forEachRemaining(System.out::println);


    }
}
