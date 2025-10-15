
/* 객체를 생성 할 용도의 함수(this.을 활용하고 이름의 첫 글자를 대문자로 함)더라도 new 연산자가 없으면 일반 함수와 동일함 */
// 첫 글자를 대문자로 하는 것은 일반함수와 구분하기 위한 용도일 뿐 별다른 기능은 없음
function Student(name, age) {  
    this.name = name;                       // 일반 함수로 사용될 때의 this는 global 객체이며 없는 속성이면 접근 시 추가됨
    this.age = age;
    this.getInfo = function() {
        return `${this.name}(은)는 ${this.age}세 입니다.`;
    };

    console.log('일반 함수일 때 this:', this);  // <- global 객체

    return this.getInfo
}

/* new 연산자를 안 붙이고 일반 함수로 썼을 때는 반환형이 없는 함수일 뿐이다.(undefined 반환) */

const student = Student('강감찬', 35);
console.log(student);                   // 반환형이 없는 함수이므로 undefined

/*
    생성자 함수가 일반 함수와 명확히 차이나도록(객체만 생성하도록) new 연산자 없이 호출되어도 객체 생성 가능하게
    작성 가능(빌트 인 함수)
*/

function Dog(name, age) {
    if(!new.target) {   // new 연산자를 안쓰고 함수를 호출하면 true가 되도록
                        // (원래 new.target은 new 연산자를 써서 호출하면 true, 안쓰면 fasle)
        return new Dog(name, age);
    }
    this.name = name;
    this.age = age;
    this.getInfo = function() {
        return `${this.name}(은)는 ${this.age}세 입니다.`;
    };
}

const dog1 = Dog("뽀비", 2);
console.log(dog1);

const dog2 = Dog("두부", 3);
console.log(dog2);

/* 제공되는 빌트인 함수들: Object, String, Number, Boolean, Date, Regex, ... */

console.log(Dog.prototype);
console.log(dog1.constructor);
console.log(dog1.__proto__);
console.log(dog1.__proto__.constructor);
