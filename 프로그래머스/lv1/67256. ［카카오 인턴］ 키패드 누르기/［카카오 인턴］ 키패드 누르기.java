import java.util.*;

class Solution {
    static Map<Character,Integer> map;
    static int[] lPos, rPos;
    public String solution(int[] numbers, String hand) {
        init();
        StringBuilder sb = new StringBuilder();
        lPos = new int[]{0,0};
        rPos = new int[]{2,0};
        
        for(int number : numbers) {
            char chNum = (char)(number + '0');
            
            switch(number) {
                case 1:case 4:case 7:
                    lPos = new int[]{0, map.get(chNum)};
                    sb.append("L");
                    break;
                case 3:case 6:case 9:
                    rPos = new int[]{2, map.get(chNum)};
                    sb.append("R");
                    break;
                default:
                    int cPos = map.get(chNum);
                    int lDist = getD(lPos[0], lPos[1], 1, cPos);
                    int rDist = getD(rPos[0], rPos[1], 1, cPos);
                    if(lDist == rDist) {
                      if(hand.equals("left")) {
                          sb.append("L");
                          lPos = new int[]{1, cPos};
                      } else {
                          sb.append("R");
                          rPos = new int[]{1, cPos};
                      }
                    } else if(lDist < rDist) {
                        sb.append("L");
                        lPos = new int[]{1, cPos};
                    } else {
                        sb.append("R");
                        rPos = new int[]{1, cPos};                        
                    }
            }
        }
        return sb.toString();
    }
    
    public int getD(int r1,int c1,int r2,int c2) {
        return Math.abs(r1-r2) + Math.abs(c1-c2);
    }
    
    public void init() {
        map = new HashMap<>();
        map.put('*', 0);
        map.put('0', 0);
        map.put('#', 0);
        int pos = 1;
        
        for(int i = 9; i >= 1; pos++) {
            for(int j = 0; j < 3; j++, i--) {
                char key = (char)('0' + i);
                map.put(key, pos);
            }
        }
    }
}