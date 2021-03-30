class Solution{
    public static void main(String[] args) {
        int[] a = {3, 5, 9};
        System.out.println(shiftingLetters("abc", a));
    }

    public static String shiftingLetters(String S, int[] shifts)
    {
        int totalShifts = 0;
        char[] chars = S.toCharArray();

        for(int shift : shifts) totalShifts+=shift;

        for(int i=0; i<S.length(); i++)
        {
            System.out.println(totalShifts);
            chars[i] = shift(S.charAt(i), totalShifts);
            totalShifts -= shifts[i];

        }
        return String.valueOf(chars);
    }

    public static char shift(char character, int shiftVal)
    {
        int AASCi = character;
        shiftVal %= 26;
        int result = AASCi + shiftVal;
        if(result > 122) result = (AASCi + shiftVal) % 122 + 96;
        return (char) result;
    }



}