let answer = 0;
function solution(nums) {
    combination(0,0,[],nums)
    return answer;
}

function combination(depth, idx, arr, nums){
    if(depth == 3){
        let number = 0;
        for(let num of arr){
            number += num;
        }

        let count = 0;
        for(let i=1 ; i<=number ; i++){
            if(number % i === 0){
                count += 1;
            }
        }
        if(count === 2){
            answer += 1;
        }

        return;
    }

    for (let i = idx; i < nums.length ; i++) {
        arr[depth] = nums[i];
        combination(depth + 1, i + 1, arr, nums);
    }

}

answer = solution(	[1,2,7,6,4])
console.log(answer)