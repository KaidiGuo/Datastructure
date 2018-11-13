
public class assignment3 {
    public static void main(String args[]){

        // all submissions _must_ contain this prelude or equivalent

        int bg[] = {4,2,4,2,4,5,2,7,3,7,3,7,3,2}; // background image
        int a[]  = {0,1,2,3,3,2,1,0};             // pixels
        int b[] = new int[8];                     // filtered pixels

        int sr0,sr1,sr2,sr3,sr4;                  // new on-chip SRAM
                                                  // register file
                                                  // load-store restrictions start
        sr0 = bg[0];                              // initial SRAM load
        sr1 = bg[1];
        sr2 = bg[2];
        sr3 = bg[3];
        sr4 = bg[4];

        int r = 5; int m = 0;                     // indices for bg ==> SRAM
        int min_sad = 100;                        // absurdly high value

        for(int i = 0; i<a.length; i++){          // for every pixel do
            int curpix = a[i];
            b[i] = Math.abs(curpix - sr0)+Math.abs(curpix - sr1)+Math.abs(curpix - sr2)+Math.abs(curpix - sr3)+Math.abs(curpix - sr4);
            switch (i%r){
                case 0:
                    sr0 = bg[r+m];
                    break;
                case 1:
                    sr1 =  bg[r+m];
                    break;
                case 2:
                    sr2 =  bg[r+m];
                    break;
                case 3:
                    sr3 =  bg[r+m];
                    break;
                case 4:
                    sr4 =  bg[r+m];
                    break;
            }
            m++;

        }



        System.out.println("The eight original pixels are:");
        for (int i = 0; i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println(" ");

        System.out.println("The eight filtered pixels are:");
        for (int i = 0; i<b.length;i++){
            System.out.print(b[i]+" ");
        }
        System.out.println(" ");


        System.out.println("The minimum SAD value is:" );
        for (int i = 0; i<b.length;i++){
            if (b[i]<min_sad)
                min_sad = b[i];
        }
        System.out.print(min_sad);
        System.out.println(" ");

        System.out.println("The final SRAM register values are:" );
        System.out.print("sr0:" + sr0+" ");
        System.out.print("sr1:" +sr1+" ");
        System.out.print("sr2:" +sr2+" ");
        System.out.print("sr3:" +sr3+" ");
        System.out.print("sr4:" +sr4+" ");
    }
}
