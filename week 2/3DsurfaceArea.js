
/**
 * link: https://www.hackerrank.com/challenges/3d-surface-area/problem
 * 
 * solution 1
 * TC - O(n*m) worst case, n*m is the dimension of the matrix
 *      O(n*m) for transposing, O(n*m) to calculate front/back and sides surface areas
 * 
 * @param {number[]} A
 * @return {number}
 */

// Complete the surfaceArea function below.
// solution 1
function surfaceArea(A) {
    let transposeArray = function(A){
        let arr = [];
        for(let i=0; i<A[0].length; i++){
            let row = [];
            A.forEach(el => {
                row.push(el[i]);
            })
            arr.push(row);
        }
        return arr;
    }
    
    let topViewSurArea = function(A){
        let area;
        let cols = A[0].length;
        let rows = A.length;
        area = cols*rows;
        return area;
    }
    
    let frontToBackSideToSide = function(A){
        let up=0, down=0;
        let area=0;
        A.forEach(row => {
            up=row[0], down = row[row.length-1];
            for(let i=1; i<row.length; i++){
                let prev=row[i-1], curr = row[i];
                if(prev<curr){
                    up+=curr-prev;
                }else if(prev>curr){
                    down+=prev-curr;
                }
                console.log("up: ", up);
                console.log("down: ", down)
            } 
            area += (up*1 + down*1);
        });
        return area;
    }
    
    let A_trans = transposeArray(A);
    let frontAndBack = frontToBackSideToSide(A);
    let topAndBottom = topViewSurArea(A)*2;
    let twoSides = frontToBackSideToSide(A_trans);
    let surfaceArea = frontAndBack + twoSides + topAndBottom;
    
    return surfaceArea;   
}