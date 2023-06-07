package stack;
import java.util.*;

public class stackArr {
    int top;
    Integer [] arr;

    public stackArr(int size){
        arr = new Integer[size];
        top =-1;
        System.out.println("stack  created of size: " + size);
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (top == arr.length -1) {
            return true;
        }
        return false;
    }

    public void push(int val) {
        // if (isFull()) {
        //     System.out.println("stack is full");
        // }

        try {
        arr[top +1] = val;
        top++;

        System.out.println("added "+ val);
            
        } catch (ArrayIndexOutOfBoundsException e) {
            // TODO: handle exception
            System.out.println("invalid value");
        }
    }
    
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("stack is empty");
        } else {
            int ret = arr[top];
            top--;
            return ret;
        }
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("stack is empty");
        } else {
            int ret = arr[top];

            return ret;
        }
    }

    public void del() {
        Arrays.fill(arr, null);  // Clear all elements by setting them to null
        top = -1;
        System.out.println("Stack deleted");
    }
    
  
    public static void main(String[] args) {
        stackArr one = new stackArr(2);
        System.out.println(one.isEmpty());
        one.push(1);
        one.push(1);
        System.out.println(one.peek());
    }
    
}
