var isValidBST = (root) =>{
    return valid(root, Infinity, -Infinity);
}

var valid = (root, upperBound, lowerBound){
    if(root){   
        if(upperBound>=root.val>=lowerBound) return false;
        l = valid(root.left, root, lowerBound)
        r = valid(root.right, upperBound, root)
        return l && r;
    }
    return true;
    
}