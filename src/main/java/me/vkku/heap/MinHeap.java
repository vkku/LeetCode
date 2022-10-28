package me.vkku.heap;

public class MinHeap {

  /*
  add
  peak
  pop
  size
   */
  int heapSize;
  int[] minHeap;
  int realSize;
  MinHeap(int heapSize){
    this.heapSize = heapSize;
    minHeap = new int[heapSize + 1];
    //Keep the formulae clear i.e. starting from 1 index
    minHeap[0] = 0;
  }

  public void add(int element){
    realSize++;
    if(realSize > heapSize){
      System.out.println("Max elements reached");
      realSize--;
      return;
    }
    minHeap[realSize] = element;
    int index = realSize;
    int parent = index / 2;
    while(minHeap[index] < minHeap[parent] && index > 1){
      int temp = minHeap[index];
      minHeap[index] = minHeap[parent];
      minHeap[parent] = temp;
      index = parent;
      parent = index /2;
    }
  }

  public int peek(){
    return minHeap[1];
  }

  public int pop(){
    if(realSize < 1){
      System.out.println("ERROR!!! No elements to delete");
      realSize++;
      return Integer.MAX_VALUE;
    }
    int removedElement = minHeap[1];
    minHeap[1] = minHeap[realSize];
    realSize--;
    int index = 1;
    while(index <= realSize/2){
      int leftChild = index * 2;
      int rightChild = leftChild + 1;
      if(minHeap[leftChild] < minHeap[index]){
        int temp = minHeap[index];
        minHeap[index] = minHeap[leftChild];
        minHeap[leftChild] = temp;
        index = leftChild;
      }
      else if(minHeap[rightChild] < minHeap[index]){
        int temp = minHeap[index];
        minHeap[index] = minHeap[rightChild];
        minHeap[rightChild] = temp;
        index = rightChild;
      }
    }
    return removedElement;
  }

  public int size(){
    return heapSize;
  }

  public String toString() {
    if (realSize == 0) {
      return "No element!";
    } else {
      StringBuilder sb = new StringBuilder();
      sb.append('[');
      for (int i = 1; i <= realSize; i++) {
        sb.append(minHeap[i]);
        sb.append(',');
      }
      sb.deleteCharAt(sb.length() - 1);
      sb.append(']');
      return sb.toString();
    }
  }

  public static void main(String[] args) {
    // Test case
    MinHeap minHeap = new MinHeap(3);
    minHeap.add(3);
    minHeap.add(1);
    minHeap.add(2);
    // [1,3,2]
    System.out.println(minHeap.toString());
    // 1
    System.out.println(minHeap.peek());
    // 1
    System.out.println(minHeap.pop());
    // [2, 3]
    System.out.println(minHeap.toString());
    minHeap.add(4);
    // Max elements reached
    minHeap.add(5);
    // [2,3,4]
    System.out.println(minHeap.toString());
  }
}
