<template>
  <div class="container">
    <div class="row">
      <!-- Contact Info Start -->
      <div class="contact-info-wrapper clearfix">

      </div><!-- Contact Info End -->
      <div class="col-md-8 col-md-offset-2 contact-form">
        <form class="shake" data-toggle="validator" id=
          "loginForm" name="loginForm" role="form"
              v-on:submit.prevent="handleLoginFormSubmit()">
          <div class="col-md-12">
            <div class="form-group">
              <input class="form-control" id="username"
                     placeholder="Username" required="true" type=
                       "text" v-model="login.username">
              <div class="help-block with-errors"></div>
            </div>
            <div class="form-group">
              <input class="form-control" id=
                "password" placeholder="Password" required="true"
                     type="password" v-model="login.password">
              <div class="help-block with-errors"></div>
            </div>
          </div>
          <div class="col-md-12">
            <button class="btn btn-common btn-sn" id="btnSubmit"
                    type="submit">Login
            </button>
            <div class="h3 text-center hidden" id="msgSubmit">
            </div>
            <div class="clearfix"></div>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
  import axios from 'axios';
  import {clientId,clientSecret,scope} from "./config/security";
  import {oauthPath} from "./config/config";
  import {mapState} from 'vuex'

  export default {
    computed: {
      ...mapState({
        userStore: state => state.userStore
      })
    },
    data() {
      return {
        login: {
          username: 'mitia',
          password: 'password'
        }
      }
    },
    methods: {
      handleLoginFormSubmit() {
        const authUser={};

        //FIXME: redesign this, looks ugly but still works somehow...
        axios.post(oauthPath+'?grant_type=password&client_id='+clientId+'&client_secret='+clientSecret+'&username='+this.login.username+'&password='+this.login.password)
          .then(response => {
            console.log(response.data)
            authUser.access_token = response.data.access_token
            authUser.refresh_token = response.data.refresh_token
            window.localStorage.setItem('authUser',JSON.stringify(authUser))
            const userObj = JSON.parse(window.localStorage.getItem('authUser'))
            this.$store.dispatch('setUserObject', userObj)
            this.$router.push({path:'/dashboard'})

          })
          .catch(e => {
            this.errors.push(e)
          })
      }
    },
  }
</script>
