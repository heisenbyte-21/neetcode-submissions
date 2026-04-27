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
    public boolean canAttendMeetings(List<Interval> intervals) {
      if(intervals.isEmpty()){
        return true;
      }

      intervals.sort((a, b) -> (
        Integer.compare(a.start, b.start)
      ));

      int prevEnd = intervals.get(0).end;

      for(int i = 1; i < intervals.size(); i++){
        if(prevEnd > intervals.get(i).start){
          return false;
        }

        prevEnd = intervals.get(i).end;
      }

      return true;
    }
}
