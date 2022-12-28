import java.util.*;
import java.util.stream.Collectors;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int minVal = 100000;
        int left = 0;
        int right = 0;
        String result = "";
        String result2 = "";
        int currentLength = 0;
        int count = 0;
        int count2 = 0;
        int countVal = 0;
        int contained = 0;
        int requiredChar = 0;
        int[] info = new int[3];
        HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
        if (s.equals(t))
        {
            return s;
        }
        if (t.length() == 1)
        {
            for (int i = 0; i < s.length(); i++)
            {
                result += s.charAt(i);
                currentLength++;
                if (s.charAt(i) == t.charAt(0))
                {
                    if (minVal > currentLength)
                    {
                        result2 = result;
                        minVal = Math.min(currentLength, minVal);
                        result = "";
                    }

                    currentLength = 0;
                }
                else {
                    result = "";
                    currentLength = 0;
                }
            }
            return result2;
        }

        for(int i = 0; i < t.length(); i++)
        {
            count2 = map1.getOrDefault(t.charAt(i), 0) + 1;
            map1.put(t.charAt(i), count2);
            countVal++;
        }
        requiredChar = map1.size();

        HashMap<Character, Integer> copy = new HashMap<Character, Integer>(map1);

        info[0] = Integer.MAX_VALUE;

        while(right < s.length())
        {
            if (map1.containsKey(s.charAt(right)))
            {
                count = map2.getOrDefault(s.charAt(right),0) + 1;
                map2.put(s.charAt(right), count);
            }

            if (map1.containsKey(s.charAt(right)) && map2.get(s.charAt(right)).intValue() == map1.get(s.charAt(right)).intValue()){
                contained++;
            }

            if (requiredChar <= contained)
            {
                if (info[0] > right-left+1)
                {
                    info[0] = Math.min(info[0], right-left+1);
                    info[1] = left;
                    info[2] = right;
                }
                while (left < right)
                {
                    if (contained == requiredChar)
                    {
                        if (info[0] > right-left+1)
                        {
                            info[0] = Math.min(info[0], right-left+1);
                            info[1] = left;
                            info[2] = right;
                        }

                    }

                    if (map2.getOrDefault(s.charAt(left),0) > 0)
                    {
                        count = map2.getOrDefault(s.charAt(left),0) - 1;
                        map2.put(s.charAt(left), count);
                    }

                    if (map1.containsKey(s.charAt(left)) && map2.get(s.charAt(left)).intValue() < map1.get(s.charAt(left)).intValue())
                    {
                        contained--;
                        left++;
                        break;
                    }

                    left++;
                }

            }
            right++;
        }

        if (info[1] == 0 && info[2] == 0)
        {return "";}

        for (int i = info[1]; i < info[2] + 1; i++)
        {
            result2 += s.charAt(i);
        }

        return result2;
    }

}
