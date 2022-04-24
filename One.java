import java.util.Arrays;//for sorting array
import java.util.Scanner;//for scanning

class One {
    void bubbleSort(int s[], int in[], int n)// function to sort sum arrray and index array
    {
        int temp = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (s[j] > s[j + 1]) {
                    temp = s[j];
                    s[j] = s[j + 1];
                    s[j + 1] = temp;
                    temp = in[j];
                    in[j] = in[j + 1];
                    in[j + 1] = temp;
                }
            }
        }
    }

    /*
     * The above function will swap the elements of index array
     * with respect to sum array
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter testcases:");
        
        int t = sc.nextInt();// number of testcases
        int[] s = new int[t];// initializing sum array
        int[] in = new int[t];// initializing index array
        int[] merge = new int[2 * t];// initializing merge array

        for (int i = 0; i < t; i++) {
            System.out.print("Enter array size:");
            int n = sc.nextInt();// Input array size
            int[] arr = new int[n];

            System.out.print("Enter the elements:");

            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }

            Arrays.sort(arr);// sorting array arr
            int k = 0;

            for (int j = 1; j < n; j++) {
                if (arr[j] != arr[k]) {
                    k++;
                    arr[k] = arr[j];
                }
            } // Removing duplicates
            int sum = 0;
            for (int j = 0; j < k + 1; j++) {
                sum += arr[j];
            } // sum of array elements
            s[i] = sum;// storing sum in new arrray
            in[i] = i + 1;// storing 1 based indexing numbers in index array
        }

        One ek = new One();
        ek.bubbleSort(s, in, t);

        // Now merging two arrays
        int j = 0, k = 0;

        for (int i = 0; i < 2 * t; i++) {
            if ((i + 1) % 2 != 0) {
                merge[i] = in[j];
                j++;
            } else if ((i + 1) % 2 == 0) {
                merge[i] = s[k];
                k++;
            }
        }

        // Displaying the final output
        System.out.println("The output is:");
        for (int i = 0; i < 2 * t; i++) {
            System.out.print(merge[i] + " ");
        }
    }
}