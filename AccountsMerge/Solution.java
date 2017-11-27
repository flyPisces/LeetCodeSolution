package AccountsMerge;

import java.util.*;

/**
 * Given a list accounts, each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.

 Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some email that is common to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.

 After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.

 Example 1:
 Input:
 accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 Explanation:
 The first and third John's are the same person as they have the common email "johnsmith@mail.com".
 The second John and Mary are different people as none of their email addresses are used by other accounts.
 We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
 ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
 Note:

 The length of accounts will be in the range [1, 1000].
 The length of accounts[i] will be in the range [1, 10].
 The length of accounts[i][j] will be in the range [1, 30].
 */
public class Solution {
    class Node {
        String email;
        String userName;
        List<Node> neighbors;

        public Node(String email, String userName) {
            this.email = email;
            this.userName = userName;
            neighbors = new ArrayList<>();
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> results = new ArrayList<>();
        Map<String, Node> map = new HashMap<>();

        for (int i = 0;i < accounts.size();++ i) {
            List<String> account = accounts.get(i);

            String userName = account.get(0);
            for (int j = 1;j < account.size();++ j) {
                String email = account.get(j);

                if (!map.containsKey(email)) {
                    Node node = new Node(email, userName);
                    map.put(email, node);
                }

                if (1 == j) continue;
                map.get(account.get(j - 1)).neighbors.add(map.get(email));
                map.get(email).neighbors.add(map.get(account.get(j - 1)));
            }
        }

        Set<String> visited = new HashSet<>();
        for (String email : map.keySet()) {
            if (visited.add(email)) {
                List<String> list = new ArrayList<>();
                list.add(email);
                dfs(map.get(email), visited, list);
                Collections.sort(list);
                list.add(0, map.get(email).userName);
                results.add(list);
            }
        }

        return results;
    }

    private void dfs(Node root, Set<String> visited, List<String> list) {
        for (Node node : root.neighbors) {
            if (visited.add(node.email)) {
                list.add(node.email);
                dfs(node, visited, list);
            }
        }
    }
}
