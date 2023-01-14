// Link: https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/description/

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        // We create a stack and the queue to simulate the serving process
        Stack<Integer> sandwichStack = new Stack<>();
        Queue<Integer> studentQueue = new LinkedList<>();
        // populate the stack and the queue
        for (int i = 0; i < students.length; i++) {
            sandwichStack.push(sandwiches[sandwiches.length-i-1]);
            studentQueue.offer(students[i]);
        }

        int couldntServe = 0;   // number of students that'll be left hungry
        while (true) {
            if (sandwichStack.peek() == studentQueue.peek()) {  // if types match
                couldntServe = 0;       // served the current student
                sandwichStack.pop();    // sandwich served
                studentQueue.poll();    // student moves out of queue
            } else {
                couldntServe++;         // couldnt serve so increment count
                studentQueue.offer(studentQueue.poll());    // move the student to the end of queue
            }

            // the unserved students will keep accumulating the the back of the queue
            // until a situation would occur when we won't be able to serve them anymore due to type mismatch
            // the queue will be left with only unservable students
            if (couldntServe == studentQueue.size()) {  // that's when this condition would be hit
                break;
            }
        }

        return couldntServe;    // return the number of unserved students
    }
}

// TC: O(n), SC: O(n)