/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
class Node1{
    Node1 left;
    Node1 right;
    int data;
    Node1(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
class BST {
    Node1 root;
    BST(){
        this.root = null;
    }
    int insert(int key){
        Node1 put_node = new Node1(key);
        if(root== null)
        {
            root= put_node;
            System.out.println(1);
//            System.out.println("the index of this inserted key is "+ 1 + " and it is the root");
            return 1;
        }
        else
        {
            int pos=1;
            Node1 parent= root;
            Node1 current = root;
            boolean isLeft=false;
            while(current!= null)
            {
                if(put_node.data> current.data)
                {
                    parent =current;
                    current = current.right;
                    pos=2*pos+1;
                    isLeft =false;
                }
                else {
                    parent =current;
                    current= current.left;
                    pos=2*pos;
                    isLeft = true;
                }
            }
            System.out.println(pos);
            if(isLeft){

                parent.left= put_node;
//               System.out.println("the index of this inserted key " + key + " is "+ pos+ " and it is inserted in the left node of the parent");
            }
            else {

                parent.right = put_node;
//                System.out.println("the index of this inserted key " + key + " is "+ pos+ " and it is iserted in the right node of the parent");
            }
            return pos;
        }
    }
    int delete(int key){
        Node1 current =root;
        Node1 parent =root;
        boolean isLeft =false;
        int pos=1;
        while(current!=null && current.data!=key){
            if(key > current.data){
                parent =current;
                current =current.right;
                isLeft=false;
                pos=pos*2+1;
            }
            else {
                parent =current;
                current=current.left;
                isLeft =true;
                pos=pos*2;
            }
        }
        if(current ==null){
            System.out.println(-1);
            return -1;
        }
        System.out.println(pos);
        if(current.left==null && current.right==null){
            if(isLeft){
               parent.left =null;
            }
            else parent.right =null;
//           System.out.println("the index of this deleted key " + key + " is "+ pos + " and its both child are null");
        }
        else if(current.right==null){
            if(isLeft){
                parent.left=current.left;
//                System.out.println("the index of this deleted key " + key + " is "+ pos+ " and only its right child is null");
            }
            else{
                parent.right=current.left;
//                System.out.println("the index of this deleted key " + key + " is "+ pos+ " and only its right child is null");
            }
        }
        else if(current.left ==null){
            if(isLeft){
                parent.left=current.right;
//                System.out.println("the index of this deleted key " + key + " is "+ pos+ " and only its left child is null");
            }
            else{
                parent.right=current.right;
//                System.out.println("the index of this deleted key " + key + " is "+ pos+ " and only its left child is null");
            }
        }
        else{
//            System.out.println("the index of this deleted key " + key + " is "+ pos+ " and its both children are not null");
            Node1 parentSuc= null;
            Node1 current1=current;
            current1=current1.right;
            Node1 Suc= current1;
            pos=pos*2+1;
            current1= current1.left;
            while(current1!=null){
                pos=pos*2;
                parentSuc = Suc;
                Suc=current1;
                current1= current1.left;
            }
            if(parentSuc!=null) {
                current.data = Suc.data;
                parentSuc.left = Suc.right;
//                System.out.println("the successor is in the left branch of the right child of deleted node");
            }
            else{
//                assert Suc != null;
                current.data=Suc.data;
                current.right =Suc.right;
//                System.out.println("the successor is the right child of the deleted node");
            }
            System.out.println(pos);
//            System.out.println("the index of the successor " + " is "+ pos+ " and its value is "+ Suc.data);
        }
        return pos;
    }
}
/* Name of the class has to be "Main" only if the class is public. */
class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        BST bst = new BST();
        FileReader fr = new FileReader("C:\\Users\\DELL\\IdeaProjects\\Assignment_3\\src\\input.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
//        long q = in.nextLong();
        while ((line = br.readLine()) != null) {
            String[] arr = line.split(" ");
//            System.out.println(arr[0]);
//            System.out.println(arr[1]);
            if (arr[0].equals("i")) {
                int key = Integer.parseInt(arr[1]);
                bst.insert(key);
            } else {
                int del = Integer.parseInt(arr[1]);
                bst.delete(del);
            }

        }
    }
}