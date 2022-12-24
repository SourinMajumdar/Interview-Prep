// Link: https://leetcode.com/problems/maximum-enemy-forts-that-can-be-captured/

// biweekly 94, 24 dec 2022
// Q2

class Solution {
    class student {
        int id;
        int pts;
        student(int id, int pts) {
            this.id = id;
            this.pts = pts;
        }
    }

    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        // Set<String> posFeedback = new HashSet<>(Arrays.asList(positive_feedback));
        // Set<String> negFeedback = new HashSet<>(Arrays.asList(negative_feedback));

        Set<String> posFeedback = new HashSet<>();
        Set<String> negFeedback = new HashSet<>();

        for (String s : positive_feedback) {
            posFeedback.add(s);
        }
        for (String s : negative_feedback) {
            negFeedback.add(s);
        }

        PriorityQueue<student> pq = new PriorityQueue<>(
            (a, b) -> a.pts == b.pts? a.id - b.id : b.pts - a.pts
        );

        int idx = 0;
        for (String r : report) {
            int pts = 0;
            for (String w : r.split(" ")) {
                if (posFeedback.contains(w)) pts += 3;
                if (negFeedback.contains(w)) pts -= 1;
            }

            pq.offer(new student(student_id[idx++], pts));
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(pq.poll().id);
        }

        return ans;
    }
}

// TC: O(f) + O(n * r * logn) + O(k * logn)
// SC: O(f + n + k)

// f -> size of feedback arrays
// n -> size report array
// r -> size of a word in report array



class Solution {
    class student {
        int id;
        int pts;
        public student(int id, int pts) {
            this.id = id;
            this.pts = pts;
        }
    }

    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Set<String> posFeedback = new HashSet<>(Arrays.asList(positive_feedback));
        Set<String> negFeedback = new HashSet<>(Arrays.asList(negative_feedback));

        List<student> list = new ArrayList<>();
        int idx = 0;

        for (String r : report) {
            int pts = 0;
            for (String w : r.split(" ")) {
                if (posFeedback.contains(w)) pts += 3;
                if (negFeedback.contains(w)) pts--;
            }

            list.add(new student(student_id[idx++], pts));
        }

        Collections.sort(list,
                (a, b) -> a.pts == b.pts? a.id - b.id : b.pts - a.pts
        );

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(list.get(i).id);
        }

        return ans;
    }
}

// TC: O(f) + O(n * r) + O(n * logn)
// SC: O(f + n + k)