/* 1. 숫자1, 문자'1', true 비교  */
console.log(`1 == 1: ${1 == 1}`);           // ture
console.log(`1 == true: ${1 == true}`);     // true
console.log(`1 == '1': ${1 == '1'}`);       // true  -> ==  : 동등 비교
console.log(`1 == '1': ${1 === '1'}`);      // false -> === : 동일 비교(타입까지 포함해서)

/* 2. NaN는 유일하게 자기 자신과 동등/동일 비교가 안됨 */
console.log(`NaN == NaN: ${NaN == NaN}`);
console.log(`NaN === NaN: ${NaN === NaN}`);

/* 3. 일치하지 않는 값 비교 */
console.log(`1 != '1': ${1 != '1'}`);       // false
console.log(`1 !== '1': ${1 !== '1'}`);     // true