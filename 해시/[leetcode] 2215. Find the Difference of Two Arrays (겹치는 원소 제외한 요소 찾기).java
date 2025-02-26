
/*
겹치는 원소 제외하기

방법2.
각각 set으로 중복된 원소 없앤다.
일반 배열 반복문으로 상대 set값 확인해서 포함되면 두 set에서 모두 삭제해주기
이때 배열을 반복 대상으로 놓지 않고 set으로 놓으면 쓰레드 부족으로 오류 뜰 수있음

*/
class Solution {
    //방법1, 따로 추가하기
//    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
//
//        Set<Integer> list1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
//        Set<Integer> list2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
//
//
//        List<List<Integer>> ans = new ArrayList<>();
//
//        Set<Integer> ans1 = new HashSet<>();
//        Set<Integer> ans2 = new HashSet<>();
//
//        for(int v: list1){
//            if(!list2.contains(v)) ans1.add(v);
//        }
//
//        for(int v: nums2){
//            if(!list1.contains(v)) ans2.add(v);
//        }
//
//        ans.add(new ArrayList<>(ans1));
//        ans.add(new ArrayList<>(ans2));
//
//        return ans;
//    }
    //방법2. 겹치는 것을 같이 지우기.
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());


        for(int v : nums1){ // set1 으로 두면 ConcurrentModificationException 오류 발생
            if(set2.contains(v)){
                set1.remove(v);
                set2.remove(v);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        ans.add(new ArrayList<>(set1));
        ans.add(new ArrayList<>(set2));

        return ans;
    }
}