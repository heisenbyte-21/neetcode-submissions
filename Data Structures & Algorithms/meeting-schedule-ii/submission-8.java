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
        if(intervals.isEmpty()){
            return 0;
        }

        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        PriorityQueue<Integer> rooms = new PriorityQueue<>();

        rooms.offer(intervals.get(0).end);

        for(int i = 1; i < intervals.size(); i++){
            Interval curr = intervals.get(i);
            if(rooms.peek() <= curr.start){
                rooms.poll();
            }

            rooms.offer(curr.end);
        }

        return rooms.size();
    }
}
