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

        Interval[] arr = intervals.toArray(new Interval[0]);
        Arrays.sort(arr, (a, b) -> (
            Integer.compare(a.start, b.start)
        ));
        PriorityQueue<Integer> activeRooms = new PriorityQueue<>();
        activeRooms.offer(arr[0].end);

        for(int i = 1; i < arr.length; i++){
            if(activeRooms.peek() <= arr[i].start){
                activeRooms.poll();
            }

            activeRooms.offer(arr[i].end);
        }

        return activeRooms.size();
    }
}
