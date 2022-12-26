Fpackage Codes;/*public class Vector<E>
        extends AbstractList<E>
        implements List<E>, RandomAccess, Cloneable, Serializable

The Vector class implements a growable array of objects. Like an array, it contains components that can be accessed using an integer index. However, the size of a Vector can grow or shrink as needed to accommodate adding and removing items after the Vector has been created.
Each vector tries to optimize storage management by maintaining a capacity and a capacityIncrement. The capacity is always at least as large as the vector size; it is usually larger because as components are added to the vector, the vector's storage increases in chunks the size of capacityIncrement. An application can increase the capacity of a vector before inserting a large number of components; this reduces the amount of incremental reallocation.
The iterators returned by this class's iterator and listIterator methods are fail-fast: if the vector is structurally modified at any time after the iterator is created, in any way except through the iterator's own remove or add methods, the iterator will throw a ConcurrentModificationException. Thus, in the face of concurrent modification, the iterator fails quickly and cleanly, rather than risking arbitrary, non-deterministic behavior at an undetermined time in the future. The Enumerations returned by the elements method are not fail-fast.
Note that the fail-fast behavior of an iterator cannot be guaranteed as it is, generally speaking, impossible to make any hard guarantees in the presence of unsynchronized concurrent modification. Fail-fast iterators throw ConcurrentModificationException on a best-effort basis. Therefore, it would be wrong to write a program that depended on this exception for its correctness: the fail-fast behavior of iterators should be used only to detect bugs.
As of the Java 2 platform v1.2, this class was retrofitted to implement the List interface, making it a member of the Java Collections Framework. Unlike the new collection implementations, Vector is synchronized. If a thread-safe implementation is not needed, it is recommended to use ArrayList in place of Vector.

Since:
JDK1.0
Credits: Java Documentation + Intellij Documentation
*/
// Vector Vs ArrayList:
/* Vector is synchronized while ArrayList is not
Vector is slower while ArrayList is faster
Vector is present since Java 1.0 while ArrayList is there since Java 1.2
Can use enumeration and iterator uses only iterator

ArrayList vs LinkedList
ArrayList uses array as internal data structure LinkedList uses doubly LinkedList
ArrayList implements the List interface while LinkedList implements both List and dequeue interface
ArrayList is slower since after deletion bits have to be shifted LinkedList is faster as it uses LinkedList
ArrayList can't act as queue while LinkedList can act as queue(implements dequeue)

 */


import java.io.IOException;
import java.util.*;
class Employee implements Comparator<Employee>
{
    String EName;
    long EId;
    long salary;
    static Vector<Employee>vec = new Vector<>();
    Employee(){}
    Employee(String EName,long EId,long salary)
    {
        this.EName = EName;
        this.EId = EId;
        this.salary = salary;
    }
    static <K extends Employee> void create(K obj)// Do not panic this is just a stupid use of generics just write Codes.Employee obj :)
    {
        vec.add(obj);
        Employee.sort1();
    }

    static void sort1()// standard bubble sort with one small optimization such that if elements are already sorted then after any pass flag becomes 0 and we return out
    {
        int flag = 0;
        for (int i = 0; i < vec.size(); i++)
        {
            for (int j = 0; j < vec.size()-i-1; j++)
            {
                if(vec.get(j).salary>vec.get(j+1).salary)
                {
                    flag = 1;
                    Employee temp = vec.get(j);
                    vec.set(j,vec.get(j+1));
                    vec.set(j+1,temp);
                }
            }
            if(flag == 0) {
                return;
            }
        }
    }

    static void insert(Employee obj)
    {
        vec.add(obj);
        Employee.sort1();
    }

    static void delete(String Name)// Deletes multiple instances of an Codes.Employee object with same name but different salary
    {
        Vector<Employee> size = new Vector();
        for (Employee e : vec)
        {
            if(e.EName.equals(Name))// Did not delete element directly here as it will give concurrent modification error(fail-fast)
            {
                size.add(e);
            }
        }
        for (int i = 0; i < size.size(); i++)
        {
            vec.remove(size.elementAt(i));
        }
    }
    static void display()
    {
        for (Employee e :vec)
        {
            System.out.println("Name: "+e.EName+ " Salary: "+e.salary+" EID: "+e.EId);
        }
    }

    @Override
    public int compare(Employee o1, Employee o2)// Sort in descending order
    {
        if(o1.salary<o2.salary)
        {
            return 1;
        }
        if(o1.salary == o2.salary)
        {
            return 0;
        }
        return -1;
    }
}
public class CollectionsFramework
{


    public static void NOT_IN_SYLLABUS()
    {
        // Entry is an interface inside the Map interface. entryset method returns set of Entry<>
        //When use LinkedHashSet? When you want the insertion order of the map to remain same

        //When use TeeMap? When you want the keys to be in sorted order. Like Numbers will be arranged in ascending order and strings in lexicographical order
        // Internally a TReeMap is the implementation of the red black tree and all the insertion and deletions are performed in log(n) time. We can specify our own sorting logic using the comparator
        //NULL is allowed only once and duplicates are not allowed since its is a subclass of set
        // pollFirst and pollLast are used to pick up the first and last element

        // TreeSet is similar to TreeMap only for the difference that TreeSet is the implementation of Set using Trees

        //Remember Hashmap doesn't guarantee that the elements will be present in sorted oder since it uses a hash function
        //NULL values are not allowed in TreeMap and TreeSet
        /*
        HashMap offers O(1) insertion and deletion and uses array of linked list and permits null values and keys
        LinkedHashmap offers O(1) insertion and deletion and uses buckets of doubly linked list. Permits only one Null key
        TreeMaps offer O(log(n)) insertion deletion and lookup time and uses red black trees. Doesn't permit null keys unless null is handled by the comparator
        LinkedHashmap can be made to operate like LRU Cache by using removeEldest method to impose a restriction on removal and insertion
         */
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i <10 ; i++)
        {
            hashMap.put(i,i+1);
        }
        Set<Map.Entry<Integer,Integer>> val = hashMap.entrySet();

