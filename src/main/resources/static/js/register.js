$(function(){
      $('.login-main').hover(function () {
              // over
              var name = $("input[name='username']").val();
              var password = $("input[name='password']").val();
              var repassword = $("input[name='repassword']").val();
              var email = $("input[name='email']").val();
              var phone = $("input[name='phone']").val();
              var sex = $("input[name='sex']:checked").val();
              if(name!='' && password!='' && repassword!='' && email!='' && phone!='' && sex!=''){
                // color:white;
                // background:rgba(51,119,236,1);
                $('#register_btn').css('background', 'rgba(51,119,236,1)');
                $('#register_btn').css('color', 'white');
              }else{
                $('#register_btn').css('background', 'rgba(239,239,239,1)');
                $('#register_btn').css('color', 'rgba(120,120,120,1)');
              }
          }, function () {
              // out
          }
      );

}
);