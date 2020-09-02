import java.io.*;
public class compare {
    public static void main(String [] args) throws IOException, NotFoundException{
        String filename1 ="C:\\Users\\DELL\\IdeaProjects\\Assignment_3\\src\\outputMega.txt";
        String filename2 ="C:\\Users\\DELL\\IdeaProjects\\Assignment_3\\src\\GivenOutputMega.txt";
        FileReader fr1 = new FileReader(filename1);
        FileReader fr2 = new FileReader(filename2);
        BufferedReader br1 = new BufferedReader(fr1);
        BufferedReader br2 = new BufferedReader(fr2);
        String line1,line2;
        boolean result = true;
        while ((line1 = br1.readLine()) != null){
            line2=br2.readLine();
            if(!line1.equals(line2))
                result =false;
        }
        if(result)
            System.out.println("equals");
        else System.out.println("unequals");
    }
}
