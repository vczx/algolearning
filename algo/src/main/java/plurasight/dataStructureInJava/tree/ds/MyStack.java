package plurasight.dataStructureInJava.tree.ds;

public class MyStack<X> {
    X[] items;
    int stackPointer;

    public MyStack() {
        items = (X[]) new Object[1000];
    }

    public X pop() {
        if(stackPointer <=0){
            throw new IllegalArgumentException("No more items in the stack");
        }
        //This is a pre-increment operator, it will minus the stackpointer first then get the item after
        return items[--stackPointer];
    }

    public void push(X item) {
        if(stackPointer == items.length){
            throw new IllegalArgumentException("Reach Max Size");
        }
        items[stackPointer++] = item;
    }

    public boolean contains(X item){
        for(X arrItem: items){
            if(arrItem == item){
                return true;
            }
        }
        return false;
    }

    public X access(X item){

        if(contains(item)){
            X newItem;
            for(int i=0;i<items.length;i++){
                newItem = this.pop();
                if(newItem == item){
                    return newItem;
                }
            }
        }else{
            throw new IllegalArgumentException("Item not Found");
        }

        return null;

    }

    public int size(){
        return stackPointer;
    }

}
