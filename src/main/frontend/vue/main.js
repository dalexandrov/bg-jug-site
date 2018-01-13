import Vue from 'vue'
import VueRouter from 'vue-router'
import Articles from './Articles'
import Index from './Index'
import Header from './Header'
import Footer from './Footer'
import Intro from './Intro'
import Contacts from './Contacts'
import Article from './Article'

Vue.use(VueRouter)

const router = new VueRouter({
  routes:[
    {path: '/', redirect: '/index'},
    {path: '*', redirect: '/index'},
    {path:'/articles', component:Articles },
    {path:'/contacts', component:Contacts },
    {path:'/article/:id', name:'article' ,component:Article },
    {path:'/index', component:Index }
  ]
})

new Vue({
  el: '#bgjugapp',
  router:router,
  data() {
    return {
      msg:"BGJUG"
    }
  },
  components:{ 'siteHeader':Header, 'siteFooter':Footer,'intro':Intro }
})
