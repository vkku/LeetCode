import java.util.ArrayList;

class MyCircularQueue {
  ArrayList<Integer> queue;
  int front = 0;
  int rear = -1;
  int maxSize = 0;
  int size = 0;

  public MyCircularQueue(int k) {
    maxSize = k;
    queue = new ArrayList<>(k);
  }

  public boolean enQueue(int value) {
    if(size >= maxSize){
      return false;
    }
    rear = (rear + 1) % maxSize;
    size++;
    queue.add(rear % maxSize, value);
    return true;
  }

  public boolean deQueue() {
    if(queue.get(front) == null){
      return false;
    }
    if(front < rear){
      front++;
    }
    size--;
    return true;
  }

  public int Front() {
    if(queue.get(front) == null){
      return -1;
    }
    return queue.get(front);
  }

  public int Rear() {
    if(rear == -1){
      return -1;
    }
    return queue.get(rear);
  }

  public boolean isEmpty() {
      return rear == -1;
  }

  public boolean isFull() {
      return size >= maxSize;
  }

}

class Driver {
  // * Your MyCircularQueue object will be instantiated and called as such:

  public static void main(String[] args) {
    MyCircularQueue obj = new MyCircularQueue(6);
      //["MyCircularQueue","enQueue","Rear","Rear","deQueue","enQueue","Rear","deQueue","Front","deQueue","deQueue","deQueue"]
      boolean param_1 = obj.enQueue(6);
      int param_2 = obj.Rear();
      int param_3 = obj.Rear();
      boolean param_4 = obj.deQueue();
      boolean param_5 = obj.enQueue(5);
      int param_6 = obj.Rear();
      boolean param_7 = obj.deQueue();
      int param_8 = obj.Front();
      boolean param_9 = obj.deQueue();
      boolean param_10 = obj.deQueue();
      boolean param_11 = obj.deQueue();

      System.out.println(param_1);
      System.out.println(param_2);
      System.out.println(param_3);
      System.out.println(param_4);
      System.out.println(param_5);
      System.out.println(param_6);
      System.out.println(param_7);
      System.out.println(param_8);
      System.out.println(param_9);
      System.out.println(param_10);
      System.out.println(param_11);

  }
}