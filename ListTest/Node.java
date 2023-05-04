/**
 * @Author Lick
 * @date Created in 2022-11-17 10:24
 */
class Node {
    private int v;
    private Node next;

    public Node() {
        v = 0;
        next=null;
    }
    public Node(int v) {
        this.v = v;
        next = null;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node n) {
        next = n;
    }

}
