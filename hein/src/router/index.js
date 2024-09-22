import Vue from 'vue'
import VueRouter from 'vue-router'
import BoardList from '../components/BoardList.vue'
import PostDetail from '../components/PostDetail.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'BoardList',
    component: BoardList
  },
  {
    path: '/post/:id',
    name: 'PostDetail',
    component: PostDetail,
    props: true  // 이 옵션으로 라우터에서 전달받은 파라미터를 컴포넌트에 prop으로 넘길 수 있음
  }
]

const router = new VueRouter({
  mode: 'history',
  routes
})

export default router