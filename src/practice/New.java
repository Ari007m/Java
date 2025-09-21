package practice;

public class New {
    public static void main(String[] args) {
        int[] a = {1,1,5,8,5,7,7};
        int b = a.length;

        for(int i = 0 ; i < b;i++){
            boolean is = true;
            for(int j =0 ; j < b;j++){
                if(i != j && a[i] == a[j]){
                    is = false;
                    break;
                }

            }
            if(is){
                System.out.println(a[i]);
            }
        }
    }
}
