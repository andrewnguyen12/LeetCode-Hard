import java.util.ArrayList;
import java.util.List;

public class FindSubstring {
    public void combineWord(String[] words, List<String> result, ArrayList<List<String>> resultList)
    {
        if(result.size() == words.length)
        {
            resultList.add(result);

        }

        for (int i = 0; i < words.length; i++)
        {

            if (result.contains(words[i]))
            {
                continue;
            }

            result.add(words[i]);
            combineWord(words, result, resultList);
            //resultList.remove(resultList.size() - 1);
        }
        return;
    }

    public List<Integer> findSubstring(String s, String[] words) {
        ArrayList<List<String>> list1 = new ArrayList<List<String>>();
        ArrayList<String> listWords = new ArrayList<String>();
        List<Integer> result = new ArrayList<Integer>();
        String newWord = "";
        int newLength = words[0].length();
        int wordLength = words.length;
        combineWord(words, new ArrayList<String>(), list1);
        System.out.println(list1);

        for (int i=0; i < words.length; i++)
        {
            for(int j = 0; j < words.length && j !=i; j++)
            {
                newWord = words[i].concat(words[j]);
                listWords.add(newWord);
                newWord = words[j].concat(words[i]);
                listWords.add(newWord);
            }
        }

        System.out.println(listWords);
        for (int i = 0; i < s.length(); i++)
        {
            if (i+newLength*wordLength < s.length())
            {
                if(listWords.contains(s.substring(i,i+newLength*wordLength)))
                {
                    result.add(i);
                }
            }

        }
        System.out.println(result);
        return result;
    }
}
