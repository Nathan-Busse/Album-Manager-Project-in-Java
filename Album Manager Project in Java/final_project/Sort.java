package final_project;


import java.util.Comparator;

/**
 * Implement polymorphic selection, insertion and merge sorts.
 * For each sort algorithm, Sort provides a public method to sort
 * arrays of Comparable objects as well as a second method which
 * sorts according to a Comparator object.
 */
public class Sort {

  /**
   * Return true if the list of Comparable's is sorted, false otherwise.
   */
  public static boolean isSorted(Comparable[] list) {
    return isSorted(list,
      new Comparator() {  // create equivalent comparator
        public int compare(Object obj1, Object obj2) {
          return ((Comparable) obj1).compareTo(obj2);
        }
      });
  }

  /**
   * Return true if list is sorted according to comparator, false otherwise.
   */
  public static boolean isSorted(Object[] list, Comparator comparator) {
    for (int i = 0; i < list.length-1; i++) {
      if (comparator.compare(list[i], list[i+1]) > 0) {
        return false;
      }
    }
    return true;
  }

  public static void insertionSort(Object[] list, Comparator comparator) {
    // for each element list[i], i = 1..n-1
    for (int i=1; i < list.length; i++) {
      // insert current element list[i]
      Object vi = list[i];
      // between list[i-1] and list[0]
      int j = i-1;
      while ((j >= 0) &&   (comparator.compare(vi, list[j]) < 0)) {
        list[j+1] = list[j];
        j--;
      }
      list[j+1] = vi;
    }
  }



}