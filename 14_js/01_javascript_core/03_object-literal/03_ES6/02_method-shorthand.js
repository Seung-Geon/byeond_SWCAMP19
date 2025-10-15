/* 메서드 단축 */

var pika = {
    name: '피카츄',
    attack: function(skill) {
        console.log(`${skill} 시전!`);
    }
};

pika.attack('백만볼트');

var pika2 = {
    name: '피카츄2',
    attack(skill) {                     // 콜론과 function이라는 키워드를 안쓰고 메서드를 작성할 수 있다.
        console.log(`${skill} 시전!`);
    }
};

pika2.attack('백만볼트');