import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindSubstring {
    public List<Integer> findSubstring(String s, String[] words) {
        int count = 0;
        HashMap<String,Integer> map = new HashMap<String,Integer>();

        List<Integer> result = new ArrayList<Integer>();
        int newLength = words[0].length();
        int wordLength = words.length;

        //Create a dictionary to store the occurrence of words
        for (String word1: words)
        {
            map.merge(word1,1,Integer::sum);
        }

        System.out.println(map);

        for (int i = 0; i <= s.length() - newLength*wordLength; i++)
        {
            count = 0;
            HashMap<String,Integer> map2 = new HashMap<String,Integer>(map);
            //Check the word for every j leap
            for (int j = i; j < i + newLength*wordLength; j+=newLength)
            {
                //If word is found in j leap, substract its value by 1 in the dictionary
                if (map2.getOrDefault(s.substring(j,j+newLength), 0) != 0)
                {
                    int currentCount = map2.get(s.substring(j,j+newLength)) - 1;
                    map2.put(s.substring(j,j+newLength), currentCount);
                    count += 1;
                }
            }

            if (count == words.length)
            {
                result.add(i);
            }
        }

        return result;
    }
}
