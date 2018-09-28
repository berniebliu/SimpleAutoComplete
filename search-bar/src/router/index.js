import Vue from 'vue'
import Router from 'vue-router'
import SearchBar from '@/components/SearchBar'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'SearchBar',
      component: SearchBar
    }
  ]
})
