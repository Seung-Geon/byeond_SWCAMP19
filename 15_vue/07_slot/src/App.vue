<!-- 
  다른 파일을 불러올 때는 상대경로(./) 또는 src부터의 경로인 절대경로(@)를 사용할 수 있다.

  상황에 따라 더 유리한 방법을 선택
-->
<script setup>
  // import MyComponent from './component/01_component/MyComponent.vue';  // 상대 경로
  import MyComponent from '@/component/01_component/MyComponent.vue';     // @로 시작하면 src 부터 시작하는 일종의 절대 경로
  import SlotParent from './component/02_slotintro/SlotParent.vue';
  import NamedParent from './component/03_namedslot/NamedParent.vue';
  import DynamicParent from './component/04_dynamicslot/DynamicParent.vue'
</script>

<template>
  <header>
    <div class = 'redColor'>
      <MyComponent/>
    </div>
  </header>
  <main>
    <SlotParent/>
    <NamedParent/>
    <DynamicParent/>
  </main>
</template>

<style scoped>
  .redColor {
    color: red;

  }
</style>
