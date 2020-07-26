package examsTest.week7;


class Trie {
    private boolean isEnd = false;

    private Trie[] next;

    /** Initialize your data structure here. */
    public Trie() {
        this.isEnd = false;
        next = new Trie[26];
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0) return;

        Trie cur = this;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int n = chars[i] - 'a';
            if (cur.next[n] == null) cur.next[n] = new Trie();
            cur = cur.next[n];
        }
        cur.isEnd = true;

    }

    private Trie searchPrefix(String word) {
        Trie node = this;
        char[] words = word.toCharArray();
        for (int i = 0; i < words.length; i++) {
            node = node.next[words[i] - 'a'];
            if (node == null) return null;
        }
        return node;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = searchPrefix(prefix);
        return node != null;

    }
}