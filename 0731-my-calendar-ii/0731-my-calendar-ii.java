//skip
//honeymoon
class MyCalendarTwo {

    private TreeMap<Integer, Integer> bookingCount;
    private int maxOverlappedBooking;

    public MyCalendarTwo() {
        bookingCount = new TreeMap<>();
        maxOverlappedBooking = 2;
    }

    public boolean book(int start, int end) {
        // Increase the booking count at 'start' and decrease at 'end'.
        bookingCount.put(start, bookingCount.getOrDefault(start, 0) + 1);
        bookingCount.put(end, bookingCount.getOrDefault(end, 0) - 1);

        int overlappedBooking = 0;

        // Calculate the prefix sum of bookings.
        for (Map.Entry<Integer, Integer> entry : bookingCount.entrySet()) {
            overlappedBooking += entry.getValue();

            // If the number of overlaps exceeds the allowed limit, rollback and
            // return false.
            if (overlappedBooking > maxOverlappedBooking) {
                // Rollback changes.
                bookingCount.put(start, bookingCount.get(start) - 1);
                bookingCount.put(end, bookingCount.get(end) + 1);

                // Clean up if the count becomes zero to maintain the map clean.
                if (bookingCount.get(start) == 0) {
                    bookingCount.remove(start);
                }

                return false;
            }
        }

        return true;
    }
}