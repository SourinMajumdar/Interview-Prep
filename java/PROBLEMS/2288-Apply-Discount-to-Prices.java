// Link: https://leetcode.com/problems/apply-discount-to-prices/description/

class Solution {
    public String discountPrices(String sentence, int discount) {
        // We split sentences to an array of individual strings
        String[] strArr = sentence.split(" ");
        // java.text.DecimalFormat class is used for formatting numbers
        // as per customized format and as per locale.
        DecimalFormat df = new DecimalFormat("0.00");

        for (int idx = 0; idx < strArr.length; idx++) {
            String s = strArr[idx];
            boolean dollarSignAtFirst = s.charAt(0) == '$';     // checks if first character is '$'
            // if first char is not $ or if it is but string size is 1
            // there is no price to alter so move on
            if (!dollarSignAtFirst || s.length() == 1) {
                continue;
            }

            boolean isPriceValid = true;    // would tell if our price is valid after '$' sign
            for (int i = 1; i < s.length(); i++) {
                if (!Character.isDigit(s.charAt(i))) {  // if character is not a digit
                    isPriceValid = false;               // price is not valid
                    break;                              // break out since there is no need to iterate further
                }
            }

            // Now, when we have '$' sign at 0-th index and also valid price after '$' sign
            // we will perform our alterations
            if (dollarSignAtFirst && isPriceValid) {
                long price = Long.parseLong(s.substring(1, s.length()));    // substring after $ converted to long
                double newPrice = price - (price * discount / 100.0);       // new price after discount
                strArr[idx] = "$" + String.valueOf(df.format(newPrice));    // putting the new price as a string back to the array at the respective index
            }
        }

        // we need form the string back from the split array
        return String.join(" ", strArr);
    }
}

// TC: O(m) + O(n * 10) + O(m) => O(m + n)
// m be the number of characters in sentence
// string split() and join() would cost an O(m)
// n be the number of individual strings in split array
// n * 10 because if first character is $, a loop runs to check if it is a valid price, at max it can be 10 digits.
// otherwise we continue without looping on a string if not a potential price

// SC: O(n)