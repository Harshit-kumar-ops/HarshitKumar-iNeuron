public class RevString2 {

    public static void main(String[] args) {
        System.out.println(reverseWords("My name is Pedro"));
    }

        public static String reverseWords(String s) {
            String[] words = s.split(" ");
            String ss = "";
            for(String word : words){
                ss += reverseWord(word);
                ss += " ";
            }

            return String.join(" ", ss);
        }



        public static String reverseWord(String s){
            char[] letters = s.toCharArray();
            s="";
            for(int i=letters.length-1;i>=0;i--){
                s=s + letters[i];
            }
            return s;
        }

    }
	
	

