// Time Complexity : 0(exponential 2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        HashSet<String> set = new HashSet<>(); // to make sure we dont store redundant elements in the queue
        Queue<String> q = new LinkedList<>(); // queus for bfs
        List<String> res = new ArrayList<>();
        set.add(s);
        q.add(s);
        boolean flag = false;
        while (!q.isEmpty() && !flag) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                if (isValid(curr)) {
                    flag = true;
                    res.add(curr);
                } else if (flag == false) {
                    for (int j = 0; j < curr.length(); j++) {
                        char c = curr.charAt(j);
                        if (c >= 'a' && c <= 'z') {
                            continue;
                        }
                        String toAdd = curr.substring(0, j) + curr.substring(j + 1);
                        if (!set.contains(toAdd)) {
                            set.add(toAdd);
                            q.add(toAdd);
                        }
                    }
                }
            }
        }
        return res;
    }

    private boolean isValid(String s) {
        int len = s.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                count += 1;
            } else if (s.charAt(i) == ')') {
                count -= 1;
                if (count < 0) {
                    return false;
                }
            }
        }

        return count == 0;
    }
}

// Optimal BFS
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        HashSet<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        List<String> res = new ArrayList<>();
        set.add(s);
        q.add(s);
        boolean flag = false;
        while (!q.isEmpty()) {
            int size = q.size();
            // for (int i = 0; i < size; i++) {
            String curr = q.poll();
            if (isValid(curr)) {
                flag = true;
                res.add(curr);
            } else if (flag == false) {
                for (int j = 0; j < curr.length(); j++) {
                    char c = curr.charAt(j);
                    if (c >= 'a' && c <= 'z') {
                        continue;
                    }
                    String toAdd = curr.substring(0, j) + curr.substring(j + 1);
                    if (!set.contains(toAdd)) {
                        set.add(toAdd);
                        q.add(toAdd);
                    }
                }
            }
            // }
        }
        return res;
    }

    private boolean isValid(String s) {
        int len = s.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                count += 1;
            } else if (s.charAt(i) == ')') {
                count -= 1;
                if (count < 0) {
                    return false;
                }
            }
        }

        return count == 0;
    }
}


// DFS


class Solution {
    List<String> res;
    HashSet<String> set;
    int max;

    public List<String> removeInvalidParentheses(String s) {
        set = new HashSet<>();
        res = new ArrayList<>();
        max = 0;
        dfs(s);
        return res;
    }

    private void dfs(String s) {
        if (s.length() < max) {
            return;
        }
        if (set.contains(s)) {
            return;
        }
        set.add(s);
        if (isValid(s)) {
            if (max < s.length()) {
                max = s.length();
                res = new ArrayList<>();
                res.add(s);
            } else if (max == s.length()) {
                res.add(s);
            }
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                continue;
            }
            String child = s.substring(0, i) + s.substring(i + 1);
            dfs(child);
        }
    }

    private boolean isValid(String s) {
        int len = s.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                count += 1;
            } else if (s.charAt(i) == ')') {
                count -= 1;
                if (count < 0) {
                    return false;
                }
            }
        }

        return count == 0;
    }
}