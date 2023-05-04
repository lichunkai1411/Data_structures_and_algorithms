/**
 * @Author Lick
 * @date Created in 2022-11-24 10:37
 */

public class MyLinkedList {
    //定义一个静态的内部类
    private static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    private Node head;
    //尾部插入元素的操作
    private Node last;
    //链表的实际长度
    private int size;

    public void insert(int data, int index)throws Exception{
        if(index < 0 || index > size)
            throw new IndexOutOfBoundsException("超出链表节点范围！");
        Node insertedNode = new Node(data);
        //插入第一个元素时元素个数为0
        if(size == 0){
            head = insertedNode;
            last = insertedNode;
            //末尾插入
        }else if(size == index){
            last.next = insertedNode;
            last = insertedNode;
        }else{
            Node prevNode = get(index - 1);
            Node nextNode = prevNode.next;
            prevNode.next = insertedNode;
            insertedNode.next = nextNode;
        }
        size++;
    }

    public void update(int data, int index) throws Exception{
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("超出链表节点范围！");
        if(index == 0)
            head.data = data;
        else if(index == size - 1)
            last.data = data;
        else{
            Node temp = get(index);
            temp.data = data;
        }
    }

    public Node remove(int index) throws Exception {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("超出链表节点范围！");
        }
        //不给removedNode分配堆内存
        Node removedNode = null;
        if(index == 0){
            removedNode = head;
            head = head.next;
        }
        else if(index == size - 1){
            //删除尾结点
            Node prevNode = get(index - 1);
            removedNode = prevNode.next;
            prevNode.next = null;
            last = prevNode;
        }
        else{
            Node prevNode = get(index - 1);
            Node nextNode = prevNode.next.next;
            removedNode = prevNode.next;
            prevNode.next = nextNode;
        }
        size--;
        return removedNode;
    }



    //查找链表元素
    public Node get(int index) throws Exception{
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("超出链表节点范围！");
        }
        Node temp = head;
        for(int i = 0; i < index; i++){
            temp = temp.next;
        }
        return temp;
    }

    //输出链表
    public void output(){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) throws Exception{
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.insert(3,0);
        myLinkedList.insert(7,1);
        myLinkedList.insert(9,2);
        myLinkedList.insert(5,3);
        myLinkedList.insert(6,1);
        myLinkedList.remove(0);
        myLinkedList.update(2,1);
        myLinkedList.output();
        System.out.println(myLinkedList.size);
    }
}