        for (Map.Entry<Integer,Integer>e:val)
        {
            System.out.println(e.getKey()+" "+ e.getValue());
        }
        System.out.println();

        for (Integer e: hashMap.keySet())// Key set returns a set of keys
        {
            System.out.println(e+" "+hashMap.get(e));
        }
        System.out.println("Using TreeMap: ");
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1<o2) {
                    return 1;
                }
                if(o1.equals(o2))
                {
                    return 0;
                }
                else
                return -1;
            }

        };
        TreeMap<Integer,Integer> map1 = new TreeMap<>(com);// Sort in descending order due to comparator
        map1.put(1,3);
        map1.put(3,4);
        map1.put(2,5);

        for (Integer e: map1.keySet())
        {
            System.out.println(e+" "+map1.get(e));
        }
        System.out.println("Using TreeSet");
        TreeSet<Integer>set = new TreeSet<>(map1.keySet());
        for (Integer e : set)
        {
            System.out.println(e);
        }




    }
    static void vector_Methods()
    {
        Vector<Integer> vec = new Vector<>();

        System.out.println("The capacity of vector is: "+vec.capacity());
        for (int i = 0; i < 10; i++)
        {
            vec.add(i);
        }
        Enumeration e = vec.elements();
        Iterator i = vec.iterator();
        while (e.hasMoreElements())// Through Enumeration. Enumeration can iterate through only legacy classes while iterator can iterate through any classes
        {
            System.out.println(e.nextElement());
        }
        //Through Iterator
        System.out.println();
        while(i.hasNext())
        {
            System.out.println(i.next());
        }
        System.out.println("Size of vector is: "+vec.size());
        // Some Vector methods:

        //a) Vector.addAll adds all elements from one collection to the vector at a specified location don't use index parameter on empty vector
        Vector<Integer> vec1 = new Vector<>();
        vec1.add(1);
        vec1.addAll(1,vec);
        System.out.println(vec1);

        //b) Vector.add adds one new element to the vector either at end or at specified position
        vec1.add(2,3);
        System.out.println(vec1);

        //c) Vector.set sets the value at a particular index to the given value
        vec1.set(0,-1);
        System.out.println(vec1);

        //d) Vector.contains checks whether any particular element is present or not
        System.out.println(vec1.contains(0));

        //e) Vector.remove and Vector.removeElementAt. Removes element either at any specified index or removes first occurrence of any element
        vec1.remove(1);
        vec1.removeElementAt(2);
        vec1.add(3);
        vec1.removeElementAt(2);
        vec1.removeElement(3);
        System.out.println(vec1);
       /* for (Integer i: vec) This is known as fail fast as we ae concurrently trying to modify vector while parsing over it
        {
            vec.removeElement(i);

        }
      */

        //f) Vector.copyInto copies contents of Vector into the specified array
        Integer arr[] = new Integer[vec1.size()];
        vec1.copyInto(arr);
        System.out.println(Arrays.toString(arr));

        //g) Vector.setSize sets the size of the vector to the given size. If size>current size NULL objects are inserted and if it is less in size objects are removed

        //h) Arrays.deepEquals tells whether two arrays are equal or not. In case objects like Strings are stored normal comparison gives false even for Equal arrays since object references are compared not value
        // deepEquals compares values not references
        Integer arr1[] = new Integer[arr.length];
        arr1=Arrays.copyOf(arr,arr.length);// Fills array with given value
        System.out.println(arr1.equals(arr));//Gives false as objects are compared on references not values
        System.out.println(Arrays.deepEquals(arr1,arr));

        //i) Sorting a vector we can use two methods called comparable and comparator. Comparator  allows us to define our own sorting logic. For second method your class should implement the comparable interface
        Comparator<Integer> com = new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2) { // Anonymous class. If we return -ve value means we want to sort in descending order
                if(o1-o2>0)
                    return 1;
                else
                {
                    return -1;
                }
            }
        };
        vec1.sort(com);
        System.out.println(vec1);
    }
    public static void main(String[] args) throws IOException {
        //vector_Methods();
        //NOT_IN_SYLLABUS();
        System.out.println("Enter number of employees:");
        Scanner bufferedReader = new Scanner(System.in);
        int size = bufferedReader.nextInt();
        for (int i = 0; i < size; i++)
        {
            System.out.println("Enter Name");
            String name = bufferedReader.next();
            System.out.println("Enter ID");
            long ID = bufferedReader.nextInt();
            System.out.println("Enter salary");
            long salary = bufferedReader.nextInt();
            Employee.create(new Employee(name,ID,salary));
        }
        Employee.display();
        System.out.println("Enter name to be deleted");
        String Name = bufferedReader.next();
        Employee.delete(Name);
        Employee.display();
        Employee.vec.sort(new Employee());
        Employee.display();



    }
}
