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
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        intervals.sort(Comparator.comparingInt(a -> a.start));

        for(int i = 0; i < intervals.size(); i++){
            Interval curr = intervals.get(i);

            if(!pq.isEmpty() && pq.peek() <= curr.start){
               pq.poll();
            }
            pq.offer(curr.end);
        }

        return pq.size();
    }
}
