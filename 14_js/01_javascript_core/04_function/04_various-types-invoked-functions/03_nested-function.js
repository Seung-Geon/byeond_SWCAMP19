function outer() {

    var outerVal = '외부함수';
    // console.log(outerVal, innerVal);        // 내부 함수의 변수에는 접근 불가

    function inner() {
        var innerVal = "내부함수";
        console.log(outerVal, innerVal);
    }

    inner();
}

// inner(); // 내부함수는 함수 외부에서 접근 불가
outer();