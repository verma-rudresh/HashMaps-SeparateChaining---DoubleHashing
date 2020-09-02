// Binary Search Tree ( Search and Insertion )

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
class Node_
{
    int data, pos;
    Node_ left, right;
    Node_(int key,int pos)
    {
        this.data = key;
        this.pos = pos;
    };
}

class Recursive_BST
{
    Node_ root;

    Node_ insert_recursive(Node_ obj, int key, int pos)
    {
        if(obj==null)
        {
            System.out.println(pos);
            return new Node_(key,pos);
        }
        if(key<obj.data)
            obj.left = insert_recursive(obj.left,key,2*pos);
        else if(key>obj.data)
            obj.right = insert_recursive(obj.right,key,2*pos+1);
        return obj;
    }

    Node_ delete_recursive(Node_ root, int key)
    {
        if (root == null)  return root;
        if (key < root.data)
            root.left = delete_recursive(root.left, key);
        else if (key > root.data)
            root.right = delete_recursive(root.right, key);
        else
        {
            System.out.println(root.pos);
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            else
            {
                root.data = minValue(root.right);
                root.right = delete_recursive(root.right, root.data);
            }
        }
        return root;
    }
    int minValue(Node_ root)
    {
        int minv = root.data;
        while (root.left != null)
        {
            minv = (int) root.left.data;
            root = root.left;
        }
        return minv; // inorder successor
    }
}


public class Main_Recursive_BST {
    public static void main(String args[]) throws IOException {
        Recursive_BST tree = new Recursive_BST();
        FileReader fr = new FileReader("C:\\Users\\DELL\\IdeaProjects\\Assignment_3\\src\\input.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
//        long q = in.nextLong();
        while((line=br.readLine())!=null)
        {
            String [] arr = line.split(" ");
//            System.out.println(arr[0]);
//            System.out.println(arr[1]);
            int key = Integer.parseInt(arr[1]);
            if(arr[0].equals("i"))
            {

                tree.root = tree.insert_recursive(tree.root,key,1);
//                System.out.println(r);
            }
            else
            {
                tree.root = tree.delete_recursive(tree.root,key);
//                System.out.println(del);
            }
        }
    }
}