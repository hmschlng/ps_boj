import java.util.*;

class Solution {
    static Map<Character, Integer> termInfo;
    static int[] months = {12,1,2,3,4,5,6,7,8,9,10,11};
    public int[] solution(String today, String[] terms, String[] privacies) {
        // 유효기간 종류를 map에 저장
        termInfo = new HashMap<>();
        for(String term : terms) {
            String[] info = term.split(" ");
            termInfo.put(info[0].charAt(0), Integer.parseInt(info[1]));
        }
        List<Integer> delList = new ArrayList<>();
        for(int i = 0; i < privacies.length; i++) {
            String[] info = privacies[i].split(" ");
            String expDate = getExpiryDate(info[0], info[1].charAt(0));
            if(toDelete(today, expDate)) {
                delList.add(i+1);
            }
        }
        int[] ans = delList.stream().mapToInt(x -> x).toArray();
        return ans;
    }
    public String getExpiryDate(String getDate, char term) {
        StringTokenizer st = new StringTokenizer(getDate, ".");
        int year = Integer.parseInt(st.nextToken());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());
        int period = termInfo.get(term);
        
        StringBuilder sb = new StringBuilder();
        
        month += period;
        
        if(month > 12) {
            year += month / 12;
            if(month % 12 == 0) {
                year--;
            }
            month = months[month % 12];
        }
        
        return sb.append(year).append(".")
                .append(month < 10 ? "0" : "").append(month).append(".")
                .append(day < 10 ? "0" : "").append(day)
                .toString();
    }
    
    public boolean toDelete(String today, String expDate) {
        System.out.println(today + " . " + expDate);
        StringTokenizer st = new StringTokenizer(today, ".");
        int todayYear = Integer.parseInt(st.nextToken());
        int todayMonth = Integer.parseInt(st.nextToken());
        int todayDay = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(expDate, ".");
        int expYear = Integer.parseInt(st.nextToken());
        int expMonth = Integer.parseInt(st.nextToken());
        int expDay = Integer.parseInt(st.nextToken());
        
        if(todayYear > expYear) return true;
        if(todayYear == expYear && todayMonth > expMonth) return true;
        if(todayYear == expYear && todayMonth == expMonth && todayDay >= expDay) return true;
        return false;
    }
}