package arraysNstrings.mergeIntervals;

import java.util.*;

class MergeIntervals {

    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> mergedIntervals = new LinkedList<Interval>();
        Comparator<Interval> iComparator = Comparator.comparing(i -> i.start);
        if(intervals.size() < 2) {
            return mergedIntervals;
        }

        Collections.sort(intervals, iComparator);

        int initialStart = intervals.get(0).start;
        int initialEnd = intervals.get(0).end;

        for(int i=1;i<intervals.size();i++) {
            int currentStart = intervals.get(i).start;
            int currentEnd = intervals.get(i).end;

            if(currentStart <= initialEnd) {
                initialEnd = Math.max(initialEnd, currentEnd);
//                mergedIntervals.add(new Interval(initialStart, initialEnd));
            } else {
                mergedIntervals.add(new Interval(initialStart, initialEnd));
                initialStart = currentStart;
                initialEnd = currentEnd;

            }
        }

        mergedIntervals.add(new Interval(initialStart, initialEnd));

        return mergedIntervals;
    }

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> mergedIntervals = new ArrayList<>();
        if(intervals == null||intervals.isEmpty()) {
            return Arrays.asList(newInterval);
        }

        int i=0;
        //ignore all the intervals whose end < newInterval.start
        while(i<intervals.size() && intervals.get(i).end < newInterval.start) {
            mergedIntervals.add(intervals.get(i));
            i++;
        }

        //start merging cond: intervals.get(i).start <= newInterval.end
        while(i<intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
            i++;
        }

        // after calculating the end of overlapping intervals
        mergedIntervals.add(new Interval(newInterval.start, newInterval.end));

        while(i<intervals.size())
            mergedIntervals.add(intervals.get(i++));

        return mergedIntervals;
    }


    public static Interval[] intersection(Interval[] arr1, Interval[] arr2) {
        List<Interval> intervalsIntersection = new ArrayList<Interval>();

        int i=0, j=0;
        int n=arr1.length, m=arr2.length;

        while(i<n && j<m) {
            if((arr1[i].start >= arr2[j].start && arr1[i].start <= arr2[j].end)
                    ||(arr2[j].start >= arr1[i].start && arr2[j].start <= arr1[i].end)) {
                intervalsIntersection.add(new Interval(Math.max(arr1[i].start, arr2[j].start),
                        Math.min(arr1[i].end, arr2[j].end)));
            }

            if(arr1[i].end < arr2[j].end)
                i++; //arr1[i] finishes first
            else
                j++;
        }

        return intervalsIntersection.toArray(new Interval[intervalsIntersection.size()]);
    }

    public static boolean canAttendAllAppointments(Interval[] intervals) {
        Comparator<Interval> iComparator = Comparator.comparing(i -> i.start);
        Arrays.sort(intervals, iComparator);

        for(int i=1;i<intervals.length;i++) {
            if(intervals[i].start < intervals[i-1].end) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();


        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : MergeIntervals.insert(input, new Interval(4, 6)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : MergeIntervals.insert(input, new Interval(4, 10)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(2, 3));
        input.add(new Interval(5, 7));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : MergeIntervals.insert(input, new Interval(1, 4)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();


        Interval[] input1 = new Interval[] { new Interval(1, 3), new Interval(5, 6), new Interval(7, 9) };
        Interval[] input2 = new Interval[] { new Interval(2, 3), new Interval(5, 7) };
        Interval[] result = MergeIntervals.intersection(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input1 = new Interval[] { new Interval(1, 3), new Interval(5, 7), new Interval(9, 12) };
        input2 = new Interval[] { new Interval(5, 10) };
        result = MergeIntervals.intersection(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");

        Interval[] intervals = { new Interval(1, 4), new Interval(2, 5), new Interval(7, 9) };
        boolean result4 = MergeIntervals.canAttendAllAppointments(intervals);
        System.out.println("Can attend all appointments: " + result4);

        Interval[] intervals1 = { new Interval(6, 7), new Interval(2, 4), new Interval(8, 12) };
        result4 = MergeIntervals.canAttendAllAppointments(intervals1);
        System.out.println("Can attend all appointments: " + result4);

        Interval[] intervals2 = { new Interval(4, 5), new Interval(2, 3), new Interval(3, 6) };
        result4 = MergeIntervals.canAttendAllAppointments(intervals2);
        System.out.println("Can attend all appointments: " + result4);
    }
}
