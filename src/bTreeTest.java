import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class bTreeTest {
    static public void main(String[] args){
        int totalKey = 32;
        int order = 2;
        bTree thisTree = new bTree(makeTree(totalKey,2,order,1.0),totalKey,order);
        thisTree.printTree(thisTree.root);

    }

    public static node makeTree(int totalKeys,int m ,int order, double full){
        int numberOfLeaf = (int) Math.ceil(totalKeys/(2.0*m*full));
        int numberOfKeysPerLeaf = (int)Math.ceil((double)totalKeys/numberOfLeaf);

        int[] input = testNumbers(totalKeys);
        List<node> leafs = new ArrayList<node>();

        for (int i = 0; i< numberOfLeaf; i++){
            List<Integer> nodeKeys = new ArrayList<Integer>();
            for (int j = 0; j< numberOfKeysPerLeaf; j++){
                if (j+i*numberOfKeysPerLeaf<totalKeys){
                    nodeKeys.add(input[j+i*numberOfKeysPerLeaf]);
                }
            }
            leaf curleaf = new leaf(nodeKeys);
            /************************************
             */
            System.out.println(" ");
            System.out.println("leaf created!");
            curleaf.printNode();
            /************************************
             */
            leafs.add(curleaf);
        }
        for (int l=0;l<leafs.size()-1;l++){
            leafs.get(l).rightBrother = leafs.get(l+1);
        }

        return makelevel(leafs, order).get(0);


    }

    public static List<node> makelevel(List<node> children, int order){
        System.out.println("LEVEl up!! ");
        if (children.size() > 1) {
            node[] curlevel = new node[(int)Math.ceil(children.length/(order+1.0))];

            int totalcount = 0;
            int nodecount = 0;
            while(totalcount<children.length){
                if (children.length-nodecount*(order+1)>order){
                    int[] keys = new int[order];
                    node[] pointers = new node[order+1];
                }
                else if(children.length-nodecount*(order+1)<order&&children.length-nodecount*(order+1)>1) {
                    int[] keys = new int[order];
                    node[] pointers = new node[order+1];
                }
                else if(children.length-nodecount*(order+1)==1){

                }


                for (int i=0;i<order+1;i++){
                    if(i+nodecount*(order+1)<children.length){
                        node curChild = children[i+nodecount*(order+1)];
                        pointers[i] = curChild;
                        if(i==0){

                        }
                        else {
                            keys[i-1]=curChild.keys[0];
                        }
                        totalcount++;
                    }
                }
                node curnode = new node(keys,pointers,order+1);
                /************************************
                 */
                System.out.println(" ");
                System.out.println("Upper node created!");
                curnode.printNode();
                System.out.println("current level size: " +curlevel.length);
                System.out.println("node count: "+ nodecount);

                /************************************
                 */
                curlevel[nodecount]=curnode;
                nodecount++;
            }
            for (int l=0;l<curlevel.length-1;l++){
                curlevel[l].rightBrother = curlevel[l+1];
            }
            return makelevel(curlevel, order);


        }
        else {
           return children;
        }
    }

    public static int[] ran( int n){
        int[] numbers = new int[n];
        Random randomGenerator = new Random();
        for (int i = 0; i<n;i++){
            int randomBetweenXAndY = randomGenerator.nextInt(100) + 1;
            numbers[i] = randomBetweenXAndY;
        }
        return numbers;
    }

    public static int[] testNumbers(int n){
        int[] numbers = new int[n];
        for (int i = 0; i<n;i++){
            numbers[i] = i;
        }
        return numbers;
    }

}
