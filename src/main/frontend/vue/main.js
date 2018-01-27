import Vue from 'vue'
import VueRouter from 'vue-router'
import Articles from './Articles'
import Index from './Index'
import Header from './Header'
import Footer from './Footer'
import Intro from './Intro'
import Contacts from './Contacts'
import Article from './Article'
import Login from'./Login'
import Dashboard from './Dashboard'

import store from './storage/store'

Vue.use(VueRouter)

const router = new VueRouter({
  routes:[
    {path: '/', redirect: '/index'},
    {path: '*', redirect: '/index'},
    {path:'/articles', component:Articles },
    {path:'/contacts', component:Contacts },
    {path:'/login', component:Login },
    {path:'/dashboard', component:Dashboard, meta:{requiresAuth:true} },
    {path:'/article/:id', name:'article' ,component:Article },
    {path:'/index', component:Index }
  ]
})

router.beforeEach((to,from,next)=>{
  console.log(to)
  if (to.meta.requiresAuth){
    const authUser = JSON.parse(window.localStorage.getItem('authUser'))
    if (authUser && authUser.access_token){
      next()
    }else{
      next({path:'/login'})
    }
  }
  next()
})

new Vue({
  el: '#bgjugapp',
  router:router,
  store:store,
  data() {
    return {
      msg:"BGJUG"
    }
  },
  components:{ 'siteHeader':Header, 'siteFooter':Footer,'intro':Intro }
})
