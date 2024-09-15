import java.io.*;
import java.util.*;
class Trie {
  Node root;

  public Trie() {
      root = new Node();
  }

  public void insert(String word, int times) {
      Node node = root;
      for (char c : word.toCharArray()) {
          int index = Helper.char2int(c);
          if (!node.contains(index)) {
              node.put(index, new Node());
          }
          node = node.get(index);
      }
      node.updateFrequency(times);
  }

  public void dfs(Node node, String currString, List<Map.Entry<Integer, String>> possibleSentences) {
      if (node.frequency != 0) {
          possibleSentences.add(new AbstractMap.SimpleEntry<>(node.frequency, currString));
      }
      for (int i = 0; i < 256; i++) {
          if (node.contains(i)) {
              Node nextNode = node.get(i);
              char nextChar = Helper.int2char(i);
              String nextString = currString + nextChar;
              dfs(nextNode, nextString, possibleSentences);
          }
      }
  }

  // Deletion of nodes to prevent memory leaks
  public void deleteNodes(Node node) {
      if (node == null) {
          return;
      }
      for (int i = 0; i < 256; i++) {
          if (node.contains(i)) {
              deleteNodes(node.get(i));
          }
      }
  }

  // Finalizer for the class
  @Override
  protected void finalize() throws Throwable {
      deleteNodes(root);
      super.finalize();
  }
}