<template>
  <!-- Footer Start -->
  <footer class="footer">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div class="footer-inner text-center">
            <div class="social-links">
              <a class="twitter social-link" data-placement="top"
                 data-toggle="tooltip" href="https://twitter.com/bgjug" title=
                   "Twitter"><i class="fa fa-twitter"></i></a>
              <a class="facebook social-link" data-placement=
                "top" data-toggle="tooltip" href="https://www.facebook.com/BGJUG/" title=
                   "Facebook"><i class="fa fa-facebook"></i></a>
              <a class="google-plus social-link" data-placement=
                "top" data-toggle="tooltip" href="#" title=
                   "Google+"><i class="fa fa-google-plus"></i></a>
              <a class="linkedin social-link" data-placement=
                "top" data-toggle="tooltip" href="#" title=
                   "LinkedIn"><i class="fa fa-linkedin"></i></a>
            </div>
            <ul class="footer-menu">
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
            <div class="copyright">
              <p>Copyright © 2018. Designed and Developed by
                <a href="http://jug.bg/">JUG.bg</a></p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </footer><!-- Footer End -->

</template>

<script>
  export default {}
</script>
