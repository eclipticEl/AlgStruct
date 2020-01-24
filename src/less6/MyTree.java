package less6;

public class MyTree{

    private Node root;

    public Node find(int key){
        Node current = root;
        if (current == null)
            return null;

        int cmp =  (key-current.key);
        while (cmp!=0){
            if (cmp<0){
                current = current.left;
            }
            else{
                current = current.right;
            }
            if (current == null){
                return null;
            }
            else{
                cmp =  (key-current.key);
            };
        }

        return  current;
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.size;
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }
    public void insert( int key, double value){
        Node newNode = new Node(key, value);

        if (root==null){
            root = newNode;
        }
        else{
            Node current = root;
            Node parent;

            while (true){
                current.size++ ;
                parent = current;
                if (key < current.key){
                    current = current.left;
                    if (current == null){
                        newNode.height = parent.height+1;
                        parent.left = newNode;
                        return;
                    }
                }
                else{
                    current = current.right;
                    if (current == null){
                        newNode.height = parent.height+1;
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    private Node getSuccessor(Node node){
        Node successorParent = node;
        Node successor = node;
        Node current = node.right;

        while (current != null){
            successorParent = successor;
            successor = current;
            current = current.left;
        }

        if (successor != node.right){
            successorParent.left = successor.right;
            successor.right = node.right;
        }

        return  successor;
    }

    public  boolean delete(int key){
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        while (current.key !=key){
            current.size-- ;
            parent = current;
            if (key < current.key){
                current = current.left;
                isLeftChild = true;
            }
            else{
                current = current.right;
                isLeftChild = false;
            }

            if (current == null)
                return false;
        }
// если узел - лист или корень без потомков
        if (current.left == null && current.right == null){
            if (current == root){
                root = null;
            }
            else if (isLeftChild){
                parent.left = null;
            }
            else{
                parent.right = null;
            }
        }
//  есть левый потомок
        else if (current.right == null){
            if (current == root){
                root = current.left;
            }
            else if (isLeftChild){
                parent.left = current.left;
            }
            else{
                parent.right = current.left;
            }
            updChildHeight(current.left, current.height);

        }
// есть правый потомок
        else if (current.left == null){
            if (current == root){
                root = current.right;
            }
            else if (isLeftChild){
                parent.left = current.right;
            }
            else{
                parent.right = current.right;
            }
            updChildHeight(current.right, current.height);
        }
// есть два потомка
        else {
            Node successor = getSuccessor(current);

            if (current == root){
                root = successor;
            }
            else if (isLeftChild){
                parent.left = successor;
            }
            else{
                parent.right = successor;
            }
            successor.left = current.left;
            updChildHeight(successor, current.height);
        }

        return  true;

    }

    //изменяем  высоту низлежащих узлов начиная с узла node
    private void updChildHeight(Node localRoot, int height){
        if(localRoot != null){
            localRoot.height = height;
            updChildHeight(localRoot.left, height+1);
            updChildHeight(localRoot.right, height+1);
        }
    }

    public boolean isBalance(Node node){



        return Math.abs(node.left.height - node.right.height)<2;
/*
        if (node != null){
            return isBalance(node.left) &&  isBalance(node.right);
        }*/
    }


    @Override
    public String toString() {
        return toString(root);
    }

    private String toString(Node node) {
        if(node == null){
            return "";
        }
        return toString(node.left)
                + "[" + node.key + "=" + node.value + "], "
                + toString(node.right);
    }

}
