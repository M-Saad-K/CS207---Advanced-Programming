package practical7;

public class BTNode<E> {
    private E value;
    private BTNode<E> left;
    private BTNode<E> right;

    public BTNode(){
        this(null, null, null);
    }
    public BTNode(E number){
        this(number, null, null);
    }
    public BTNode(E v, BTNode<E> l, BTNode<E> r) {
        value = v;
        left = l;
        right = r;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public BTNode<E> getLeftChild() {
        return left;
    }

    public BTNode<E> getRightChild() {
        return right;
    }

    public void setLeftChild(BTNode<E> node) {
        left = node;
    }

    public void setRightChild(BTNode<E> node) {
        right = node;
    }
}




