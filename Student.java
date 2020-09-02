public class Student  {
    String fname;
    String lname;
    String hostel;
    String department;
    String cgpa;
    Student(String fname, String lname, String hostel, String department, String cgpa)
    {
        this.fname = fname;
        this.lname = lname;
        this.cgpa = cgpa;
        this.department = department;
        this.hostel = hostel;
    }
    public String fname()
    {
        return fname;
    }
    public String lname()
    {
        return lname;
    }
    public String hostel()
    {
        return hostel;
    }
    public String department()
    {
        return department;
    }
    public String cgpa()
    {
        return cgpa;
    }

    @Override
    public String toString() {
        return fname + " " + lname;
    }
}
