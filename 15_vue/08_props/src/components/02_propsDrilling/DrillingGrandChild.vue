<template>
    <div>
        <h3>GrandChild: {{ injectedCount }}</h3>
        <button @click = "injectedCount++;">GrandChild에서 값 증가</button> <!-- 하위 컴포넌트가 상위 컴포넌트의 상태를 변경함 -->
    </div>
</template>

<script setup>
    import {inject} from 'vue'

    const injectedCount = inject('count');  // 직접 접근
                                            // 이런 방식 지양
                                            // 개발은 편하지만 유지보수가 어려움
                                            // provide에 담은 변수들을 사용하는 것들을 찾을 때 일일이 찾아야 한다.
                                            // getter
</script>

<style scoped>

</style>