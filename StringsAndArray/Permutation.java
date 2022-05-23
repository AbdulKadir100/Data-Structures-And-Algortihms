package StringsAndArray;

public class Permutation {

    public static void main(String[] args) {
      //  boolean r = isPermuattionOfPalindrome("Tact");
      //  System.out.println(r);
    }

   public static boolean isPermuattionOfPalindrome(String Phrase) {
        int[] table = buildCharFrequencyTable(Phrase);
        return CheckMaxOneOdd(table);
    }

    //Check that no more than one character has an odd count.
   public static   boolean CheckMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
            }
            foundOdd = true;
        }
        return true;
    }

    //Map each character to a number. a->0,b->1.c->2 etc.
    static int getCharNumber(Character c) {
        int val = 0;
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }

    //Count how many time each char appears.
   public static int[] buildCharFrequencyTable(String Phrase){
        int[] table = new int[Character.getNumericValue('z') -
                Character.getNumericValue('a')+1];
        for (char c: Phrase.toCharArray()){
            int x = getCharNumber(c);
            if (x != -1)
                table[x]++;
        }
    return table;
    }

   


}
