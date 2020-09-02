import java.io.*;
import java.lang.Math;
public class Assignment3
{
    public  static long h1(String str, int hashtableSize) {
        long hash = 5381;
        for (int i = 0; i < str.length(); i++) {
            hash = ((hash << 5) + hash) + str.charAt(i);
        }
        return Math.abs(hash) % hashtableSize;
    }
    public static long h2(String str, int hashtableSize) {
        long hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash = str.charAt(i) + (hash << 6) + (hash << 16) - hash;
        }
        return Math.abs(hash) % (hashtableSize - 1) + 1;
    }
    public static void main(String [] args) throws IOException, NotFoundException {
//        int tableSize = Integer.parseInt(args[0]);
        int tableSize = Integer.parseInt("5");
//        String mode = args[1];
        //String mode = args[1];
        String mode = "SCBST";
//        String filename = args[2];
        String filename ="C:\\Users\\DELL\\IdeaProjects\\Assignment_3\\src\\input.txt";
        /*
        int in1= (int) h1("KapilSingh",5);
        int in2= (int) h1("ChunkySingh",5);
        int in3= (int) h1("ShyamSingh",5);
        int in4= (int) h2("ShyamSingh",5);
        int in5 = (in3+in4)%5;
        int in6 = (in3 + 2*in4)%5;
        int in7 = (in3 + 3*in4)%5;;
        System.out.println(in1 + " " + in2 + " " + in3 + " " + in4+ " " + in5 + " "+ in6+ " "+ in7);
        */
        if(mode.equals("DH")){
            Student [] table = new Student[tableSize];
            DoubleHashMap<Pair,Student> map = new DoubleHashMap<>(table,tableSize);
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null){
                String [] arr = line.split(" ");
                switch (arr[0]) {
                    case "insert": {
                        Pair key = new Pair(arr[1], arr[2]);
                        Student value = new Student(arr[1], arr[2], arr[3], arr[4], arr[5]);
                        int i = map.insert(key, value);
                        if(i==-1)
                            System.out.println("E");
                        else System.out.println(i);
                        break;
                    }
                    case "update": {
                        Pair key = new Pair(arr[1], arr[2]);
                        Student value = new Student(arr[1], arr[2], arr[3], arr[4], arr[5]);
                        int i = map.update(key, value);
                        if (i == -1)
                            System.out.println("E");
                        else System.out.println(i);
                        break;
                    }
                    case "delete": {
                        Pair key = new Pair(arr[1], arr[2]);
                        int i = map.delete(key);
                        if (i == -1)
                            System.out.println("E");
                        else System.out.println(i);
                        break;
                    }
                    case "contains": {
                        Pair key = new Pair(arr[1], arr[2]);
                        boolean state = map.contains(key);
                        if (state)
                            System.out.println("T");
                        else System.out.println("F");
                        break;
                    }
                    case "get": {
                        Pair key = new Pair(arr[1], arr[2]);
                        Student stu = map.get(key);
                        if (stu != null) {
                            String s = "" + stu.fname + " " + stu.lname + " " + stu.hostel + " "  + stu.department + " " + stu.cgpa;
                            System.out.println(s);
                        } else System.out.println("E");
                        break;
                    }
                    case "address":  {
                        Pair key = new Pair(arr[1], arr[2]);
                        String s = map.address(key);
                        if(s!=null)
                        System.out.println(s);
                        else System.out.println("E");
                        break;
                    }

                }
            }
        }
        else if(mode.equals("SCBST")){
            BinarySearchTree<Pair,Student> [] table = new BinarySearchTree[tableSize];
            for(int i=0;i<tableSize ; i++){
                    table[i] = new BinarySearchTree<>();
            }
            ChainHashMap<Pair,Student> map = new ChainHashMap<>(table,tableSize);
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null){
                String [] arr = line.split(" ");
                switch (arr[0]){
                    case "insert": {
                        Pair key = new Pair(arr[1], arr[2]);
                        Student value = new Student(arr[1], arr[2], arr[3], arr[4], arr[5]);
                        int i = map.insert(key, value);
                        System.out.println(i);
                        break;
                    }
                    case "contains": {
                        Pair key = new Pair(arr[1], arr[2]);
                        boolean state = map.contains(key);
                        if (state)
                            System.out.println("T");
                        else System.out.println("F");
                        break;
                    }
                    case "update": {
                        Pair key = new Pair(arr[1], arr[2]);
                        Student value = new Student(arr[1], arr[2], arr[3], arr[4], arr[5]);
                        int i = map.update(key, value);
                        if (i == -1)
                            System.out.println("E");
                        else System.out.println(i);
                        break;
                    }
                    case "delete": {
                        Pair key = new Pair(arr[1], arr[2]);
                        int i = map.delete(key);
                        if (i == -1)
                            System.out.println("E");
                        else System.out.println(i);
                        break;
                    }
                    case "get": {
                        Pair key = new Pair(arr[1], arr[2]);
                        Student stu = map.get(key);
                        if (stu != null) {
                            String s = "" + stu.fname + " " + stu.lname + " " + stu.hostel + " "  + stu.department + " " + stu.cgpa;
                            System.out.println(s);
                        } else System.out.println("E");
                        break;
                    }
                    case "address":  {
                        Pair key = new Pair(arr[1], arr[2]);
                        String s = map.address(key);
                        if(s!=null)
                            System.out.println(s);
                        else System.out.println("E");
                        break;
                    }
                }
            }
        }
    }
}
