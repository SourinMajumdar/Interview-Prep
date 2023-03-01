// Link: https://leetcode.com/problems/sort-an-array/

// Using priority queue
class Solution {
    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int  i : nums) {
            pq.offer(i);
        }

        int i = 0;
        while (!pq.isEmpty()) {
            nums[i++] = pq.poll();
        }

        return nums;
    }
}

// TC: O(n * logn), SC: O(n)


// Bubble sort (TLE - 10/18 passed)
class Solution {
    public int[] sortArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean swapped = false;
            for (int j = 1; j < nums.length - i; j++) {
                if (nums[j] < nums[j-1]) {
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }

        return nums;
    }
}

// TC: O(n^2), SC: O(1)

// Selection sort (TLE - 12/18 passed)
class Solution {
    public int[] sortArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int lastIdx = nums.length - i - 1;
            int maxIdx = 0;

            for (int j = 0; j <= lastIdx; j++) {
                if (nums[j] > nums[maxIdx]) {
                    maxIdx = j;
                }
            }

            int temp = nums[lastIdx];
            nums[lastIdx] = nums[maxIdx];
            nums[maxIdx] = temp;
        }

        return nums;
    }
}

// TC: O(n^2), SC: O(1)


// Counting sort

class Solution {
    public int[] sortArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int min = 50001, max = 0;
        for (int n : nums) {
            map.put(n, 1 + map.getOrDefault(n, 0));
            max = Math.max(max, n);
            min = Math.min(min, n);
        }

        int idx = 0;
        for (int num = min; num <= max; num++) {
            while (map.getOrDefault(num, 0) > 0) {
                nums[idx++] = num;
                map.put(num, map.get(num) - 1);
            }
        }

        return nums;
    }
}

// TC: O(n + k), SC: O(n)


// Merge sort
class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length);
        return nums;
    }

    private void mergeSort(int[] arr, int s, int e) {
        if (e - s == 1) {
            return;
        }

        int mid = (s + e) / 2;
        mergeSort(arr, s, mid);
        mergeSort(arr, mid, e);
        merge(arr, s, mid, e);
    }

    private void merge(int[] arr, int s, int m, int e) {
        int[] merged = new int[e-s];
        int i = s, j = m, k = 0;
        while (i < m && j < e) {
            merged[k++] = (arr[i] < arr[j])? arr[i++] : arr[j++];
        }
        while (i < m) merged[k++] = arr[i++];
        while (j < e) merged[k++] = arr[j++];

        for (int idx = 0; idx < merged.length; idx++) {
            arr[s+idx] = merged[idx];
        }
        // System.arraycopy(merged, 0, arr, s, e - s);
    }
}

// TC: O(n * logn), SC: O(n)


// Quicksort
class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int s = lo, e = hi, m = (s + e) / 2;
        int pivot = arr[m];
        while (s <= e) {
            while (arr[s] < pivot) s++;
            while (arr[e] > pivot) e--;
            if (s <= e) {
                // swap
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++; e--;
            }
        }

        quickSort(arr, lo, e);
        quickSort(arr, s, hi);
    }
}

// TC: O(n^2), SC: O(logn)