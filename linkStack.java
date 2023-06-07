package stack;

public class linkStack {
    public static class Node{
        int value;
        Node next;        
    }

    public static class list{
        Node head;
        Node tail;
        int size =0;

        public void create(int val) {
            Node one = new Node();
            one.value = val;
            one.next = null;

            head = one;
            tail = one;

            size++;
        }

        public void show() {
            Node one = head;

            while (one != null) {
                System.out.print(one.value + " -> ");
                one = one.next; 
            }

            System.out.println("null");
        }

        public void insert(int val, int location) {
            Node one = new Node();
            one.value = val;

            if (location == 1) {
                if (head == null) {
                    create(val);
                    return;
                }
                one.next = head;
                head = one; 
                size++;                
            } else if(location == size) {
                tail.next = one;
                tail = one;
                tail.next = null;
                size++;                
            } else if(size >= location) {
                throw new IllegalArgumentException("size greater than location");
            } else{
                Node two = head;
                int cot =0;

                while (cot != location -1) {
                    two = two.next;
                    cot++;
                }

                one.next = two.next;
                two.next = one;
                size++;
            }
        }

        public void search(int nodeValue) {
            Node node = head;
            int count = 0;

            while (node != null) {
                if (node.value == nodeValue) {
                    System.out.println("value present at " + count);
                    return;
                }

                count++;
                node = node.next;
            }

            System.out.println("value not present");
        }

        public void del(int location) {
            if (head == null) {
                System.out.println("list does not exist");
            } else if (size ==1) {
                head = null;
                tail = null;
                size--;
            } else{
                Node one = head;

                if (location == 0) {
                    head = head.next;
                    size--;
                }
                
                else if (location >= size) {
                    while (one.next != tail) {
                        one = one.next; 
                    }

                    one.next = null;
                    tail = one;
                    size--;
                }

                else{
                    int index = 0;

                    while (index != location -1) {
                        one = one.next; 
                        index++;
                    }

                    one.next = one.next.next;
                    size--;
                }                
            }                
        }
    }
 
    public static class stack {
        list link;
        public stack(){
            link = new list();
        }

        public void push(int val) {
            link.insert(val,1);
            System.out.println("added");
        }

        public void peek() {
            link.show();
        }

        public void pop() {
            link.del(link.size);
        }
        
        public boolean isEmpty() {
            if (link.head == null) {
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        stack one = new stack();
        one.push(0);
        one.push(2);
        one.push(4);
        one.push(4);

        one.peek();

        one.pop();
        one.pop();
        one.pop();
        one.peek();
    }
}