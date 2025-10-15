var dog = {
    name: '뽀비'
};

dog.name = '두부';          // 수정
console.log('dog',dog);

dog.age = 3;                // 추가
console.log('dog',dog);

delete dog.age;             // 삭제
console.log('dog',dog);
