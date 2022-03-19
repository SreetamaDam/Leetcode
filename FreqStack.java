/*
	Design a stack-like data structure to push elements to the stack and pop the most frequent element from the stack.

	Implement the FreqStack class:

	FreqStack() constructs an empty frequency stack.
	void push(int val) pushes an integer val onto the top of the stack.
	int pop() removes and returns the most frequent element in the stack.
	If there is a tie for the most frequent element, the element closest to the stack's top is removed and returned.
 
*/


class FreqStack {
    
    //Approach : Two maps, one to store keys and frequency; another to store frequency and stack of keys.
    //A variable to keep track of maxFreq

    HashMap<Integer, Integer> frequencyMap;
    HashMap<Integer, LinkedList<Integer>> stackMap; //LinkedList to retain the order of insertion
    int maxFreq;
    
    public FreqStack() {
        frequencyMap = new HashMap();
        stackMap = new HashMap();
        maxFreq = 0;
    }
    
    public void push(int val) {
        
        //Get frequency of the key from frequencyMap, increase frequency, put into map with new frequency
        int currentFrequency = frequencyMap.getOrDefault(val, 0);
        currentFrequency++;
        frequencyMap.put(val, currentFrequency);
        
        //update maximum frequency
        maxFreq = Math.max(maxFreq, currentFrequency);
        
        //insert given key into stack where frequency matches with new Frequency of the key
        if (!stackMap.containsKey(currentFrequency))
            stackMap.put(currentFrequency, new LinkedList<Integer>());
        stackMap.get(currentFrequency).addFirst(val);
    }
    
    public int pop() {
        
        //Get mostFrequent key from frequencyMap
        int mostFrequentKey = stackMap.get(maxFreq).removeFirst();
        
        //update max frequency
        if (stackMap.get(maxFreq).size() == 0)
            maxFreq--;
        
        //update frequency of most frequent key in frequencyMap
        int currentFrequency = frequencyMap.get(mostFrequentKey);
        currentFrequency--;
        frequencyMap.put(mostFrequentKey, currentFrequency);
        
        return mostFrequentKey;
    }
}
