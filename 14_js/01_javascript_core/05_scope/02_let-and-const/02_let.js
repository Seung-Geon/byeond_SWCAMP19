
/* 1. 변수의 중복 선언 방지 */
let msg = 'hi';
// let msg = 'bye'; // 컴파일 에러 발생

/* 2. 블록 레벨 스코프 인정 */
let i = 0;
for(let i = 0; i < 10; i++) {

}
console.log('i:', i);

/* 3. 변수 호이스팅 방지 */
console.log(x);     // ReferenceError: Cannot access 'x' before initializatio
let x = 1;