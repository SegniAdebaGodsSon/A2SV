var allCellsDistOrder = function(R, C, r0, c0) {
    var getDistance = function(p1, p2){
        let xDif = Math.abs(p1[1] - p2[1]);
        let yDif = Math.abs(p1[0] - p2[0]);
        return xDif+yDif;
    }
    
    var getMaxDistance = function(matrix){
        let max = 0;
        matrix.forEach(el => {
            let distance= getDistance(el, [r0, c0]);
            if(distance > max){
                max = distance;
            }
        });
        return max;
    }
    
    // create the matrix
    let matrix = [];
    for(let r=0; r<R; r++){
        for(let c=0; c<C; c++){
            matrix.push([r,c]);
        }
    }
    
    // use the counting sort
    let temp = new Array(getMaxDistance(matrix)+1).fill().map(e => []);
    
    matrix.forEach(element => {             // populate 2D array using counting sort
        temp[getDistance(element, [r0, c0])].push(element);
    });
    
    let result = [];
    temp.forEach(ind => {
        let size = 0;
        while(size<ind.length){
            result.push(ind[size]);
            size++;
        }
    });
    
    return result;
};


console.log(allCellsDistOrder(1,2,0,0));