
/* 첫 글자가 대문자인 Symbol이라는 함수를 호출하면 Symbol 타입이 생성 */
var sym1 = Symbol();
var sym2 = Symbol();
console.log(sym1 == sym2);          // 다른 Symbol 타입이다. -> false 반환

var sym3 = Symbol('설명');
var sym4 = Symbol('설명');
console.log(sym3 == sym4);          // 동등 객체이지 동일 객체는 아니므로 false

console.log(sym3.description);      // Symbol 타입의 description 속성(property)에 접근
console.log(sym4.description);

console.log(typeof sym3);


/* 리터럴 객체({})를 생성해서 추후에 동적으로 프로퍼티(속성)을 추가 및 제거 할 수 있다. */
var obj = {};                       // {}만해도 객체가 된다. -> 리터럴 객체, 객체마저 동적이기 떄문에 나중에 추가해줄 수 있음
console.log(typeof obj);            // object
obj['일반 속성'] = '일반';          // 대괄호([])는 객체의 속성에 접근 또는 없으면 추가하는 개념
console.log(obj);
obj['일반 속성'] = '일반2';         // 접근해서 수정해서 더 추가적으로 생성되지 않음
console.log(obj);

/* Symbol 타입 사용 이유 */
/* 1. 같은 값을 가진 Symbol 타입은 다른 프로퍼티로 인지한다. */
obj[sym3] = '값1';
obj[sym4] = '값2';
console.log(obj);   // 같은 값을 가지지만 다른 키값으로 하고 싶을때 Symbol 타입 활용
                    // 같은 값을 가지고 있지만, 객체의 중복되지 않은 키 값으로 활용하고 자 할때
console.log(obj[sym3]);

/* 숨김 프로퍼티를 적용하기 위해 */
var hidden = Symbol('숨김 프로퍼티');
obj[hidden] = '비밀 값';
obj['name'] = '홍길동';
console.log(obj);
console.log("================");
console.log(Object.keys(obj));      // Object.keys()에 던져진 인수(obj)가 가진 프로퍼티 키 값을 배열로 반환하는 함수
                                    // (Symbol 타입은 제외)
console.log(Object.keys(obj)[0]);   // 배열이므로 인덱스 접근 가능