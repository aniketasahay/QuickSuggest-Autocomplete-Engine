
class Node {
  Node[] links = new Node[256];
  int frequency;

  public Node() {
      frequency = 0;
      for (int i = 0; i < 256; i++) {
          links[i] = null;
      }
  }

  public boolean contains(int index) {
      return links[index] != null;
  }

  public void put(int index, Node node) {
      links[index] = node;
  }

  public Node get(int index) {
      return links[index];
  }

  public void updateFrequency(int times) {
      frequency += times;
  }
}