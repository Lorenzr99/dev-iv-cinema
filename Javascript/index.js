// BRONNEN:

// https://www.youtube.com/watch?v=P6XGSKO2RzI
// https://stackabuse.com/quicksort-in-javascript/
// https://www.guru99.com/quicksort-in-javascript.html

// ////////////////////////////////////////////////////////////////////////////

"use strict";

let prices = [12.00, 10.75, 9.50, 11.75, 16.50, 13.00]; // Dit is een array van de prijzen van onze film tickets (met eventuele extra kosten bijgerekend)

function swap(prices, leftSide, rightSide) {
    let temp = prices[leftSide];
    prices[leftSide] = prices[rightSide];
    prices[rightSide] = temp;
}

function divide(prices, left, right) {
    let pivot = prices[Math.floor((right + left) / 2)], // Middelste element bepalen (pivot)
        i = left, // Linkerkant van de pivot
        j = right; // Rechterkant van de pivot
    while (i <= j) {
        while (prices[i] < pivot) {
            i++;
        }
        while (prices[j] > pivot) {
            j--;
        }
        if (i <= j) {
            swap(prices, i, j); // i en j wisselen 
            i++;
            j--;
        }
    }
    return i;
}

function sort(prices, left, right) {
    if (prices.length > 1) {
        let i = divide(prices, left, right);
        if (left < i - 1) {
            sort(prices, left, i - 1);
        }
        if (i < right) {
            sort(prices, i, right);
        }
    }
    return prices;
}


let sortedArray = sort(prices, 0, prices.length - 1);
console.log(sortedArray, "Het Werkt"); // console log print: [9.5, 10.75, 11.75, 12, 13, 16.5] (van klein-groot)