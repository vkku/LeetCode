package me.vkku.daily;

import org.junit.jupiter.api.Test;

public class PassPillow_2582 {
    public int passThePillow(int n, int time) {
        int counter = 1;
        boolean flag = false;
        while(time > 0){
            if(counter >= n){
                flag = true;
            }
            if(counter == 1){
                flag = false;
            }
            if(flag){
                counter--;
            }else{
                counter++;
            }
            time--;
        }
        return counter;
    }

    @Test
    public void driver(){
        PassPillow_2582 passPillow = new PassPillow_2582();
        System.out.println(passPillow.passThePillow(18, 38));
    }

}
