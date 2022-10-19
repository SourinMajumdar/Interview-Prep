// Link: https://leetcode.com/problems/check-if-n-and-its-double-exist/

class Solution {
    public boolean checkIfExist(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i != j && arr[i] == 2 * arr[j]) return true;
            }
        }

        return false;
    }
}

// TC: O(n ^ 2), SC: O(1)



class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for (int i : arr) {
            if (set.contains(i * 2) || (i % 2 == 0 && set.contains(i / 2))) {
                return true;
            }

            set.add(i);
        }

        return false;
    }
}

// TC: O(n), SC: O(n)


class Solution {
    public boolean checkIfExist(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length;

        for(int i = 0; i < n; i++){
            map.put(arr[i], i);
        }

        for (int i = 0; i < n; i++){
            if (map.containsKey(2 * arr[i]) && map.get(2 * arr[i]) != i){
                return true;
            }
        }

        return false;
    }
}

// TC: O(n), SC: O(n)


// BS
class Solution {
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            int target = 2 * arr[i];
            int lo = 0, hi = arr.length - 1;

            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;

                if(arr[mid] == target && mid != i) return true;
                else if (arr[mid] < target) lo = mid + 1;
                else hi = mid - 1;
            }
        }

        return false;
    }
}

// TC: O(n * logn), SC: O(1)