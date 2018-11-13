import java.util.List;

public class bTree extends node{
    node root;
    int order;
    int totalKey;
    bTree(node root,int totalKey, int order){
        this.root = root;
        this.order = order;
        this.totalKey = totalKey;
    }
    public void printTree(node thisNode){
        System.out.println(" ");
        if (thisNode.children!=0){
            node brother = thisNode;
            node firstLeftChild = thisNode.pointers.get(0);


            while (brother!=null){
//                for (int i=0; i<4*totalKey/(brother.levelNodeCount+1); i++){
//                    System.out.print(" ");
//                }
                System.out.print("|");
                for (int key : brother.keys){
                    System.out.print(key +" ");
                }
                brother = brother.rightBrother;
            System.out.print("|");
            System.out.print(" ");
            }
//            System.out.println("--------------------");
            thisNode = firstLeftChild;
            printTree(thisNode);
        }
        else{
            node brother = thisNode;
            while (brother!=null){
                System.out.print("|");

                for (int key : brother.keys){
                    System.out.print(key +" ");
                }
                brother = brother.rightBrother;
                System.out.print("|");
                System.out.print(" ");
            }
        }

    }
    public void searchKey(){

    }
}
