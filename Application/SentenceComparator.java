import java.io.*;
import java.util.*;
class SentenceComparator implements Comparator<Map.Entry<Integer, String>> {
  @Override
  public int compare(Map.Entry<Integer, String> p1, Map.Entry<Integer, String> p2) {
      if (p1.getKey() > p2.getKey()) {
          return -1;
      } else if (p1.getKey() < p2.getKey()) {
          return 1;
      } else {
          return p1.getValue().compareTo(p2.getValue());
      }
  }
}