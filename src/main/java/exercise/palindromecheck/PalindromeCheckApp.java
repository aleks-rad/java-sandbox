package exercise.palindromecheck;

import static utils.Utils.println;

/**
 * Напишите метод, который проверяет является ли слово палиндромом.
 */
public class PalindromeCheckApp {

    public static void main(String[] args) {
        String palindrome = "saippuakivikauppias"; // в переводе с финского "продавец мыла"
        String notPalindrome = "мадама";

        println("\"%s\" isPalindrome = %b", palindrome, isPalindrome(palindrome));
        println("\"%s\" isPalindrome = %b", notPalindrome, isPalindrome(notPalindrome));
    }

    private static boolean isPalindrome(String word) {
        char[] chars = word.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length / 2; i++) {
            if (chars[i] != chars[length - 1 - i]){
                return false;
            }
        }

        return true;
    }

}
