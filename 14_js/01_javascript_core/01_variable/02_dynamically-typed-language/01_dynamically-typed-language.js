var test;
console.log(typeof test);

test = 1;
console.log(typeof test);

test = "JavaScript";
console.log(typeof test);

test = true;
console.log(typeof test);

test = Symbol();
console.log(typeof test);

test = {};                  // JSON Object
console.log(typeof test);

test = [];                  // JSON Array
console.log(typeof test);

test = function() {};       // 함수가 리터럴이 됨(함수를 값으로 다룸, 함수 지향 언어의 특징, 나중에는 함수를 객체로 다룸)
console.log(typeof test);