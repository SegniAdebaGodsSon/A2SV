// Complete the bonAppetit function below.
function bonAppetit(bill, k, b) {
    let annaBill = 0;
    for(let i=0; i<bill.length; i++){
        if(i!==k){
            annaBill += bill[i];
        }
    }
    annaBill = annaBill/2;
    
    if(annaBill === b){
        console.log("Bon Appetit");
        return;
    }else{
        console.log(b - annaBill);
    }
}
