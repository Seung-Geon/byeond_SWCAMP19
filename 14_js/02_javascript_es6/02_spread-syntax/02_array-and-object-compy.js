/* 스프레드 문법을 활용한 배열 및 객체 복사 */

/* 1. 배열 복사(깊은 복사, deep copy) */
let arr = [10,  40, 80];
let arrCopy = [...arr];

console.log(arr);
console.log(arrCopy);
console.log(arr === arrCopy);   // false, 동일 배열 X

arr[3] = 3;
console.log(arr);
console.log(arrCopy);

/* 객체 복사 */
let obj = {
    name: '홍길동',
    age: 20,
    addr: '서울',
    hobbies: ['축구', '농구']
}

let objCopy = {...obj}; // 객체의 프로퍼티 전개
                        // hobbies는 배열의 주소를 가리키기 때문에 이렇게 해도 배열은 얕은 복사가 일어남
                        // 깊이만큼의 복사가 필요   => 깊이를 낮추는게 좋다
console.log(obj);
console.log(objCopy);
console.log(obj === objCopy);

/* 객체만 복사하고 내부 배열은 따로 복사하지 않았을 경우 */
console.log(obj.hobbies);
console.log(objCopy.hobbies);

objCopy.hobbies.unshift('야구');
console.log(obj.hobbies);   // 배열은 따로 복사를 해줘야 한다.

console.log(obj.hobbies === objCopy.hobbies);   // true

/* 내부 배열도 복사 했을 경우 
    복사하는 객체 내부에 이와 같이 추가적인 객체(또는 배열)이 있다면 추가적으로 복사해 주어야
    정확한 의미의 사본(깊은 복사)이 만들어 진다.
*/
objCopy.hobbies = [...obj.hobbies];
console.log(obj.hobbies === objCopy.hobbies);   // false

/* 기존에 존재하는 객체 및 변수를 활용해서 새로운 객체를 만들 수 있다. */
let classNum = 30;      // obj에 프로퍼티 키로 존재하지 않는 변수명은 추가됨
let name = '강감찬';    // obj에 프로퍼티 키로 존재하면 해당 변수값으로 수정됨

let newObj = {classNum, ...obj, name}
console.log(newObj);        // name: 강감찬

let newObj2 = {classNum, name, ...obj}  // 수정해야 할 프로퍼티로 쓰일 변수는 
                                        // 해당 객체 뒤에 작성할 것(순서에 유의)
console.log(newObj2);       // name: 홍길동