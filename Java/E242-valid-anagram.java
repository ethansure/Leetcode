class Solution {
  public boolean isAnagram(String s, String t) {
      if (s.length() != t.length()) {
          return false;
      }
      HashMap<Character, Integer> map = new HashMap<>();
      for (Character c:s.toCharArray()) {
           if (map.containsKey(c)) {
               map.put(c, map.get(c)+1);
           } else {
               map.put(c, 1);
           }
      }
      for (Character c:t.toCharArray()) {
           if (map.containsKey(c)) {
               if (map.get(c) > 0) {
                  map.put(c, map.get(c)-1);
               } else {
                   return false;
               }
           } else {
               return false;
           }
      }
      for(Map.Entry<Character, Integer> entry : map.entrySet()) {
          if(entry.getValue() !=0){
              return false;
          }
      }
      return true;
  
  }
}