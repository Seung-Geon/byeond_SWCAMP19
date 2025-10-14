console.log(Boolean('JavaScript'));
console.log(Boolean(''));
console.log(Boolean(1));
console.log(Boolean(0));
console.log(Boolean(NaN));
console.log(Boolean(Infinity));
console.log(Boolean(null));
console.log(Boolean(undefined));
console.log(Boolean({}));
console.log(Boolean([]));

console.log(!!'JavaScript');// true
console.log(!!'');          // flase
console.log(!!1);           // true
console.log(!!0);           // false
console.log(!!NaN);         // false
console.log(!!Infinity);    // true
console.log(!!null);        // false
console.log(!!undefined);   // false
console.log(!!{});          // true
console.log(!![]);          // true