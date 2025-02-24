/*
0를 제외하고 나머지 숫자를 모두 앞으로 밀고, 0는 뒤에 배치

1. 구현
일단 List에 숫자를 0빼고 모두 저장.
0을 마지막에 넣자.
그다음에 nums에 다시 넣으면 됨

2. 투포인터
s는 0을 가리키고, e 0아닌 숫자 가리킴
e가 0이 아니면 스왑
e가 마지막에 도달하면 끝.
*/
class Solution {
    public void moveZeroes(int[] nums) {

        //방법2. 투포인터
        int s = 0;

        for(int e=0; e<nums.length; e++){
            if(nums[e] != 0){
                int temp = nums[e];
                nums[e] = nums[s];
                nums[s] = temp;
                s++;
            }
        }
        //방법1. 구현
        // List<Integer> list = new ArrayList<>();

        // int zero = 0;
        // for(int i=0; i<nums.length; i++){
        //     if(nums[i] != 0) list.add(nums[i]);
        //     else zero++;
        // }
        // for(int i=0; i<zero; i++){
        //     list.add(0);
        // }

        // for(int i=0; i<nums.length; i++){
        //     nums[i] = list.get(i);
        // }

    }
}