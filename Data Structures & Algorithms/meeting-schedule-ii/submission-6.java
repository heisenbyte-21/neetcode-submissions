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
        intervals.sort((a, b) -> (Integer.compare(a.start, b.start)));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < intervals.size(); i++){
            Interval currentInterval = intervals.get(i);

            if(!pq.isEmpty() && pq.peek() <= currentInterval.start){
                pq.poll();
            }

            pq.offer(currentInterval.end);
        }

        return pq.size();
    }
}
