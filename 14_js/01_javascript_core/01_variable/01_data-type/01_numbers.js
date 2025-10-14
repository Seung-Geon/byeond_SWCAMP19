/*
    data-type은 값의 종류를 말하며 자바스크립트(ES6)는 7개의 데이터타입
    (number, string, boolean, undefined, null, symbol, object)을 제공한다.
*/

// 정수, 실수, 음수 모든 숫자(number)타입이다. (내부적으로는 실수로만 인식)
var integer = 10;   // var <- 들어오는 값에 맞춰서 알아서 타입이 맞춰짐
var double = 5.5;
var negative = -10;

console.log(typeof integer);    // <- typeof: 변수의 타입을 반환해주는 예약어
integer = '한글';
console.log(typeof integer);    // <- 중간에 변경하면 자료형도 변경됨(동적인 자료형): 실수할 여지가 있으므로 주의  
var integer = "중복"             // <- 같은 이름의 변수를 또 선언할 수 있다.(var로 선언된 변수면)
console.log(typeof integer);
console.log(typeof double);
console.log(typeof negative);


console.log(10 / 4);
console.log(10 / 0);            // <- infinity
console.log(10 / -0);           // <- -infinity
console.log(1 * '문자열');       // NaN: Not at Number
console.log("문자열");