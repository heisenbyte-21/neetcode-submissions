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
        if (intervals == null || intervals.isEmpty()) return 0;

        intervals.sort((a, b) -> (Integer.compare(a.start, b.start)));
        PriorityQueue<Integer> activeRooms = new PriorityQueue<>();
        activeRooms.offer(intervals.get(0).end);

        for(int i = 1; i < intervals.size(); i++){
            if(activeRooms.peek() <= intervals.get(i).start){
                activeRooms.poll();
            }

            activeRooms.offer(intervals.get(i).end);
        }

        return activeRooms.size();
    }
}
