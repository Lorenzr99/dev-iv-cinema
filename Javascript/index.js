"use strict";

let prices = [12.00, 10.75, 9.50, 11.75, 16.50, 13.00]; //Dit is een array van de prijzen van onze film tickets (met eventuele extra kosten bijgerekend)

function swap(prices, leftIndex, rightIndex) {
    var temp = prices[leftIndex];
    prices[leftIndex] = prices[rightIndex];
    prices[rightIndex] = temp;
}

function divide(prices, left, right) {
    let pivot = prices[Math.floor((right + left) / 2)], //middelste element bepalen (pivot)
        i = left, //linkerkant van de pivot
        j = right; //rechterkant van de pivot
    while (i <= j) {
        while (prices[i] < pivot) {
            i++;
        }
        while (prices[j] > pivot) {
            j--;
        }
        if (i <= j) {
            swap(prices, i, j); //i en j wisselen (swappen)
            i++;
            j--;
        }
    }
    return i;
}

function sort(prices, left, right) {
    if (prices.length > 1) {
        let i = divide(prices, left, right); //i returnen vanuit de functie "divide"
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
console.log(sortedArray, "Het Werkt"); //prints [9.5, 10.75, 11.75, 12, 13, 16.5]