/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        Map<Integer, Integer> map = new TreeMap<>();
        
        for(int i = 0; i < n; i++){
            int s = intervals.get(i).start;
            int e = intervals.get(i).end;
            map.put(s, map.getOrDefault(s, 0) + 1);
            map.put(e, map.getOrDefault(e, 0) - 1);
        }

        int overlap = 0, maxoverlap = 0;
        for(int count : map.values()){
            overlap += count;
            maxoverlap = Math.max(maxoverlap, overlap);
        }
        return maxoverlap;
    }
}
