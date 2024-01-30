package me.vkku.iw;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;

/*
Capture max occuring IP in string, add all as CSV in case 1+ IPs having same count
["10.0.0.1 - GET 2020-08-24", "10.0.0.1 - GET 2020-08-24", "10.0.0.2 - GET 2020-08-20"] , O/p = 10.0.0.1
["10.0.0.1 - GET 2020-08-24", "10.0.0.1 - GET 2020-08-24", "10.0.0.2 - GET 2020-08-20", "10.0.0.3 - GET 2020-08-24", "10.0.0.2 - GET 2020-03-24"] , O/p = 10.0.0.1 , 10.0.0.2
 */
public class MSly {

  @Test
  public void captureIPs(){
    String inputIPs = "[\"10.0.0.1 - GET 2020-08-24\", \"10.0.0.1 - GET 2020-08-24\", \"10.0.0.2 - GET 2020-08-20\", \"10.0.0.3 - GET 2020-08-24\", \"10.0.0.2 - GET 2020-03-24\"]";
    String result = findRepeatingIP(inputIPs);
    System.out.println(result);
  }

  private String findRepeatingIP(String inputIPs) {
    String regex = "\\b(?:\\d{1,3}\\.){3}\\d{1,3}\\b";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(inputIPs);
    Map<String, Integer> ipCountMap = new HashMap<>();
    while (matcher.find()) {
      String ip = matcher.group();
      ipCountMap.put(ip, ipCountMap.getOrDefault(ip, 0) + 1);
    }
    int maxIpCount = Collections.max(ipCountMap.values());
    ArrayList<String> maxOccuringIps = new ArrayList<>();
    for (Entry<String, Integer> ipCount : ipCountMap.entrySet()){
      if(ipCount.getValue() == maxIpCount){
        maxOccuringIps.add(ipCount.getKey());
      }
    }
    Collections.sort(maxOccuringIps);
    return String.join(" ,", maxOccuringIps);
  }



}
