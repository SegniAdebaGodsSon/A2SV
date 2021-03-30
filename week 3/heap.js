class heap{
    constructor(){
        this.heapVals = [];
    }

    swap(i, j){
        [this.heapVals[i], this.heapVals[j]] = [this.heapVals[j], this.heapVals[i]];
    }

    insert(a){
        this.heapVals.push(a);
        let  aInd = this.heapVals.length-1;
        let count = aInd == 0 ? 0 : parseInt(Math.log2(aInd+1));
        while(count>0){
            let parentInd = parseInt((aInd-1)/2);
            if(a < this.heapVals[parentInd]){
                this.swap(parentInd, aInd);
                aInd = parentInd;
            }else{
                break;
            }
            count--;
        }
        return this.heapVals;
    }

    getMin(){
        return this.heapVals[0];
    }

    // deletion of the node at the root
    delete(){
        if(!this.heapVals.length) return;
        this.swap(0, this.heapVals.length-1);
        this.heapVals.pop();
        if(this.heapVals.length==1) return;

        let height = parseInt(Math.log2(this.heapVals.length)),
            count = height,
            currInd = 0;

        while(count>0){
            let leftChildInd =  parseInt((2*currInd + 1)),
                rigthChildInd = parseInt(2*currInd + 2);
            if(this.heapVals[leftChildInd] < this.heapVals[currInd]){
                this.swap(leftChildInd, currInd);
                currInd = leftChildInd;
            }else if(this.heapVals[rigthChildInd] < this.heapVals[currInd]){
                this.swap(rigthChildInd, currInd);
                currInd = rigthChildInd;
            }else{
                break;
            }
            count--;
        }
        return;
    }

    print(){
        console.table(this.heapVals);
    }
}


let a = new heap();
a.insert(4);
a.insert(3);
a.insert(6);
a.insert(7);
a.insert(5);
a.insert(0);

a.print()

a.delete();

a.print();

