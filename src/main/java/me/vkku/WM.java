////package me.vkku;
//
//import java.util.ArrayList;
//import org.junit.jupiter.api.Test;
//
//public class WM {
//
//  @Test
//  public void driver(){
//
//    ArrayList<Integer> list = new ArrayList<>();
//    list.add(1);
//    list.get(0);
//    list.indexOf(1);
//
//  }
//
//  class CustomArrayList<L> extends ArrayList {
//    L[] arr;
//    int size;
//    public void add(L value){
//      initializeCapacity();
//      int index = 0;
//      addElement(index, value);
//    }
//
//    private void initializeCapacity() {
//      if(size == 0){
//        size += 10;
//      }
//      //if size is reached
//      //allocate more memory, new arr, copy the elements into new arr
//
//    }
//
//    private void addElement(int index, L value) {
//      arr[index] = value;
//    }
//
//    public L get(int index){
//      checkIfElementExists();
//      fetchElement();
//    }
//  }
//
//
//}
