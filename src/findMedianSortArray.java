import java.util.ArrayList;
import java.util.Collections;

public class findMedianSortArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double res = 0;

        int newLength = nums1.length + nums2.length;
        ArrayList<Integer> result = new ArrayList<Integer>();
        while (result.size() < newLength)
        {
            for (int i = 0; i < nums1.length; i++)
            {
                result.add(nums1[i]);
            }
            for (int j = 0; j < nums2.length; j++)
            {
                result.add(nums2[j]);
            }
        }

        //Sort the combined array
        Collections.sort(result);

        //The median is the middle value when newLength is odd
        for (int i = 0; i < newLength; i++)
        {
            res += result.get(i);
        }
        if (newLength % 2 != 0){
            res = result.get(newLength/2);
            //res = res / newLength;
        }

        //The median is the average of two middle values when newLength is even
        else{
            //System.out.println(result.get(newLength/2));
            res = (result.get(newLength/2-1) + result.get(newLength/2)) / 2.0;
        }

        System.out.println(result);
        //System.out.println(5/2);
        return res;
    }
}
