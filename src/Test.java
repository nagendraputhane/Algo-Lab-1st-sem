import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.*;
import java.lang.Math;

public class Test {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Nagendra\\Desktop\\JavaTutorial\\Lab\\test.txt");
        long start = System.nanoTime();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String txt;
            txt = br.readLine();
            String pat;
            pat = br.readLine();
            int n = txt.length();
            int m = pat.length();
            int pathash = 0, texthash = 0;
            for (int i = 0; i < m; i++) {
                pathash += pat.charAt(i) * Math.pow(3, i);
                texthash += txt.charAt(i) * Math.pow(3, i);

            }
            int j;
            for (int i = 0; i < n-m; i++) {
                if(pathash == texthash) {
                    System.out.println(pathash);
                    for (j = 0; j < m; j++) {
                        if (txt.charAt(i+j) != pat.charAt(j)) {
                            break;
                        }
                    }
                    if (j == m) {
                        System.out.println("pattern found at " + i);
                    }
                }
                if ( i < n - m) {
                    texthash = (int) ((texthash - txt.charAt(i))/3 + txt.charAt(i+m) * Math.pow(3, 3));
                    System.out.println(pathash + " " + texthash);
                }
            }
//            for (int i = 0; i < n; i++) {
//                int j = 0;
//                for (j = 0; j < m; j++) {
//                    if (txt.charAt(i+j) != pat.charAt(j)) {
//                        break;
//                    }
//                }
//                if (j == m) {
//                    System.out.println("pattern found");
//                }
//            }
//            String split[] = st.split(" ");
//            int[] arr1 = new int[split.length];
//            for (int i = 0; i < split.length ; i++) {
//                arr1[i] = Integer.parseInt(split[i]);
//            }
//            st = br.readLine();
//            split = st.split(" ");
//            int[] arr2 = new int[split.length];
//            for (int i = 0; i < split.length ; i++) {
//                arr2[i] = Integer.parseInt(split[i]);
//            }


        } catch (Exception e) {
            System.out.println("No file found");
        }
        long end = System.nanoTime();
        //System.out.println(start - end);
    }
    public static void countsort(int arr[], int n, int exp) {
        int output[] = new int[n];
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);
        for (i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;//count[(arr[i]/exp) % 10]++;
        }
        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];//count[i] += count[i-1];
        }
        for (i = n-1; i >= 0; i--) {
            output[count[(arr[i]/exp)%10] - 1] = arr[i];

            count[(arr[i]/exp) % 10] --;
        }
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }
}
