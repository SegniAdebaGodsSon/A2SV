"use strict";

/**
 * object accepted is assumed to be of the type {type, price}
 * we sort using the price
 * @param {type, price} arr 
 */
var countSortObj = function countSortObj(arr) {
  var getMaxPrice = function getMaxPrice(arr) {
    var max = arr[0].price;
    arr.forEach(function (_ref) {
      var type = _ref.type,
          price = _ref.price;

      if (price > max) {
        max = price;
      }
    });
    return max;
  };

  var fillArray = function fillArray(size) {
    var arr = [];

    for (var i = 0; i < size; i++) {
      arr.push(new Array());
    }

    return arr;
  };

  var maxPrice = getMaxPrice(arr);
  var tempArr = fillArray(maxPrice + 1);
  var finalArr = [];

  for (var i = 0; i < arr.length; i++) {
    // populate the temp array
    tempArr[arr[i].price].push(arr[i]);
  }

  tempArr.forEach(function (el) {
    if (el.length > 0) {
      el.forEach(function (obj) {
        finalArr.push(obj);
      });
    }
  });
  return finalArr;
};

var a = [{
  type: 'a',
  price: 4
}, {
  type: 'b',
  price: 2
}, {
  type: 'c',
  price: 0
}, {
  type: 'd',
  price: 6
}];
console.log(countSortObj(a));