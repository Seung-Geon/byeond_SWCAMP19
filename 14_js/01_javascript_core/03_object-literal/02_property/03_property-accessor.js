var dog = {
    name: '뽀비',
    eat: function(food) {
        
        /* 메서드의 this는 메서드를 호출한 객체(나의 객체), 매개변수와 일치하는 변수는 지역 변수 */
        console.log(`${this.name}(은)는 ${food}를 맛있게 먹어요`);
    }
}

/* 1. 마침표 표기법 (dot notation) */
console.log(dog.name);
dog.eat('풀');

/* 2. 대괄호 표기법(squre braket notation) */
var obj = {
    under_key: 'under_key',
    'dash-key': 'dash-key',
    0: 1
};

/* 마침표 표기법은 한계가 있다. */
console.log(obj.under_key);
// console.log(obj."dash-key");     // error
// console.log(obj.0);              // error

/* 대괄호 표기법은 다양한 형태의 프로퍼티들을 모두 접근할 수 있다. */
console.log(obj['under_key']);
console.log(obj['dash-key']);
console.log(obj['0']);
console.log(obj[0]);                // 숫자 프로퍼티 키 값일 경우에는 숫자로 바로 접근 가능
