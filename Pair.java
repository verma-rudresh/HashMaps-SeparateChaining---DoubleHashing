class Pair implements Comparable {
    String fname;
    String lname;
    Pair(String fname, String lname){
        this.fname = fname;
        this.lname = lname;
    }
    String firstName(){
        return fname;
    }
    String lastName(){
        return lname;
    }

    public String toString() {
        return fname + " " + lname;
    }

    public int compareTo(Object obj) {
        String s1 = fname+ " " + lname;
        Student stu = (Student) obj;
        String s2 = stu.fname + " " + stu.lname;
        if(s1.equals(s2))
            return 0;
        else if(s1.compareTo(s2)>0)
            return 1;
        else return -1;
    }


}
