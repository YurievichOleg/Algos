public class List {
    Node head;
    Node tail;

    public void add(int value){
        Node node = new Node();
        node.value = value;
        if (head == null){
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
    }

    public void  add(int value, Node node){
        Node next = node.next;
        Node newNode = new Node();
        newNode.value = value;
        node.next = newNode;
        newNode.previous = node;
        if (next == null){
            tail = newNode;
        } else {
            next.previous = newNode;
            newNode.next = next;
        }
    }

    public void delete(Node node){
        Node next = node.next;
        Node previous = node.previous;
        if (previous == null){
            next.previous = null;
            head = next;
        } else {
            if (next == null){
                previous.next = null;
                tail = previous;
            } else {
                previous.next = next;
                next.previous = previous;
            }
        }
    }

    public void revert(){
        Node currentNode = head;
        while (currentNode != null){
            Node next = currentNode.next;
            Node previous = currentNode.previous;
            currentNode.next = previous;
            currentNode.previous = next;
            if (previous == null){
                tail = currentNode;
            }
            if (next == null){
                head = currentNode;
            }

            currentNode = next;
        }
    }

    public Node find(int value){
        Node currentNode = head;
        while (currentNode != null){
            if (currentNode.value == value){
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    public String toString(){
        Node cur = head;
        String res = "";
        while (cur != null){
            res = res + cur.value + ";";
            cur = cur.next;
        }
        return res;
    }
    public class Node{
        int value;
        Node next;
        Node previous;
    }

    public static void main(String[] args) {
        List list = new List();
       
        list.add(5);
        list.add(3);
        list.add(8);
        System.out.println(list.toString());
        list.revert();
        System.out.println(list.toString());

    }
}
