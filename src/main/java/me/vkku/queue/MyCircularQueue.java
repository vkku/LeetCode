package me.vkku.queue;

import java.util.ArrayList;

class MyCircularQueue {

  int front = 0;
  int rear = 0;
  int capacity = 0;
  int maxSize = 0;
  ArrayList<Integer> circularQueue;

  public MyCircularQueue(int k) {
    maxSize = k;
    circularQueue = new ArrayList<Integer>(k);
  }

  public boolean enQueue(int value) {
    if(isFull()){
      return false;
    }
    capacity++;
    rear = rear + 1 % maxSize;
    circularQueue.add(rear, value);
    return true;
  }

  public boolean deQueue() {
    if(isEmpty()){
      return false;
    }
    capacity--;
    circularQueue.remove(front);
    front = front + 1 % maxSize;
    return true;
  }

  public int Front() {
    if(isEmpty()){
      return -1;
    }
    return circularQueue.get(front);
  }

  public int Rear() {
    if(isEmpty()){
      return -1;
    }
    return circularQueue.get(rear);
  }

  public boolean isEmpty() {
    return capacity == 0;
  }

  public boolean isFull() {
    return capacity == maxSize;
  }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */