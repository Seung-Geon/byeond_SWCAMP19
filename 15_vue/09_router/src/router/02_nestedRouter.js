import {createRouter, createWebHistory} from 'vue-router';

// import HomeView from '@/views/01_router/HomeView.vue';
// import NestedHome from '@/views/02_nestedRouter/NestedHome.vue';
// import RootRouter from '@/views/02_nestedRouter/RootRouter.vue';
// import NestedView from '@/views/02_nestedRouter/NestedView.vue';

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: '/',
            // component: HomeView
            component: () => import('@/views/01_router/HomeView.vue')
        },
        {
            path: '/nested',
            // component: RootRouter,
            component: () => import('@/views/02_nestedRouter/RootRouter.vue'),

            /* children 이후(중첩된 라우팅) 경로는 '/'를 사용하면 안된다.(첫 경로는 '/'를 써야함) */
            children: [
                {
                    path: 'home',
                    /*
                        lazy loaded: 코드를 분할(청크)해서 필요한 시점에 가져옴으로써 메모리 낭비를 줄이고
                                    속도 및 성능 향상을 도모할 수 있다.(코드 스플리팅)
                    */
                    // component: NestedHome   // /nested/home                          // 입 방식으로 할 경우 첫 화면에서도 모든 컴포넌트를 가져온 상태로 비효율적인 상황
                    component: () => import('@/views/02_nestedRouter/NestedHome.vue')   // 호출되어서 그려질때 import (code spliting)
                                                                                        // 이렇게 안하면 너무 비효율적이라 무조건 해줘야 함

                },
                {
                    path: 'view',
                    // component: NestedView   // /neste/view
                    component: () => import('@/views/02_nestedRouter/NestedView.vue')
                }
            ]
        }

    ]
})

export default router;