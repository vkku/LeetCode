package me.vkku.queue;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class CircularQueue_622 {
  ArrayList<Integer> queue;
  int front = 0;
  int rear = 0;
  int current = 0;
  int maxSize = 0;

  public CircularQueue_622(int k) {
    maxSize = k;
    queue = new ArrayList<>(k);
  }

  public boolean enQueue(int value) {
    if(current == maxSize + 1){
      return false;
    }
    queue.add(current % maxSize, value);
    current++;
    return true;
  }

  public boolean deQueue() {
    if(front == rear){
      return false;
    }
    front--;
    return true;
  }

  public int Front() {
    if(front == rear){
      return -1;
    }
    return queue.get(front);
  }

  public int Rear() {
    if(front == rear){
      return -1;
    }
    return queue.get(rear);
  }

  public boolean isEmpty() {
    if(front == rear){
      return true;
    }
    return false;
  }

  public boolean isFull() {
    if(front == rear -1){
      return true;
    }
    return false;
  }

  @Test
  public void circularQueueDriver(){
    CircularQueue_622 cqueue = new CircularQueue_622(4);

  }

}
