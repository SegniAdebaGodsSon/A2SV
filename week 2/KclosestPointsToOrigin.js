/**
 * link: https://leetcode.com/problems/k-closest-points-to-origin/
 * 
 * Solution 1 
 * TC - O(n^2) - n is the length of the @param {number[][]} points array
 *      O(n)    - getting the max distance
 *      O(n)    - populating the counting sort array with the indexes as values and values as counts
 *      O(n^2)  - find the first K arrays from the sorted 2D array
 * 
 *
 * Solution 2 
 * TC - O(nlogn) - n is the size of the @param {number[][]} points array
 *      O(n)     - populate a new array with all the  @param {number[][]} points elements' distances from (0, 0), origin
 *      O(nlogn) - sort the array with the distances
 *      O(n)     - iterate through the whole @param points to check if it's in the first @param K elements of the distances' array
 * 
 *
 * Solution 3
 * TC - O(nlogn) - n is the size of the @param {number[][]} points array
 *      O(nlogn) - sorting the 2D array with custom comparison in an non decreasing order
 *      O(n)     - JS slice operation
 * 
 *  
 * @param {number[][]} points
 * @param {number} K
 * @return {number[][]}
 */

 // solution 1 ---- too slow and faulty memory allocation 
var kClosest1 = function(points, K) {
    // we can use counting sort
    // calculate the distance, without the sqrt
    function calculateDist(arr){
        return Math.pow(arr[0], 2)+Math.pow(arr[1], 2);
    }
    
    // get the max pythagoric? sum
    function getMax(arr){
        let sqrtMax = Math.pow(arr[0][0], 2) + Math.pow(arr[0][1], 2);
        arr.forEach(el => {
            if(calculateDist(el) > sqrtMax){
                sqrtMax = calculateDist(el);
            }
        });
        return sqrtMax;
    }
    
    let maxSqrt = getMax(points);
    let count = new Array(maxSqrt+1).fill().map(e => []);
    
    // populate the count array
    for(let i=0; i<points.length; i++){
        let dist = calculateDist(points[i]);
        count[dist].push(points[i]);
    }
    
    let closestPts=[];
    for(let i=0; i<count.length; i++){
        if(count[i].length > 0){
            for(let j=0; j < count[i].length; j++){
                if(closestPts.length < K){
                    closestPts.push(count[i][j]);
                }else{
                    break;
                }
            }
        }
    }
    return closestPts;
};


// solution 2 --- sorting the distances
var kClosest2 = function(points, K){
    var distance = function(point){
        return Math.pow(point[0], 2) + Math.pow(point[1], 2);
    }

    let len = points.length;
    let distances = [];
    points.forEach(point => distances.push(distance(point)));

    distances = distances.sort((a,b) => a-b);   // acsending order
    let distK = distances[K-1];

    let ans = [];
    points.forEach(point => {
        if(distance(point) <= distK){
            ans.push(point);
        }
    });

    return ans;
}


// solution 3 --- one liner custom sorting
var kClosest3 = function(points, K){
    return points.sort((a, b) => Math.sqrt(Math.pow(a[0], 2)+Math.pow(a[1], 2)) - Math.sqrt(Math.pow(b[0], 2) + Math.pow(b[1], 2))).slice(0, K);
}

// check this recursive solution
//https://leetcode.com/problems/k-closest-points-to-origin/discuss/239208/JavaScript-Solution