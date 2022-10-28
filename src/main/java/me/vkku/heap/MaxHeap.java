package me.vkku.heap;

public class MaxHeap {

  int heapSize;
  int realSize;
  int[] maxHeap;

  MaxHeap(int size) {
    this.heapSize = size;
    maxHeap = new int[size + 1];
    maxHeap[0] = 0;
  }

  public void add(int element) {
    realSize++;
    if (realSize > heapSize) {
      System.out.println("Heap Size Exceeded!");
      return;
    }
    maxHeap[realSize] = element;
    int index = realSize;
    int parent = index / 2;
    while (maxHeap[index] > maxHeap[parent] && index > 1) {
      int temp = maxHeap[index];
      maxHeap[index] = maxHeap[parent];
      maxHeap[parent] = temp;
      index = parent;
      parent = index / 2;
    }
  }

  public int pop() {
    if (realSize < 1) {
      System.out.println("UnderFlow!! Nothing to delete!");
      return Integer.MIN_VALUE;
    }
    int removedElement = maxHeap[1];
    maxHeap[1] = maxHeap[realSize--];
    int index = 1;
    while (index < realSize / 2) {
      int leftChild = index * 2;
      int rightChild = leftChild + 1;
      if (maxHeap[leftChild] < maxHeap[index]) {
        int temp = maxHeap[leftChild];
        maxHeap[leftChild] = maxHeap[index];
        maxHeap[index] = temp;
        index = leftChild;
      } else if (maxHeap[rightChild] < maxHeap[index]) {
        int temp = maxHeap[rightChild];
        maxHeap[rightChild] = maxHeap[index];
        maxHeap[index] = temp;
        index = rightChild;
      }
    }
    return removedElement;
  }

  public int peek() {
    return maxHeap[1];
  }

  public int size() {
    return realSize;
  }

  public String toString() {
    if (realSize == 0) {
      return "No element!";
    } else {
      StringBuilder sb = new StringBuilder();
      sb.append('[');
      for (int i = 1; i <= realSize; i++) {
        sb.append(maxHeap[i]);
        sb.append(',');
      }
      sb.deleteCharAt(sb.length() - 1);
      sb.append(']');
      return sb.toString();
    }
  }

  public static void main(String[] args) {
    // Test case
    MaxHeap maxheap = new MaxHeap(5);
    maxheap.add(1);
    maxheap.add(2);
    maxheap.add(3);
    // [3,1,2]
    System.out.println(maxheap.toString());
    // 3
    System.out.println(maxheap.peek());
    // 3
    System.out.println(maxheap.pop());
    //2
    System.out.println(maxheap.pop());
    //1
    System.out.println(maxheap.pop());
    // No element
    System.out.println(maxheap.toString());
    maxheap.add(4);
    maxheap.add(5);
    // [5, 4]
    System.out.println(maxheap.toString());
  }
}
