import { createApp } from 'vue' // const {createApp} = Vue; 하던 것을 import를 통해 다른 파일에 있던 것을 가져옴

import App from './App.vue'

createApp(App).mount('#app')
