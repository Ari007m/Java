package practice;

public class Exercise {
    public static void main(String[] args) {
        int[] a ={9,7,5,2,14,3};
        Exercise ob =new Exercise();
        ob.mergesort(a,0,a.length-1);

        System.out.println("Sorted array:");

        for(int i=0;i < a.length;i++){
            System.out.print(a[i]+" ");
        }

    }
    void mergesort(int[] a, int L , int R){
        if(L < R){
            int mid = (L+R)/2;
            mergesort(a,L,mid);
            mergesort(a,mid+1,R);
            merge(a,L,mid,R);
        }

    }
    void merge(int[] a , int L, int mid , int R){
        int l = mid-L+1;
        int r= R- mid;

        int[] la = new int[l];
        int[] ra = new int[r];

        for(int i =0 ; i < l;++i){
            la[i] = a[i+L];
        }
        for(int j =0 ; j < r;++j){
            ra[j] = a[mid+1+j];
        }

        int i=0 ,j =0,k= L;
        while (i<l && j<r){
            if(la[i]<ra[j]){
                a[k]=la[i];
                i++;
            }
            else{
                a[k] = ra[j];
                j++;
            }
            k++;
        }

        while(i<l){
            a[k]=la[i];
            i++;
            k++;
        }

        while(j<r){
            a[k] = ra[j];
            j++;
            k++;
        }

    }

}
