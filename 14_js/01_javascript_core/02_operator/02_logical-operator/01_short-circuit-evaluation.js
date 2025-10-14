/* 단축 평가 구문 */
/* 논리 연산의 결과를 결정지을 항만 남는다. */

/* 1. OR의 경우 */
console.log('apple' || 'banana');
console.log('' || 'banana');
console.log('apple' || false);
/*
    1. true || true    -> true
    2. true || false   -> true
    3. false || true   -> true
    4. false || false  -> false

    1, 2의 경우 앞에 오는 값이 연산을 결정함
    3, 4의 경우 뒤에 오는 값이 연산을 결정함
*/

console.log("==============");
/* 2. AND의 경우 */
console.log('apple' && 'banana');
console.log('' && 'banana');
console.log('apple' && false);
/*
    1. true && true    -> true
    2. true && false   -> false
    3. false && true   -> false
    4. false && false  -> false

    1, 2의 경우 뒤에 오는 값이 연산을 결정함
    3, 4의 경우 앞이 오는 값이 연산을 결정함
*/

console.log("==============");
/* 3. 단축 평가 구문 */
var num = 2;
num % 2 == 0 && console.log("짝수입니다.");     // &&일 때는 좌측이 true 여야 우측이 실행
num % 2 == 0 || console.log("홀수입니다.");     // ||일 때는 좌측이 fasle 여야 우측이 실행

if(num % 2 == 0) {
    console.log('짝수입니다.');
} else {
    console.log('홀수입니다.');
}