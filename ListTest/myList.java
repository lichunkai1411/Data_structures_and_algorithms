/**
 * @Author Lick
 * @date Created in 2022-11-24 11:25
 */

class Iter{
    Node p;
    public Iter(ListTest listTest){


    }
    public boolean hasNext(){
        return p!=null;
    }
//    public int next(){
//        int v = p.getV();
//
//    }
}
public class myList {
    private Node head;
    public myList(){
        head = null;
    }
    public void AddAtHead(int v){
        Node n = new Node(v);
        n.setNext(head);
        head=n;
    }
    public void AddAtTailer(int v){
        Node n = new Node(v);
        Node p = head;
        if (head==null){
            head=n;
            return;
        }
        while (p.getNext() != null)
            p=p.getNext();
        p.setNext(n);
    }
    public void RemoveAtHead(int v){
        if (head!=null){
            head=head.getNext();
        }
    }
//    public int count(){
//
//    }
//    public boolean find(int v){
//
//    }
    public void print(){

    }
}
