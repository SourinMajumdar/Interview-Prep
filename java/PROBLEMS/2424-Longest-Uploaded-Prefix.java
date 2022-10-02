// Link: https://leetcode.com/problems/longest-uploaded-prefix/
// Solution: https://www.youtube.com/watch?v=4F5GxWdPfks

// BiWeekly 88, 1 Oct 2022
// Q2

class LUPrefix {
    Set<Integer> set;
    int maxConsecutiveVideo = 0;

    public LUPrefix(int n) {
        set = new HashSet<>();
    }

    public void upload(int video) {
        set.add(video);
        while (set.contains(maxConsecutiveVideo + 1)) {
            maxConsecutiveVideo++;
        }
    }

    public int longest() {
        return maxConsecutiveVideo;
    }
}

/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix obj = new LUPrefix(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */



// TC: O(1), SC: O(n)