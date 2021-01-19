var reverseList = function(head) {
    let curr=head, listNodes=[];
    while(curr!=null){
        listNodes.push(curr);
        curr = curr.next;
    }
    listNodes = listNodes.reverse();
    for(let i=0; i<listNodes.length-1; i++){
        if(i===0) listNodes[0].next = null;
        listNodes[i].next = listNodes[i+1]; 
    }
    return listNodes[listNodes.length-1];
};
