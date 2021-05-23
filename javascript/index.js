let standardCost = 9.5;

const drinks = cost => cost + 1.25;
const food = cost => cost + 2.50;
const threeD = cost => cost + 3.50;
const marathon = cost => cost + 2.25;
const vipSeats = cost => cost + 7;

const pipe = function (...fns) {
    console.log(fns);
    return function (price) {
        return fns.reduce(function (acc, fn) {
            return fn(acc);
        }, price);
    };
};

const decorator = pipe(drinks, food, threeD, marathon, vipSeats);
console.log(decorator(standardCost));