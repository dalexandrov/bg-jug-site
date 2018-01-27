<template>
  <div class="container">
    <p>
      Logged in to dashboard!
    </p>
    <p>
      {{ userStore }}
    </p>

    <form class="shake" data-toggle="validator" id=
      "logouForm" name="logoutForm" role="form"
          v-on:submit.prevent="handleLogout()">
      <div class="col-md-12">
        <button class="btn btn-common btn-sn" id="btnSubmit"
                type="submit">Logout
        </button>
        <div class="h3 text-center hidden" id="msgSubmit">
        </div>
        <div class="clearfix"></div>
      </div>
    </form>

  </div>

</template>

<script>
  import {mapState} from 'vuex'

  export default {
    computed: {
      ...mapState({
        userStore: state => state.userStore
      })
    },
    created() {

    },
    methods: {
      handleLogout() {
        this.$store.dispatch('clearAuthUser')
        window.localStorage.removeItem('authUser')
        this.$router.push({path: '/login'})
      }
    }
  }
</script>

