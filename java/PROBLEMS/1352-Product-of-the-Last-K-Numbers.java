// Link: https://leetcode.com/problems/product-of-the-last-k-numbers/


// Naive approach:
class ProductOfNumbers {
    List<Integer> list;

    public ProductOfNumbers() {
        list = new ArrayList<>();
    }

    public void add(int num) {
        list.add(num);
    }

    public int getProduct(int k) {
        int n = list.size();
        int prod = 1;

        for (int i = n - k; i < n; i++) {
            prod *= list.get(i);
        }

        return prod;
    }
}

// TC: O(k), SC: O(n)


class ProductOfNumbers {
    List<Integer> list;
    int prefixProduct;

    public ProductOfNumbers() {
        list = new ArrayList<>();
        prefixProduct = 1;
    }

    public void add(int num) {
        if (num == 0) {
            list = new ArrayList<>();
            prefixProduct = 1;
        }
        else {
            prefixProduct *= num;
            list.add(prefixProduct);
        }
    }

    public int getProduct(int k) {
        int n = list.size();

        if (k == n) return prefixProduct;    // prefixProduct = list.get(n - 1)
        else if (k > n) return 0;
        else return prefixProduct / list.get(n - k - 1);
        // return (k > n) ? 0 : prefixProduct / list.get(n - k - 1);
    }
}

// TC: O(1), SC: O(n)