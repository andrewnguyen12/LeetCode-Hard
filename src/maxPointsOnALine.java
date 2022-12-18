import java.util.ArrayList;
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

    public int maxPoints(int[][] points) {
        int count = 2;
        List<int[]> record = new ArrayList<int[]>();

        for (int i = 0; i < points.length; i++)
        {
            for (int j = 0; j < points.length; j++)
            {
                if (j != i)
                {
                    if (j == i-1 && i < points.length - 1)
                    {
                        if (cross(points[j],points[i],points[i+1]) == 0)
                        {
                            record.add(points[j]);
                            record.add(points[i]);
                            record.add(points[i+1]);
                            count += 1;
                        }
                    }
                    else if (j < i - 1 && j > 0)
                    {
                        if (cross(points[j],points[j+1],points[i]) == 0)
                        {
                            record.add(points[j]);
                            record.add(points[i]);
                            record.add(points[i+1]);
                            count += 1;
                        }
                    }
                    else if(j> i && j < points.length - 1)
                    {
                        if (cross(points[i],points[j],points[j+1]) == 0)
                        {
                            record.add(points[j]);
                            record.add(points[i]);
                            record.add(points[i+1]);
                            count += 1;

                        }
                    }
                    if (count == points.length)
                    {
                        return count;
                    }

                }

            }
        }
        System.out.println(record);
        if (count >= 3)
        {
            return count;
        }
        else if (points.length < 2)
        {
            return points.length;
        }
        return 2;
    }

    public static void main(String[] args) {
        maxPointsOnALine maxPoint = new maxPointsOnALine();
        maxPoint.maxPoints([[2,3],[3,2]]);
    }


}


