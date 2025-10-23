<template>
    <h1>{{ props.readValue }}</h1>
    <label>자식의 readValue:</label>
    <input type = "text" v-model = "props.readValue">   <!-- 변경이 되지 않음: readOnly -> v-model이 의미가 없음 -->
</template>

<script setup>

    import {defineProps} from 'vue';

    const props = defineProps({
        readValue: String
    });
</script>

<style scoped>

</style>