class Node{
    constructor(value){
        this.val = value;
        this.left = null;
        this.right = null;
    }
}


class BST{
    constructor(root){
        this.root = root || null;
    }

    insert(node){
        if(this.root === null) this.root = node;
        let curr = this.root;
        while(curr.left || curr.right){
            if(curr.val <= node.val){
                curr = curr.right;
            }
            if(curr.val > node.val){
                curr = curr.left;
            }
        }

    }
}