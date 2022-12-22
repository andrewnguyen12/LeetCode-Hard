import java.util.ArrayList;

public class NQueensII {
    public int countQueen(int count, int n, int row, ArrayList<Integer> cols, ArrayList<Integer> diagonal, ArrayList<Integer> antidiag)
    {
        for(int col = 0; col < n; col++)
        {

            if ((!diagonal.contains(row-col) && !antidiag.contains(row+col) && !cols.contains(col)))
            {
                //Assume the position is valid, start check its validity
                diagonal.add(row-col);
                antidiag.add(row+col);
                cols.add(col);

                //If at least one queen can be place in each row for every row, add 1 to count
                if (row + 1 == n)
                {
                    count += 1;
                }

                //If the top row has not been reached yet, keep moving up
                else{
                    count = countQueen(count, n, row + 1, cols, diagonal, antidiag);
                }

                //Remove all assumed position after check their validity to start a new check
                diagonal.remove(Integer.valueOf(row-col));
                antidiag.remove(Integer.valueOf(row+col));
                cols.remove(Integer.valueOf(col));

            }

            //If the current column in the first row is not valid, move to check the next one recursively
        }
        return count;
    }


    public int totalNQueens(int n) {
        int count = 0;
        ArrayList<Integer> cols = new ArrayList<Integer>();
        ArrayList<Integer> diagonal = new ArrayList<Integer>();
        ArrayList<Integer> antidiag = new ArrayList<Integer>();
        count = countQueen(0,n,0,cols, diagonal, antidiag);

        return count;
    }
}
