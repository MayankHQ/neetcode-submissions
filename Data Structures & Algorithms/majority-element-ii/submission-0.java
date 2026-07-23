class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int cnt1 = 0, cnt2 = 0;
        int majEle1 = 0, majEle2 = 0;

        for(int num : nums){
            if(cnt1 == 0 && num != majEle2){
                cnt1++;
                majEle1 = num;
            }
            else if(cnt2 == 0 && num != majEle1){
                cnt2++;
                majEle2 = num;
            }
            else if(majEle1 == num){
                cnt1++;
            }
            else if (majEle2 == num){
                cnt2++;
            }
            else{
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0; cnt2 = 0;
        for(int num : nums){
            if(num == majEle1) cnt1++;
            if(num == majEle2) cnt2++;
        }
        if(cnt1 > nums.length/3) ans.add(majEle1);
        if(cnt2 > nums.length/3) ans.add(majEle2);
        return ans;
    }
}