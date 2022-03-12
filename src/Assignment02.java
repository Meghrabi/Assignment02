import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class Assignment02 {

       public  static int minimumDistances (Integer [] a)
        {
            HashMap<Integer, Integer> hmap = new HashMap<>();

            int minDistance = Integer.MAX_VALUE;

            int prevIndex = 0, currentIndex = 0;

            // find the minimum distance

            for (int i = 0; i < a.length; i++) {

                if (hmap.containsKey(a[i])) {
                    currentIndex = i;

                    // Fetch the previous index from map.
                    prevIndex = hmap.get(a[i]);

                    // Find the minimum distance.
                    minDistance = Math.min((currentIndex - prevIndex), minDistance);
                }

                hmap.put(a[i], i);
            }

            // return minimum distance, if no such elements found, return -1
            return (
                    minDistance == Integer.MAX_VALUE ? -1 : minDistance);
        }



    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("Assignment02-1.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Resultat02.txt"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List <Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
        Integer[] array = a.toArray(new Integer[a.size()]);

        int result = Assignment02.minimumDistances ( array);
        System.out.println("The minimum distance is  "+result);

        bufferedWriter.write( String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}