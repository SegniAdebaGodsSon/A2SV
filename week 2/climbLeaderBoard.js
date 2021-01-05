// Complete the climbingLeaderboard function below.
function climbingLeaderboard(scores, alice) {
    let ranks = new Map(), rank = 1, aliceRanks=[];
    for(let i=0; i<scores.length; i++){
        if(!ranks.has(scores[i])){
            ranks.set(scores[i], rank);
            rank++;
        }
    }

    for(let i=0; i<alice.length; i++){
        if(ranks.has(alice[i])){
            aliceRanks.push(ranks.get(alice[i]));
        }else{
            let position=0;
            while(position < scores.length){
                if(scores[position]>alice[i]){
                    position++;
                }else{
                    break;
                }
            }
            let ind = position;
            if(ind===0){
                aliceRanks.push(1);
            }else{
                ind -= 1;
                let curr = scores[ind];
                let rank = ranks.get(curr) + 1;
                aliceRanks.push(rank);
            }
        }
    }
    
    return aliceRanks;

}

a1 = "100 100 50 40 40 20 10".split(" ");
a2 = "5 25 50 120".split(" ");
a1 = a1.map(el => Number(el));
a2 = a2.map(el => Number(el));

console.log(climbingLeaderboard(a1, a2))