import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class bTreeTest {
    static public void main(String[] args){
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter how many keys you have in total: ");
        int totalKey = reader.nextInt();
        System.out.println("Enter the order ot this tree: ");
        int order = reader.nextInt();
//        reader.close();

//        int totalKey = 200;
//        int order = 2;
        int m =2;
        double full = 1.0;


        if ((int)(Math.pow((order+1),3)*2*m) > totalKey){//108
            System.out.println("YOUR INPUT IS NOT ENOUGH TO BUILD A 4 LEVEL B+ TREE!");
        }
        else {
            bTree thisTree = new bTree(makeTree(totalKey, m, order, full), totalKey, order);
            thisTree.printTree(thisTree.root);
        }
    }

    public static node makeTree(int totalKeys,int m ,int order, double full){
        int numberOfLeaf = (int) Math.ceil(totalKeys/(2.0*m*full));
        int numberOfKeysPerLeaf = (int)Math.ceil((double)totalKeys/numberOfLeaf);

        int[] input = ran(totalKeys);
        System.out.println("Random numbers:");
        for (int x: input){
            System.out.print(x+" ");
        }
        mergeSort.doMergeSort( input, 0, totalKeys-1);
        System.out.println(" ");
        System.out.println("After sorting:");
        for (int x: input){
            System.out.print(x+" ");
        }
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
//            System.out.println(" ");
//            System.out.println("leaf created!");
//            curleaf.printNode();
            /************************************
             */
            leafs.add(curleaf);
        }
        for (node leaf: leafs){
            leaf.minimkey = leaf.keys.get(0);
            leaf.level = 0;
            leaf.levelNodeCount = leafs.size();
//            System.out.println("current level nodes count: "+ leafs.size());

        }
        for (int l=0;l<leafs.size()-1;l++){
            leafs.get(l).rightBrother = leafs.get(l+1);
        }

        return makeHigherLevel(leafs, order, 0).get(0);


    }

    public static List<node> makeHigherLevel(List<node> children, int order, int level){
        level++;
//        System.out.println("LEVEl up!! "+ level);
        if (children.size() > 1) {
            List<node> curlevel = new ArrayList<>();
            int totalcount = 0;
            int nodecount = 0;
            while(totalcount<children.size()){

                List<Integer> keys = new ArrayList<>();
                List<node> pointers = new ArrayList<>();

                for (int i=0;i<order+1;i++){
                    if(i+nodecount*(order+1)<children.size()){
                        node curChild = children.get(i+nodecount*(order+1));
                        pointers.add(curChild);
                        if(i==0){

                        }
                        else {
                            keys.add(curChild.minimkey);
                        }
                        totalcount++;
                    }
                }
                node curnode = new node(keys,pointers,order+1);
                /************************************
                 */
//                System.out.println(" ");
//                System.out.println("Upper node created!");
//                curnode.printNode();
//                System.out.println("current level size: " +curlevel.size());

                /************************************
                 */
                curlevel.add(curnode);
                curnode.minimkey = curnode.pointers.get(0).minimkey;
                curnode.level = level;


                nodecount++;
            }
            for(node curnode: curlevel){
                curnode.levelNodeCount = curlevel.size();
            }

            for (int l=0;l<curlevel.size()-1;l++){
                curlevel.get(l).rightBrother = curlevel.get(l+1);
            }
            return makeHigherLevel(curlevel, order,level);


        }
        else {
           return children;
        }
    }

    public static int[] ran(int n){
        int[] numbers = new int[n];
        Random randomGenerator = new Random();
        for (int i = 0; i<n;i++){
            int randomBetweenXAndY = randomGenerator.nextInt(1000) + 1;
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
