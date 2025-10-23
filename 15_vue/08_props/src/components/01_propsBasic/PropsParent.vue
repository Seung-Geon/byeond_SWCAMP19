<template>
    <div>
        <PropsChild :message="message2"/>
    </div>
</template>

<script setup>
    import PropsChild from "./Props.Child.vue";
    import {ref} from 'vue';

    const message2 = ref('hello');

</script>

<style scoped>

</style>