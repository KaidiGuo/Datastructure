import java.util.List;

public class bpTree extends node{
    node root;
    int order;
    int totalKey;
    bpTree(node root, int totalKey, int order){
        this.root = root;
        this.order = order;
        this.totalKey = totalKey;
    }

    public void printTree(node thisNode){
        System.out.println(" ");
        if (thisNode.children!=0){
            node brother = thisNode;
            node firstLeftChild = thisNode.pointers.get(0);

            System.out.print("LEVEL: "+ thisNode.level+" Nodes: "+ thisNode.levelNodeCount + "-->");
            while (brother!=null){
                System.out.print("[");
                for (int key : brother.keys){
                    System.out.print(key +" ");
                }
                brother = brother.rightBrother;
            System.out.print("]");
            System.out.print(" ");
            }
            thisNode = firstLeftChild;
            printTree(thisNode);
        }
        else{
            node brother = thisNode;
            System.out.print("LEVEL: "+ thisNode.level+" Nodes: "+ thisNode.levelNodeCount + "-->");
            while (brother!=null){
                System.out.print("[");
                for (int key : brother.keys){
                    System.out.print(key +" ");
                }
                brother = brother.rightBrother;
                System.out.print("]");
                System.out.print(" ");
            }
        }

    }
    public void searchKey(int skey, node thisNode){
        System.out.print("-->");
        thisNode.printNode();
        if (thisNode.children!=0){
            if (thisNode.keys.size()==1){

                if (skey< thisNode.keys.get(0)){
                    searchKey(skey, thisNode.pointers.get(0));
                }
                else{
                    searchKey(skey, thisNode.pointers.get(1));
                }
            }
            for (int i = 0; i<thisNode.keys.size()-1;i++){
                int first = thisNode.keys.get(i);
                int second = thisNode.keys.get(i+1);
                if (skey<first){
                    searchKey(skey, thisNode.pointers.get(0));
                }
                else if(skey>=first&&skey<second){
                    searchKey(skey, thisNode.pointers.get(i+1));
                }
                else if (skey>=second){
                    searchKey(skey, thisNode.pointers.get(i+2));
                }

            }
        }
        else {
            int flag = 0;
            for (int key : thisNode.keys){
                if (skey == key){
                    System.out.print("Find it! In leaf node: ");
                    thisNode.printNode();
                    flag=1;
                }
            }
            if (flag==0){
                System.out.print("The key does not exist in this tree!");
            }
        }
    }
}
