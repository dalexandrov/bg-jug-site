<template>
  <div class="container">
    <div class="row">
      <!-- Contact Info Start -->
      <div class="contact-info-wrapper clearfix">

        <div class="col-md-12">
          <div class="contact-item-wrapper">
            <div class="icon">
              <i class="ico-email"></i>
            </div>
            <h4>EMAIL</h4>
            <p>admin@jug.bg<br>
              admin@jug.bg</p>
          </div>
        </div>
      </div><!-- Contact Info End -->
      <div class="col-md-8 col-md-offset-2 contact-form">
        <form class="shake" data-toggle="validator" id=
          "contactForm" name="contactForm" role="form">
          <div class="col-md-12">
            <div class="form-group">
              <input class="form-control" data-error=
                "Please enter your name" id="name" placeholder=
                       "Your Name" required="" type="text">
              <div class="help-block with-errors"></div>
            </div>
            <div class="form-group">
              <input class="form-control" data-error=
                "Please enter your email" id="email"
                     placeholder="Your Email" required="" type=
                       "email">
              <div class="help-block with-errors"></div>
            </div>
            <div class="form-group">
              <input class="form-control" data-error=
                "Please enter your message subject" id=
                       "msg_subject" placeholder="Subject" required=""
                     type="text">
              <div class="help-block with-errors"></div>
            </div>
            <div class="form-group">
                                <textarea class="form-control" data-error=
                                  "Write your message" id="message" placeholder=
                                            "Massage" required="" rows="5">
</textarea>
              <div class="help-block with-errors"></div>
            </div>
          </div>
          <div class="col-md-12">
            <button class="btn btn-common btn-sn" id="submit"
                    type="submit">Send Message</button>
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
    export default {
    }
</script>
