<template>
    <div>
        <h3>전달 받은 props: {{ props.message }}</h3>
    </div>
</template>

<script setup>
    import {defineProps} from 'vue';

    // 변숫 수정이 부모에게 영향을 주지 않게 하기 위한 추가 작업
    const props = defineProps({
        message: String
    });

        /* 1. 기본 자료형 (Primitive Types) */
    // const props = defineProps({
    //     message: String,
    //     count: Number,
    //     isActive: Boolean,
    //     items: Array,
    //     user: Object,
    //     createdAt: Date,
    //     callback: Function,
    //     id: Symbol
    // });

    // 권장X, 복잡해짐
    /* 2. 여러 타입 허용 */
    // const props = defineProps({
    //     value: [String, Number],
    //     data: [Array, Object]
    // });
</script>

<style scoped>

</style>