/* 객체 구조 분해 할당 */

let pants = {
    productName: '배기팬츠',
    color: '검은색',
    price: 30000,
    getInfo: function() {
        console.log(this.color, this.productName, '좋아!');
    }
};

/* 
    배열 구조 분해 할당과 당ㄹ리 프로퍼티 순서는 중요하지 않지만
    반드시 기존의 프로퍼티명과 일치해야 한다.
*/
let {productName, color, getInfo} = pants;   // 순서 안지켜도 되고 필요한 것만 추출 가능
console.log('productName',productName);
console.log('color',color); 

/* patns.을 안써도 동일한 함수지만 this.을 활용할 때는 메소드와 일반함수의 차이가 발생할 수 있다.ㄴ */
pants.getInfo();
getInfo();  // this가 적요된 메소드일 경우 변수에 담고나면 this의 의미가 전역 객체가 되어 기대와 다른 출력이 아놈

/* 객체 구조 분해 할당 시 변수명을 원하는 것으로 교체 가능(:(콜론) 활용) */
let {color:co, productName:pr, price:pr2} = pants;
console.log(co, pr, pr2);