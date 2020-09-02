public class BinarySearchTree<K,T> {

        private Node<T> root;
        private int successor_count=0;
        BinarySearchTree(){
            this.root = null;
        }

        Node<T> find(K key)
        {
            Node<T> current = root;
            while(current!=null){
                 T obj1 =  current.data;
                 if(key.toString().equals(obj1.toString())){
                    return current;
                }else if(key.toString().compareTo(obj1.toString()) <0){
                    current = current.left;
                }else current = current.right;
            }
            return null;
        }
        String address(K key){
            StringBuilder add= new StringBuilder();
            Node<T> current = root;
            while(current!=null){
                T obj1 =  current.data;
                if(key.toString().equals(obj1.toString())){
                    return add.toString();
                }else if(key.toString().compareTo( obj1.toString()) <0){
                    current = current.left;
                    add.append("L");
                }else{
                    current = current.right;
                    add.append("R");
                }
            }
            return null;
        }

        int delete(K key){
            Node<T> parent = root;
            Node<T> current = root;
            if(root ==null)
                return -1;
            boolean isLeftChild = false;
            T obj1 =  current.data;
            int nodes_touched=1;
            while(!(key.toString().equals(obj1.toString()))){
                nodes_touched++;
                parent = current;
                if(key.toString().compareTo(obj1.toString()) <0){
                    isLeftChild = true;
                    current = current.left;
                    if(current == null){
                        return -1;
                    }
                    obj1 =  current.data;
                }else{
                    isLeftChild = false;
                    current = current.right;
                    if(current == null){
                        return -1;
                    }
                    obj1 = current.data;
                }


            }
            //if i am here that means we have found the node
            //Case 1: if node to be deleted has no children
            if(current.left==null && current.right==null){
                if(current==root){
                    root = null;
                }
                if(isLeftChild){
                    parent.left = null;
                }else{
                    parent.right = null;
                }
            }
            //Case 2 : if node to be deleted has only one child
            else if(current.right==null){
                if(current==root){
                    root = current.left;
                    nodes_touched++;
                }else if(isLeftChild){
                    parent.left = current.left;
                    nodes_touched++;
                }else{
                    parent.right = current.left;
                    nodes_touched++;
                }
            }
            else if(current.left==null){
                if(current==root){
                    root = current.right;
                    nodes_touched++;
                }else if(isLeftChild){
                    parent.left = current.right;
                    nodes_touched++;
                }else{
                    parent.right = current.right;
                    nodes_touched++;
                }
            }
            //case3: if node to be deleted has two children
            else {

                //now we have found the minimum element in the right sub tree
                Node<T> successor = getSuccessor(current);
                if(current==root){
                    root = successor;
                }else if(isLeftChild){
                    parent.left = successor;
                }else{
                    parent.right = successor;
                }
                successor.left = current.left;
                //I have doubt regarding this increment
                //nodes_touched++;
            }
            nodes_touched=nodes_touched+successor_count;
            successor_count=0;
            return nodes_touched;
        }

        private Node<T> getSuccessor(Node<T> deleteNode){
            Node<T> successsor =null;
            Node<T> successsorParent =null;
            Node<T> current =  deleteNode.right;

            while(current!=null){
                successor_count++;
                successsorParent = successsor; //shifting to the left by left and
                successsor = current;           //providing earlier value to the parent and the next left value to the successor
                current = current.left;         //the latest left value to the current node.

            }
            //check if successor has the right child, it cannot have left child for sure
            // if it does have the right child, add it to the left of successorParent.

           // successsorParent
            if(successsor!=deleteNode.right){
                successsorParent.left = successsor.right;
                if(successsor.right!=null)
                    successor_count++;
                successsor.right = deleteNode.right;
            }
            return successsor;
        }

        //insert function
         int insert(K key, T value){
            Node<T> newNode = new Node<>(value);
            int nodes_touched=0;
            if(root==null){
                root = newNode;
                nodes_touched++;
                return nodes_touched;
            }
            Node<T> current = root;
            T obj2 =  current.data;
            while(!(key.toString().equals(obj2.toString()))){
                nodes_touched++;
                Node<T> parent = current;

                 if(key.toString().compareTo(obj2.toString()) <0){
                    current = current.left;
                    if(current==null){
                        parent.left = newNode;
                        nodes_touched++;
                        return nodes_touched;
                    }
                    obj2 = current.data;

                }else{
                    current = current.right;
                    if(current==null){
                        parent.right = newNode;
                        nodes_touched++;
                        return nodes_touched;
                    }
                    obj2 =  current.data;

                }
            }
            return -1;
        }

        //update function
         int update(K key ,T value){
//            Node<T> newNode = new Node<>(value);
            int nodes_touched=0;
            if(root==null){
                return -1;
            }
            Node<T> current = root;
            T obj2 =  current.data;
            while(!(key.toString().equals(obj2.toString()))){
                nodes_touched++;
                if(obj2.toString().compareTo(key.toString()) >0){
                    current = current.left;
                    if(current ==null)
                        return -1;
                    obj2 =  current.data;

                }else{
                    current = current.right;
                    if(current ==null)
                        return -1;
                    obj2 =  current.data;
                }
            }
            current.data = value;
             nodes_touched++;
            return nodes_touched;

        }
        /* public void display(Node root) {
            if (root != null) {
                display(root.left);
                System.out.print(" " + root.data);
                display(root.right);
            }
        } */
}
