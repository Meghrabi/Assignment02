import java.io.*;
import java.util.*;


public class Assignment02 {

    public  static int minimumDistances (List<Integer> a)
        {
            HashMap<Integer, Integer> hmap = new HashMap<>();

            int minDist = Integer.MAX_VALUE;

            int prevIndex = 0, currentIndex = 0;

            // find the minimum distance

            for (int i = 0; i < a.size(); i++) {

                if (hmap.containsKey(a.get(i))) {
                    currentIndex = i;
                    prevIndex = hmap.get(a.get(i));
                    // Find the minimum distance.
                    minDist = Math.min((currentIndex - prevIndex), minDist);
                }

                hmap.put(a.get(i), i);
            }

            //  return minimum distance
            return (minDist == Integer.MAX_VALUE ? -1 : minDist);
        }


    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("Assignment02-1.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Resultat02.txt"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] a_tmp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(a_tmp[i]);
            a.add(val);
        }

        int result = Assignment02.minimumDistances(a);

        System.out.println("The minimum distance is  "+result);

        bufferedWriter.write( String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}