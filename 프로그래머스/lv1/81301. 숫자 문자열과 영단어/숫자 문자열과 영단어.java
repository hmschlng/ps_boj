class Solution {
    static String[] eng = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        int idx = 0;
        while(idx < s.length()){
            if(Character.isDigit(s.charAt(idx))) {
                sb.append(s.charAt(idx++) - '0');
            } else {
                for(int i = 0; i < eng.length; i++) {
                    if(eng[i].contains(s.substring(idx, idx+2))) {
                        sb.append(i);
                        idx = idx + eng[i].length();
                        break;
                    }
                }
            }
        }
        int answer = Integer.parseInt(sb.toString());
        return answer;
    }
}