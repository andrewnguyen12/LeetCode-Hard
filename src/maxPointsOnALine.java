import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class maxPointsOnALine {
    public int cross(int[] p1, int[] p2, int[] p3)
    {
        int x1 = p1[0];
        int y1 = p1[1];
        int x2 = p2[0];
        int y2 = p2[1];
        int x3 = p3[0];
        int y3 = p3[1];
        return (x2-x1)*(y3-y1) - (y2-y1)*(x3-x1);
    }

    //Method finds the coefficient of the line to match with the line triple points
    public HashMap<Integer,Integer> convertCoeffiecient(int[] p1, int[] p2)
    {
        int x1 = p1[0];
        int y1 = p1[1];
        int x2 = p2[0];
        int y2 = p2[1];
        int a = 0;
        int b = 0;
        HashMap<Integer,Integer> map1 = new HashMap<Integer,Integer>();

        if ((x1-x2) != 0)
        {
            a = (y1-y2)/(x1-x2);
            b = y1 - x1 * (y1-y2)/(x1-x2);
        }

        map1.put(a,b);
        return map1;
    }

    //Get the x value out of the point
    public int getX(int[] p1){
        int x = 0;
        x = p1[0];
        return x;
    }

    //Method to find the maximum between two values
    public int findMax (int a, int b)
    {
        int result = 0;
        if (a > b)
        {
            result = a;
        }
        else
        {
            result = b;
        }
        return result;
    }

    public int maxPoints(int[][] points) {
        int count = 2;
        int maxVal = 2 ;
        HashMap<HashMap<Integer,Integer>, Integer> record2 = new HashMap<HashMap<Integer,Integer>, Integer>();
        HashSet<int[]> record = new HashSet<int[]>();
        HashSet<Integer> listX = new HashSet<Integer>();

        for (int i = 0; i < points.length; i++)
        {
            for (int j = 0; j < points.length && j != i; j++)
            {
                for (int k = 0; k < points.length && k!= i && k!= j; k++)
                {
                    //If three points satisfies the "cross" equation, they are on the same line
                    if (cross(points[i], points[j], points[k]) == 0)
                    {
                        count += 1;
                        //If there are no lines yet, and we just found three collinear points, add three points to record
                        if (record2.size() == 0)
                        {
                            record.add(points[i]);
                            record.add(points[j]);
                            record.add(points[k]);
                            maxVal = findMax(maxVal, record.size());
                        }
                        else{
                            //Check if three points are still located on the existing line (Check the coefficient of the lines that they create)
                            if (record2.containsKey(convertCoeffiecient(points[i], points[j])) && record2.containsKey(convertCoeffiecient(points[j], points[k])) && record2.containsKey(convertCoeffiecient(points[i], points[k])))
                            {
                                if (listX.contains(getX(points[i])))
                                {
                                    record.add(points[i]);
                                    record.add(points[j]);
                                    record.add(points[k]);
                                }
                                else
                                {
                                    listX.clear();
                                    record.clear();
                                }

                                listX.add(getX(points[i]));
                                listX.add(getX(points[j]));
                                listX.add(getX(points[k]));
                                maxVal = findMax(maxVal, record.size());
                            }

                            //Refresh the record and record the max elements when finding a new line
                            else{
                                count = 2;
                                maxVal = findMax(maxVal, record.size());
                                System.out.println(maxVal);
                                record.clear();
                                record2.clear();
                            }
                        }

                        record2.merge(convertCoeffiecient(points[i], points[j]),1,Integer::sum);
                    }
                }
            }
        }

        if (count >= 3)
        {
            return maxVal;
        }
        else if (points.length <= 2)
        {
            return points.length;
        }
        return maxVal;
    }
}


