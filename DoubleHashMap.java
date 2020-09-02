import java.lang.Math;
public class DoubleHashMap<K,T> implements MyHashTable_<K,T> {


    public  long djb2(String str, int hashtableSize) {
        long hash = 5381;
        for (int i = 0; i < str.length(); i++) {
            hash = ((hash << 5) + hash) + str.charAt(i);
        }
        return Math.abs(hash) % hashtableSize;
    }

    public  long sdbm(String str, int hashtableSize) {
        long hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash = str.charAt(i) + (hash << 6) + (hash << 16) - hash;
        }
        return Math.abs(hash) % (hashtableSize - 1) + 1;
    }
    private int capacity;
    private T [] table ;
    //constructor
    DoubleHashMap(T[] table, int capacity){
        this.table = table;
        this.capacity = capacity;

    }

    public int insert(K key, T obj) {
        Pair pair = (Pair) key;
        long index = djb2(pair.fname+pair.lname,capacity);
        int i=1;
        while(table[(int) index]!=null ) {
            Student stu = (Student) table[(int) index];
             if(stu.fname.equals(pair.fname) && stu.lname.equals(pair.lname)){
                 return -1;
             }
             if(i==capacity)
                 return -1;
            index = (djb2(pair.fname+pair.lname, capacity) + i * sdbm(pair.fname+pair.lname, capacity))%capacity;
            i++;
        }
        table[(int) index]= obj;
        return i;
    }


    public int update(K key, T obj) {
        Pair pair = (Pair) key;
        long index = djb2(pair.fname+pair.lname,capacity);
        int i=0;
        T obj1 = table[(int) index];
        while(table[(int) index]==null  || !(obj1.toString().equals(key.toString()))) {
            i++;
            if (i == capacity) {
                return -1;
            }
            index = (djb2(pair.fname + pair.lname, capacity) + i * sdbm(pair.fname + pair.lname, capacity)) % capacity;
            obj1 = table[(int) index];
        }
        table[(int) index]=obj;
        return i+1;
    }


    public int delete(K key) {
        Pair pair = (Pair) key;
        long index = djb2(pair.fname+pair.lname,capacity);
        int i=0;
        T obj1 = table[(int) index];
        while(table[(int) index]==null || !(obj1.toString().equals(key.toString())) ){
            i++;
            if(i==capacity){
                return -1;
            }
            index = (djb2(pair.fname+pair.lname,capacity) + i * sdbm(pair.fname+pair.lname,capacity))%capacity;
            obj1 = table[(int) index];
        }
        table[(int) index] = null;
        return i+1;
    }


    public boolean contains(K key) {
        //for the index calculation,
        //we have to type cast the K key into Pair key.
        Pair pair = (Pair) key;
        long index = djb2(pair.fname+pair.lname,capacity);
        int i=0;
        T obj1 = table[(int) index];
        while(table[(int) index]==null || !(obj1.toString().equals(key.toString())) ){
            i++;
            if(i==capacity){
                return false;
            }
            index = (djb2(pair.fname+pair.lname,capacity) + i * sdbm(pair.fname+pair.lname,capacity))%capacity;
            obj1 = table[(int) index];
        }
        return true;
    }


    public T get(K key) throws NotFoundException {
        Pair pair = (Pair) key;
        long index = djb2(pair.fname+pair.lname,capacity);
        int i=0;
        T obj1 = table[(int) index];
        while(table[(int) index]==null || !(obj1.toString().equals(key.toString())) ){
            i++;
            if(i==capacity){
                return null;
            }
            index = (djb2(pair.fname+pair.lname,capacity) + i * sdbm(pair.fname+pair.lname,capacity))%capacity;
            obj1 = table[(int) index];
        }
        return table[(int) index];
    }


    public String address(K key) throws NotFoundException {
        Pair pair = (Pair) key;
        long index = djb2(pair.fname+pair.lname,capacity);
        int i=0;
        T obj1 = table[(int) index];
        while(table[(int) index]==null || !(obj1.toString().equals(key.toString())) ){
            i++;
            if(i==capacity){
                return null;
            }
            index = (djb2(pair.fname+pair.lname,capacity) + i * sdbm(pair.fname+pair.lname,capacity))%capacity;
            obj1 = table[(int) index];
        }
        return Long.toString(index);
    }
}
