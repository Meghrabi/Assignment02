import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class Assignment02 {

       public  static int minimumDistance(List<Integer> a)
        {

            // Create a HashMap to
            // store (key, values) pair.
            HashMap<Integer, Integer> hmap
                    = new HashMap<>();
            int minDistance = Integer.MAX_VALUE;

            // Initialize previousIndex
            // and currentIndex as 0
            int previousIndex = 0, currentIndex = 0;

            // Traverse the array and
            // find the minimum distance
            // between the same elements with map
            for (int i = 0; i < a.size(); i++) {

                if (hmap.containsKey(a.get(i))) {
                    currentIndex = i;

                    // Fetch the previous index from map.
                    previousIndex = hmap.get(a.get(i));

                    // Find the minimum distance.
                    minDistance
                            = Math.min(
                            (currentIndex - previousIndex),
                            minDistance);
                }

                // Update the map.
                hmap.put(a.get(i), i);
            }

            // return minimum distance,
            // if no such elements found, return -1
            return (
                    minDistance == Integer.MAX_VALUE
                            ? -1
                            : minDistance);
        }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("Assignment02-1.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("out.txt"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Assignment02.minimumDistance(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}















