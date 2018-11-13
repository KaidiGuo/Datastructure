public class bTree extends node{
    node root;
    int order;
    int totalKey;
    bTree(node root,int totalKey, int order){
        this.root = root;
        this.order = order;
    }
    public void printTree(node thisNode){
        System.out.println(" ");
        if (thisNode.children!=0){
            node brother = thisNode;
            node firstChild = thisNode.pointers[0];
            int[] keys = thisNode.keys;
            while (brother!=null){
                for (int key : keys){
                    System.out.print(key +" ");
                }
                brother = brother.rightBrother;
            System.out.print("|");
            }
            System.out.println("--------------------");
            thisNode = firstChild;
            printTree(thisNode);
        }
        else{
            node brother = thisNode;
            while (brother!=null){
                for (int key : keys){
                    System.out.print(key +" ");
                }
                brother = brother.rightBrother;
                System.out.print("|");
            }
        }

    }
    public void searchKey(){

    }
}
