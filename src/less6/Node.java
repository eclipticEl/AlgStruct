package less6;

public class Node {
    int key;
    double value;
    Node left;
    Node right;
    int size;
    int height;

    public Node(int key, double value) {
        this.key = key;
        this.value = value;
        size = 1;
        height = 0;
    }
}
