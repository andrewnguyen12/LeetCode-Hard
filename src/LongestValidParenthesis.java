public class LongestValidParenthesis {
    public int findMax(int a, int b)
    {
        int result = 0;
        if (a > b)
        {
            result = a;
        }
        else{
            result = b;
        }
        return result;
    }

    public int longestValidParentheses(String s) {
        int count = 0;
        int leftCount = 0;
        int rightCount = 0;
        int maxVal = 0;

        //Iterate forward, count the number of occurences of '(' and ')'
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i)== '(')
            {
                leftCount++;
            }
            else
            {
                rightCount++;
            }

            //If leftCount == rightCount, set count = leftCount *2, reset maximum value
            if (rightCount == leftCount)
            {
                count = leftCount*2;
                maxVal = findMax(count, maxVal);
            }
            else if(rightCount > leftCount)
            {
                leftCount = 0;
                rightCount = 0;
            }
            System.out.println(maxVal);
        }
        count = 0;
        leftCount = 0;
        rightCount = 0;

        //Repeat the same procedure with backward iteration
        for (int j = s.length()- 1; j >=0;j--)
        {
            if (s.charAt(j) == ')')
            {
                rightCount++;
            }

            else
            {
                leftCount++;
            }

            if (rightCount == leftCount)
            {
                count = rightCount*2;
                maxVal = findMax(count, maxVal);
            }

            else if(rightCount < leftCount)
            {
                leftCount = 0;
                rightCount = 0;
            }
        }

        return maxVal;
    }
}
