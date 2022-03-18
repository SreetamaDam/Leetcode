/*
	Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

	Example 1:

	Input: s = "bcabc"
	Output: "abc"
	Example 2:

	Input: s = "cbacdcbc"
	Output: "acdb"
*/


class RemoveDuplicateCharacters {
    public String removeDuplicateLetters(String s) {
        //Track last index
        //Push into stack, if stack is empty 
        //Push into stack if character is smaller than stack top , but before that, pop the top one if that is the last index of the elemnt in given string
        //continue upto last chararter of string
        //now the stack will contain the lexicographically smallest substring with unique characters
        //pop out all element of stack and return them in reverse order
        
        int[] lastIndex = new int[26];
        int n = s.length();
        Stack<Integer> stack = new Stack();
        boolean[] visited = new boolean[26];
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++)
            lastIndex[s.charAt(i) - 'a'] = i;
        
        for ( int i = 0; i < n; i++) {
            int ch = s.charAt(i) - 'a';
            if (visited[ch])
                continue;
            while (!stack.isEmpty() && stack.peek() > ch && i < lastIndex[stack.peek()]) {
                visited[stack.pop()] = false;
            }
            stack.push(ch);
            visited[ch] = true;
        }
        
        while (!stack.isEmpty()) {
            sb.append((char)(stack.pop() + 'a'));
        }
        
        return sb.reverse().toString();
        
    }
}