public class E {
    public static void main(String[] args) {
        int[] a = {7,2,5,9,6,4,8};
        mergesort(a);
        for(int i =0 ; i < a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
    public static void mergesort(int[] a){

        int e = a.length;
        if(e<=1) return;

        int m = e/2;
        int[] la = new int[m];
        int[] ra = new int[e-m];

        int i =0 ;
        int j =0 ;
        for(; i < e;i++){
            if(i < m){
                la[i] = a[i];
            }
            else {
                ra[j] = a[i];
                j++;
            }
        }
        mergesort(la);
        mergesort(ra);

        merged(la,ra,a);

    }
    public static void merged(int[] la,int[] ra,int[] a){

        int ls =a.length/2;
        int rs = a.length - ls;

        int i=0,j=0,k=0;
        while(i<ls && j< rs){
            if(la[i] < ra[j]){
                a[k] = la[i];
                i++;
            }
            else{
                a[k] = ra[j];
                j++;
            }
            k++;
        }

        while (i< ls){
            a[k] = la[i];
            i++;
            k++;
        }
        while (j < rs){
            a[k] = ra[j];
            j++;
            k++;
        }
    }
}
