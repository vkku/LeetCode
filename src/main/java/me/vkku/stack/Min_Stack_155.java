package me.vkku.stack;

public class Min_Stack_155 {
    ArrayList<Integer> stack;
    int size = 0;
    int min = Integer.MAX_VALUE;
    public MinStack() {
        stack = new ArrayList<>();
    }

    public void push(int val) {
        stack.add(val);
        size++;
    }

    public void pop() {
        if(size > 0){
            stack.remove(--size);
        }
    }

    public int top() {
        return stack.get(size - 1);
    }

    public int getMin() {
        min = Integer.MAX_VALUE;
        int temp = size;
        while(size > 0){
            min = stack.get(size - 1) < min ? stack.get(size - 1) : min;
            size--;
        }
        size = temp;
        return min;
    }
}
