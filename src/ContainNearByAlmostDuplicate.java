public class ContainNearByAlmostDuplicate {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        boolean result = false;

        if (nums.length > indexDiff)
        {
            for (int i = 0; i < nums.length-1; i++)
            {
                for (int j = i+1; j <= i+indexDiff && j < nums.length;j++)
                {
                    if ((Math.abs(nums[i] - nums[j]) <= valueDiff)){
                        result = true;
                        return result;
                    }
                }
            }
        }
        else
        {
            for (int i = 0; i < nums.length; i++)
            {
                //System.out.println(i);
                for (int j = i+1; j < nums.length;j++)
                {
                    //System.out.println(j);
                    //System.out.println(Math.abs(nums[i] - nums[j]));
                    if ((Math.abs(nums[i] - nums[j]) <= valueDiff)){
                        result = true;
                        return result;
                    }
                }
            }
        }

        return result;
    }
}
