import java.util.ArrayList;
import java.util.List;

public class node {
//    ArrayList keys = new ArrayList();
//    ArrayList node[] pointers;

    List<Integer> keys;
    List<node> pointers;
    node rightBrother = null;
    int children;
    int minimkey;

    int level;
    int levelNodeCount;

    node(List keys,List pointers,int children){
        this.keys = keys;
        this.pointers = pointers;
        this.children = children;
    }
    node(){

    }
    public void printNode(){
        System.out.print("The keys of current node are: ");
        for (Object key: keys){
            System.out.print(key+" ");
        }
    }


}
