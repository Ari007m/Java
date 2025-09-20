
public class Check {
    public static void main(String[] args) {
        int[] a = {2,7,5,4};
        int[] b = {6,1,8,9,7};
        System.out.println(check(a,b));

    }
    public static boolean check(int[] a, int[] b){



         for (int i = 0 ;i<a.length ;i++){
            for (int j =0 ; j<b.length;j++){
                if(a[i] == b[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
