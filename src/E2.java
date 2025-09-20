public class E2 {
    public static void main(String[] args) {
        int[] a = {9,7,5,2,14,3,1};
        quickSort(a,0,a.length-1);
        for(int i  = 0;i < a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
    public static void quickSort(int[] a, int s, int e){
        if(e<=s) return;

        int p = partition(a,s,e);
        quickSort(a,s,p-1);
        quickSort(a,p,e);
    }
    public static int partition(int[] a,int s, int e){
        int p = a[e];
        int i = s-1;
        for(int j = s ; j < e;j++ ){
            if(a[j]<p){
                i++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        i++;
        int t = a[i];
        a[i] = a[e];
        a[e] = t;
        return i;
    }
}
 