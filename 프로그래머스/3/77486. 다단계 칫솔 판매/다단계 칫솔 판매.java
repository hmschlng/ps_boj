import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String,String> hashMapping = new HashMap<>();
        Map<String,Integer> hashData = new HashMap<>();
        int length = enroll.length;
        /*Make Hash*/
        for(int i=0;i<length;i++){
            if(hashMapping.get(enroll[i]) == null){
                hashMapping.put(enroll[i],referral[i]);
                hashData.put(enroll[i],0);
            }
        }

        int len = seller.length;
        for(int i=0;i<len;i++){
            String person = seller[i];
            int money = amount[i]*100;
            int commission = money / 10;
            int earning = money - commission;    
            if(hashMapping.containsKey(person)){
                hashData.put(person, hashData.get(person) + earning);
                while(!hashMapping.get(person).equals("-")) {
                    person = hashMapping.get(person);
                    if(money == 0) break;
                    else money /= 10;
                    commission = money / 10;
                    earning = money - commission;            
                    hashData.put(person, hashData.get(person) + earning);
                }
            }
        }

        int[] answer = new int[enroll.length];
        int index=0;
        for(String en:enroll){
            answer[index++] = hashData.get(en);
        }

        return answer;
    }
//     static final int PRICE = 100;
//     static Map<String, String> bossMap;
//     static Map<String, Integer> salesMap;
    
//     public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
//         init(enroll, referral);
        
//         for(int i = 0; i < seller.length; i++) {
//             String name = seller[i];
//             String bossName = bossMap.get(name);
//             int sales = (amount[i] * PRICE);
//             int split = sales / 10;
//             salesMap.put(name, salesMap.get(name) + sales - split);
            
//             while(!bossName.equals("-")) {
//                 sales = split;
//                 split = sales / 10;
//                 salesMap.put(bossName, salesMap.get(bossName) + sales - split);
//                 bossName = bossMap.get(bossName);
//             }
//         }
        
//         for(Map.Entry<String,String> l : bossMap.entrySet()) {
//             System.out.print(l.getKey() +" "+l.getValue());
//             System.out.println();
//         }
        
//         int[] answer = new int[enroll.length];
//         for(int i = 0; i < enroll.length; i++) {
//             answer[i] = salesMap.get(enroll[i]);
//         }
        
//         return answer;
//     }
    
//     public void init(String[] enroll, String[] referral) {
//         bossMap = new HashMap<>();
//         salesMap = new HashMap<>();
//         for(int i = 0; i < enroll.length; i++) {
//             bossMap.put(enroll[i], referral[i]);
//             salesMap.put(enroll[i], 0);
//         }
        
//         for(Map.Entry<String,String> l : bossMap.entrySet()) {
//             System.out.print(l.getKey() +" "+l.getValue());
//             System.out.println();
//         }
//     }
}