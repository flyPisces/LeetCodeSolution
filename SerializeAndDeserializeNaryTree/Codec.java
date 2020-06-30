package SerializeAndDeserializeNaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize an N-ary tree. An N-ary tree is a rooted tree in which each node has no more than N children. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that an N-ary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * For example, you may serialize the following 3-ary tree
 */
public class Codec {
    public String serialize(Node root) {
        List<String> list = new LinkedList<>();
        serializeHelper(root, list);

        return String.join(",",list);
    }

    private void serializeHelper(Node root, List<String> list) {
        if (root == null) return;
        list.add(String.valueOf(root.val));
        list.add(String.valueOf(root.children.size()));

        for (Node child : root.children) {
            serializeHelper(child, list);
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        LinkedList<String> list = new LinkedList<>(Arrays.asList(data.split(",")));

        return deserializeHelper(list);
    }

    private Node deserializeHelper(LinkedList<String> list) {
        Node root = new Node();
        root.val = Integer.parseInt(list.poll());
        root.children = new ArrayList<>();
        int size = Integer.parseInt(list.poll());

        for (int i = 0;i < size;++ i) {
            root.children.add(deserializeHelper(list));
        }

        return root;
    }
}
