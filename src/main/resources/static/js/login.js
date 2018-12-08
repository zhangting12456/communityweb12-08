$(function () {
    $('.third-hyperlink span:nth-of-type(1)').hover(function () {
        // over
        $('.third-hyperlink span:nth-of-type(1) img').attr('src', 'image/weixin1.png');
    }, function () {
        // out
        $('.third-hyperlink span:nth-of-type(1) img').attr('src', 'image/weixin.png');
    }
    );
    $('.third-hyperlink span:nth-of-type(2)').hover(function () {
         $('.third-hyperlink span:nth-of-type(2) img').attr('src', 'image/qq2.png');
    }, function () {
         $('.third-hyperlink span:nth-of-type(2) img').attr('src', 'image/qq1.png');
    }
    );
   $('.login-main').hover(function(){
    var vrifyCode = $("input[name='vrifyCode']").val();
    var name = $("input[name='username']").val();
    var password = $("input[name='password']").val();
    if(vrifyCode!=''&& name!=''&& password!=''){
          $('#login_btn').css('background-color', '#F6B940'); 
          $('.login-btn').css('color', '#FFFFFF');
          $('#register-btn').css('background-color', '#DE333B');
    }else{
        $('#login_btn').css('background-color', 'rgba(239,239,239,1)'); 
        $('.login-btn').css('color', 'rgba(120,120,120,1)');
        $('#register-btn').css('background-color', 'rgba(239,239,239,1)');
    }
   }); 
    $('#register-btn').click(function(){
        window.location.href="register.html";
    });
});
