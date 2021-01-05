"use strict";

// Complete the climbingLeaderboard function below.
function climbingLeaderboard(scores, alice) {
  var ranks = new Map(),
      rank = 1,
      aliceRanks = [];

  for (var i = 0; i < scores.length; i++) {
    if (!ranks.has(scores[i])) {
      ranks.set(scores[i], rank);
      rank++;
    }
  }

  for (var _i = 0; _i < alice.length; _i++) {
    if (ranks.has(alice[_i])) {
      aliceRanks.push(ranks.get(alice[_i]));
    } else {
      var position = 0;

      while (position < scores.length) {
        if (scores[position] > alice[_i]) {
          position++;
        } else {
          break;
        }
      }

      var ind = position;

      if (ind === 0) {
        aliceRanks.push(1);
      } else {
        ind -= 1;
        var curr = scores[ind];

        var _rank = ranks.get(curr) + 1;

        aliceRanks.push(_rank);
      }
    }
  }

  return aliceRanks;
}

a1 = "100 100 50 40 40 20 10".split(" ");
a2 = "5 25 50 120".split(" ");
a1 = a1.map(function (el) {
  return Number(el);
});
a2 = a2.map(function (el) {
  return Number(el);
});
console.log(climbingLeaderboard(a1, a2));