// Link: https://leetcode.com/problems/single-threaded-cpu/description/


class Solution {
    class Task {
        int et, pt, index;
        Task(int et, int pt, int index) {
            this.et = et;
            this.pt = pt;
            this.index = index;
        }
    }

    public int[] getOrder(int[][] tasks) {
        List<Task> task = new ArrayList<>();
        for (int i = 0; i < tasks.length; i++){
            task.add(new Task(tasks[i][0] , tasks[i][1] , i));
        }
        Collections.sort(task , (a , b)-> a.et - b.et);

        PriorityQueue<Task> pq = new PriorityQueue<>(
            (a , b) -> (a.pt == b.pt)? (a.index - b.index) : (a.pt -  b.pt)
        );

        int[] ans = new int[tasks.length];
        int time = 0, i = 0, k = 0;

        while (i < tasks.length) {
            while (i < tasks.length && task.get(i).et <= time){
                pq.add(task.get(i++));
            }
            if (pq.isEmpty()) {
                time = task.get(i).et;
            } else {
                Task t = pq.poll();
                ans[k++] = t.index;
                time += t.pt;
            }
        }

        while (!pq.isEmpty()) {
            ans[k++] = pq.poll().index;
        }

        return ans;
    }
}

// TC: O(n * logn), SC: O(n)