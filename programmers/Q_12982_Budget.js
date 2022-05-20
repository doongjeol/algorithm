function solution(d, budget) {
    let answer = 0;
    let curBudget = 0;
    d.sort( (a, b) => a - b );

    for(let num of d){
        curBudget += num;
        if(curBudget > budget) break;
        if(curBudget === budget){
            answer += 1;
            break;
        }
        answer += 1;
    }
    return answer;
}

let d = [1,2,10];
let budget = 12;
let answer = solution(d,budget);
console.log(answer)
