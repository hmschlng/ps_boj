function solution(n, s) { 
    if(n === 1) return [s];
    if(s < n) return [-1];

    const ave = parseInt(s/n);  
    const r = s % n;
    const answer = [];

    for(let i = 0; i < n; i++) {
        if(i < n-r) answer[i] = ave;
        else answer[i] = ave+1;
    }        
    return answer;
}