/*
    ES11(2020)에 도입된 연산자로 연산자의 좌항이 null 또는 undefined인 경우
    error 대신 undefined를 반환하고 그렇지 않으면 우향의 프로퍼티 참조를 이어간다.
    (.(dot notation)은 객체의 프로퍼티에 접근하는 접근 연산자)
*/

var obj = null;
obj = {
    'value': 'abc'
}

var val = obj?.value;   // ?. 연산자: NPE 방지, null값이면 undefined 반환
                        // NPE 방지 코드
console.log(val);


/* 좌항이 null이나 undefined가 아니면 ?. 쓸 필요 없이 .으로만 사용해도 된다. */
var str = ''
var len = str?.length;
console.log(len);
len = str.length;
console.log(len); // str은 false로 취급될 수는 있지만 null또는 undefined가 아니므로 ?가 없어도 된다.

console.log(Object.getOwnPropertyDescriptors(str));