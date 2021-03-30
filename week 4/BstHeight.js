var BstHeight = (root) => height(root, 0);

var height = (root, h) => {
    if(!root.left && !root.right) return h;
    l =  height(root.left, h+1);
    r = height(root.right, h+1);
    return Math.max(l, r);
}