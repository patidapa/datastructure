package string;

public class SubSequence {
    public static void main(String[] args) {
        String str = "abcde";
        String seq = "ace";
        int i = 0,j=0;
        while(i<str.length() && j<seq.length()){
            if(str.charAt(i)==seq.charAt(j)){
                j++;
            }
            i++;
        }
        if(j==seq.length())
        System.out.print("Given substring is sequence ");
        else{
            System.out.print("Given substring is not sequence ");
        }

    }
}
