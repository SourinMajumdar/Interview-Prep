// Link: https://leetcode.com/problems/my-calendar-i/
// Solution: https://www.youtube.com/watch?v=CC7rHLWbYqQ

class MyCalendar {
    TreeMap<Integer, Integer> calendar;

    public MyCalendar() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        if (calendar.floorEntry(start) != null && start < calendar.floorEntry(start).getValue()) {
            return false;
        }
        if (calendar.ceilingEntry(start) != null && end > calendar.ceilingEntry(start).getKey()) {
            return false;
        }

        calendar.put(start, end);
        return true;
    }
}

// TC: O(n * logn) - For each new event, we search that the event is legal in O(logN) time, then insert it in O(logN) time.
// SC: O(n)


class MyCalendar {
    TreeMap<Integer, Integer> calendar;

    public MyCalendar() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        calendar.put(start, calendar.getOrDefault(start, 0) + 1);
        calendar.put(end, calendar.getOrDefault(end, 0) - 1);

        int activeBookings = 0;

        for (int ending : calendar.values()) {
            activeBookings += ending;

            if (activeBookings > 1) {
                calendar.put(start, calendar.getOrDefault(start, 0) - 1);
                calendar.put(end, calendar.getOrDefault(end, 0) + 1);
                return false;
            }
        }

        return true;
    }
}

// TC: O(n * logn), SC: O(n)
