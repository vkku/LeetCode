package me.vkku.queue.bfs;

import org.junit.jupiter.api.Test;

import java.util.*;

/*
    https://leetcode.com/problems/open-the-lock/description/
    Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
    Output: 6
    Explanation:
    A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
    Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
    because the wheels of the lock become stuck after the display becomes the dead end "0102".
 */

class PositionTracker {
    String pin;
    int turns;

    public PositionTracker(String pin, int turns) {
        this.pin = pin;
        this.turns = turns;
    }
}
public class Open_Lock_752 {
    public int openLock(String[] deadends, String target) {
        if(Arrays.asList(deadends).contains("0000")){
            return -1;
        }
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        Queue<PositionTracker> queue = new LinkedList<>();
        queue.add(new PositionTracker("0000", 0));
        while(!queue.isEmpty()){
            PositionTracker position = queue.poll();
            if(position.pin.equals(target)){
                return position.turns;
            }
            for(String pin : getChildren(position.pin)){
                if(!visited.contains(pin)){
                    visited.add(pin);
                    queue.add(new PositionTracker(pin, position.turns + 1));
                }

            }
        }
        return -1;
    }

    List<String> getChildren(String parent){
        List<String> children = new ArrayList<>();
        for(int i = 0 ; i < parent.length() ; i++){
            int bitToBeManipulated = Integer.parseInt(String.valueOf(parent.charAt(i)));
            //Moving to next position
            children.add(parent.substring(0, i) + ((bitToBeManipulated + 1) % 10) + parent.substring(i + 1));
            //Moving to previous position
            children.add(parent.substring(0, i) + (((bitToBeManipulated - 1) + 10) % 10) + parent.substring(i + 1));
        }
        return children;
    }


    @Test
    public void driver(){
        Open_Lock_752 lock = new Open_Lock_752();
        int result = lock.openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202");
        System.out.println(result);
    }
}
