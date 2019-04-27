package legion.util;

public class test {
    public static void main(String args[])
    {
        String a = "abcdefgh";
        String b =sortstring(a);
        System.out.print(b);
    }

    public  static String sortstring(String a)
    {
        int l = a.length();
        String b="";
        for(int i=1; i<=l; i++)
        {
            System.out.print(a.substring(l-i,l-i+1));
        }
        return b;
    }
}
