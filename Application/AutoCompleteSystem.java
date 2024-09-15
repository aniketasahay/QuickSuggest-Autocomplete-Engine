import java.io.*;
import java.util.*;

public class AutoCompleteSystem {
     String currString;
    Trie t;
    Node currNode;

    public AutoCompleteSystem(List<String> sentences, List<Integer> times) {
        currString = "";
        t = new Trie();
        currNode = t.root;

        for (int i = 0; i < sentences.size(); i++) {
            t.insert(sentences.get(i), times.get(i));
        }
    }

    public List<String> input(char c) {
        List<Map.Entry<Integer, String>> possibleSentences = new ArrayList<>();

        if (c == '#') {
            t.insert(currString, 1);
            currString = "";
            currNode = t.root;
            return new ArrayList<>();
        }

        currString += c;
        if (currNode == null || !currNode.contains(Helper.char2int(c))) {
            currNode = null;
            return new ArrayList<>();
        }

        currNode = currNode.get(Helper.char2int(c));
        t.dfs(currNode, currString, possibleSentences);

        return getTop3Sentences(possibleSentences);
    }

    private List<String> getTop3Sentences(List<Map.Entry<Integer, String>> possibleSentences) {
        possibleSentences.sort(new SentenceComparator());

        List<String> ans = new ArrayList<>();
        int size = possibleSentences.size();
        for (int i = 0; i < 3 && i < size; i++) {
            ans.add(possibleSentences.get(i).getValue());
        }

        return ans;
    }
}
