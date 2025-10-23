<!-- 
    부모로부터 전달된 이벤트(사용자 정의형)를 활용해 부모의 이벤트를 발생시켜 부모의
    이벤트 핸들러 함수를 실행한다.
    (자식 컴포넌트가 부모 컴포넌트로 발산(emit('원하는 이벤트명')))
-->
<template>
    <!-- 반대로 부모에게 영향을 줘야하는 경우가 있음: ex) 다크모드 -->
    <button @click = "emit('toggle')">다크 모드 토글</button>
</template>

<script setup>
    import {defineEmits} from 'vue';

    const emit = defineEmits(['toggle']);
</script>

<style scoped>

</style>