package finalproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry; // You may need it to implement fastSort

public class Sorting {

    /*
     * This method takes as input an HashMap with values that are Comparable.
     * It returns an ArrayList containing all the keys from the map, ordered
     * in descending order based on the values they mapped to.
     *
     * The time complexity for this method is O(n^2) as it uses bubble sort, where n is the number
     * of pairs in the map.
     */
    public static <K, V extends Comparable> ArrayList<K> slowSort (HashMap<K, V> results) {
        ArrayList<K> sortedUrls = new ArrayList<K>();
        sortedUrls.addAll(results.keySet());	//Start with unsorted list of urls

        int N = sortedUrls.size();
        for(int i=0; i<N-1; i++){
            for(int j=0; j<N-i-1; j++){
                if(results.get(sortedUrls.get(j)).compareTo(results.get(sortedUrls.get(j+1))) <0){
                    K temp = sortedUrls.get(j);
                    sortedUrls.set(j, sortedUrls.get(j+1));
                    sortedUrls.set(j+1, temp);
                }
            }
        }
        return sortedUrls;
    }


    /*
     * This method takes as input an HashMap with values that are Comparable.
     * It returns an ArrayList containing all the keys from the map, ordered
     * in descending order based on the values they mapped to.
     *
     * The time complexity for this method is O(n*log(n)), where n is the number
     * of pairs in the map.
     */


    private static <K, V extends Comparable> void quicksort(HashMap<K, V> results,ArrayList<K> sortedUrls, int left, int right){

        if (left>=right){
            return;
        }

        V pivot = results.get(sortedUrls.get((left + right)/2));
        int i = partition(results,sortedUrls,left,right,pivot);
        quicksort(results,sortedUrls,left,i-1);
        quicksort(results,sortedUrls,i,right);
    }





    private static <K, V extends Comparable> int partition(HashMap<K, V> results,ArrayList<K> sortedUrls, int left, int right,V pivot){
        while(left<=right){
            while(results.get(sortedUrls.get(right)).compareTo(pivot) <0){
                right--;
            }
            while(results.get(sortedUrls.get(left)).compareTo(pivot)>0){
                left++;
            }

            if (left <= right){
                K temp = sortedUrls.get(right);
                sortedUrls.set(right, sortedUrls.get(left));
                sortedUrls.set(left, temp);
                left++;
                right--;
            }
        }
        return left;
    }


    public static <K, V extends Comparable> ArrayList<K> fastSort(HashMap<K, V> results) {

        ArrayList<K> sortedUrls = new ArrayList<K>();
        sortedUrls.addAll(results.keySet());

        quicksort(results,sortedUrls,0,sortedUrls.size()-1);
        return sortedUrls;

    }








}
package finalproject;

        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.Map.Entry; // You may need it to implement fastSort

public class Sorting {

    /*
     * This method takes as input an HashMap with values that are Comparable.
     * It returns an ArrayList containing all the keys from the map, ordered
     * in descending order based on the values they mapped to.
     *
     * The time complexity for this method is O(n^2) as it uses bubble sort, where n is the number
     * of pairs in the map.
     */
    public static <K, V extends Comparable> ArrayList<K> slowSort (HashMap<K, V> results) {
        ArrayList<K> sortedUrls = new ArrayList<K>();
        sortedUrls.addAll(results.keySet());	//Start with unsorted list of urls

        int N = sortedUrls.size();
        for(int i=0; i<N-1; i++){
            for(int j=0; j<N-i-1; j++){
                if(results.get(sortedUrls.get(j)).compareTo(results.get(sortedUrls.get(j+1))) <0){
                    K temp = sortedUrls.get(j);
                    sortedUrls.set(j, sortedUrls.get(j+1));
                    sortedUrls.set(j+1, temp);
                }
            }
        }
        return sortedUrls;
    }


    /*
     * This method takes as input an HashMap with values that are Comparable.
     * It returns an ArrayList containing all the keys from the map, ordered
     * in descending order based on the values they mapped to.
     *
     * The time complexity for this method is O(n*log(n)), where n is the number
     * of pairs in the map.
     */


    private static <K, V extends Comparable> void quicksort(HashMap<K, V> results,ArrayList<K> sortedUrls, int left, int right){

        if (left>=right){
            return;
        }

        V pivot = results.get(sortedUrls.get((left + right)/2));
        int i = partition(results,sortedUrls,left,right,pivot);
        quicksort(results,sortedUrls,left,i-1);
        quicksort(results,sortedUrls,i,right);
    }





    private static <K, V extends Comparable> int partition(HashMap<K, V> results,ArrayList<K> sortedUrls, int left, int right,V pivot){
        while(left<=right){
            while(results.get(sortedUrls.get(right)).compareTo(pivot) <0){
                right--;
            }
            while(results.get(sortedUrls.get(left)).compareTo(pivot)>0){
                left++;
            }

            if (left <= right){
                K temp = sortedUrls.get(right);
                sortedUrls.set(right, sortedUrls.get(left));
                sortedUrls.set(left, temp);
                left++;
                right--;
            }
        }
        return left;
    }


    public static <K, V extends Comparable> ArrayList<K> fastSort(HashMap<K, V> results) {

        ArrayList<K> sortedUrls = new ArrayList<K>();
        sortedUrls.addAll(results.keySet());

        quicksort(results,sortedUrls,0,sortedUrls.size()-1);
        return sortedUrls;

    }








}
