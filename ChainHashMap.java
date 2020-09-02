import java.lang.Math;
public class ChainHashMap<K ,T > implements MyHashTable_<K,T> {
    private BinarySearchTree<K,T> [] table ;
    private int capacity;
     ChainHashMap(BinarySearchTree<K,T>[] table, int capacity){
        this.table = table;
        this.capacity = capacity;
    }

    public int insert(K key, T obj) {
        Pair pair = (Pair) key;
        long index = djb2(pair.fname+pair.lname,capacity);
        //index = index%capacity;
        BinarySearchTree<K,T> bst = table[(int) index];
        return bst.insert(key , obj);
    }


    public int update(K key, T obj) {
        Pair pair = (Pair) key;
        long index = djb2(pair.fname+pair.lname,capacity);
        return table[(int) index].update(key , obj);
    }


    public int delete(K key) {
        Pair pair = (Pair) key;
        long index = djb2(pair.fname+pair.lname,capacity);
        return table[(int) index].delete(key);
    }


    public boolean contains(K key) {
        Pair pair = (Pair) key;
        long index = djb2(pair.fname+pair.lname,capacity);
        Node<T> req_node = table[(int) index].find(key);
        return req_node != null;
    }


    public T get(K key) throws NotFoundException {
        Pair pair = (Pair) key;
        long index = djb2(pair.fname+pair.lname,capacity);
        Node<T> req_node = table[(int) index].find(key);
        if(req_node != null){
            return req_node.data;
        }
        else return null;
    }


    public String address(K key) throws NotFoundException {
        Pair pair = (Pair) key;
        long index = djb2(pair.fname+pair.lname,capacity);
        String add= "";
        add=add+Long.toString(index)+"-";
        String outcome =table[(int) index].address(key);
        if(outcome==null)
            return null;
        add=add+outcome;
        return add;
    }

    public static long djb2(String str, int hashtableSize) {
        long hash = 5381;
        for (int i = 0; i < str.length(); i++) {
            hash = ((hash << 5) + hash) + str.charAt(i);
        }
        return Math.abs(hash) % hashtableSize;
    }
}
