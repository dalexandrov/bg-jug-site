<template>

  <header class="site-header">
    <nav class="navbar navbar-default navbar-intimate role="
         data-offset-top="50" data-spy="affix">
      <div class="container">
        <div class="navbar-header">
          <!-- Start Toggle Nav For Mobile -->
          <button class="navbar-toggle" data-target="#navigation"
                  data-toggle="collapse" type="button"><span class="sr-only">Toggle navigation</span> <span
            class=
              "icon-bar"></span> <span class="icon-bar"></span>
            <span class="icon-bar"></span></button>
          <div class="logo">
            <router-link to="/index" class="navbar-brand">
            <img src="img/logo.png"/></router-link>
          </div>
        </div><!-- Stat Search -->
        <div class="side">
          <a class="show-search"><i class="ico-search"></i></a>
        </div><!-- Form for navbar search area -->
        <form class="full-search">
          <div class="container">
            <div class="row">
              <input class="form-control" placeholder="Search"
                     type="text"> <a class="close-search"><span class="ico-times"></span></a>
            </div>
          </div>
        </form><!-- Search form ends -->
        <!-- Navigation Start -->
        <div class="navbar-collapse collapse" id="navigation">
          <ul class="nav navbar-nav navbar-right">
            <li>
              <router-link to="/index">Home</router-link>
            </li>
            <li>
              <router-link to="/articles">Articles</router-link>
            </li>
            <li>
              <router-link to="/contacts">Contacts</router-link>
            </li>
          </ul>
        </div><!-- Navigation End -->
      </div>
    </nav><!-- Mobile Menu Start -->
    <ul class="wpb-mobile-menu">
      <li class="active">
        <router-link to="/index">Home</router-link>
      </li>
      <li>
        <router-link to="/articles">Articles</router-link>
      </li>
      <li>
        <router-link to="/contacts">Contacts</router-link>
      </li>
    </ul><!-- Mobile Menu End -->
  </header>
</template>

<script>
  export default {}
</script>

<style scoped>

</style>
