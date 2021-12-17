

public class WeeklyFunctions {

    public static void main(String args[]) {


        System.out.println(almostPalindrome("abcdcbg"));
        System.out.println(almostPalindrome("abccia"));
        System.out.println(almostPalindrome("abcdaaa"));
        System.out.println(almostPalindrome("1234312"));



        System.out.println(waysToClimb(1));
        System.out.println(waysToClimb(2));
        System.out.println(waysToClimb(3));
        System.out.println(waysToClimb(4));
        System.out.println(waysToClimb(5));
        System.out.println(waysToClimb(6));
        System.out.println(waysToClimb(7));




    }


    public static boolean almostPalindrome(String stringIn) {
        int stringLength = stringIn.length();

        int numMismatches = 0;

        for(int i = 0; i < (stringLength)/2; i++) {


            if(stringIn.charAt(i) != stringIn.charAt(stringLength-1-i)) {
                numMismatches++;
                if(numMismatches > 1) {
                    i= stringLength;
                }
            }
        }

        if(numMismatches > 1) {
            return false;
        } else {
            return true;
        }
    }


    public static long waysToClimb(int height) {

        System.out.println("HEIGHT:" + height);

        int onesRemaining = height;
        int twosPresent = 0;

        long possiblePaths = 0;

        while(onesRemaining >= 0) {



            //How many ways can we uniquely order the twos and ones - combinations!
            int a = onesRemaining + twosPresent;
            int b = twosPresent;
            int ab = onesRemaining;

            long newCombinations = factorial(a)/(factorial(b)*factorial(ab));

            System.out.println(twosPresent +" " + newCombinations);

            possiblePaths += newCombinations;

            onesRemaining += -2;
            twosPresent++;

        }

        return possiblePaths;
    }

    public static long factorial(int i) {
        if(i > 1) {
            return factorial(i-1)*i;
        } else {
            return 1;
        }
    }


}


