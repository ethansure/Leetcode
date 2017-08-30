class TreeNode(object):
    
    def __init__(self, s):
        self.char = s
        self.word = False
        self.pointers = {}
        
class Trie(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TreeNode('')

    def insert(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: void
        """
        n = self.root
        for s in word:
            if s not in n.pointers:
                ntn = TreeNode(s)
                n.pointers[s] = ntn
                n = ntn
            else:
                n = n.pointers[s]
        n.word = True

    def search(self, word):
        """
        Returns if the word is in the trie.
        :type word: str
        :rtype: bool
        """
        f = self.root
        for i in range(0,len(word)):
            if word[i] not in f.pointers:
                return False
            else:
                f = f.pointers[word[i]]
        return f.word

    def startsWith(self, prefix):
        """
        Returns if there is any word in the trie that starts with the given prefix.
        :type prefix: str
        :rtype: bool
        """
        f = self.root
        for i in range(0,len(prefix)):
            if prefix[i] not in f.pointers:
                return False
            else:
                f = f.pointers[prefix[i]]
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)