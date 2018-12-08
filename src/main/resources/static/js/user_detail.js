$(function(){

    $(".update_btn").click(function (e) { 
        e.preventDefault();
        $(this).parent('td').siblings('td').find('input').attr('placeholder', '信息不能为空');
        $(this).parent('td').siblings('td').find('input').removeAttr('disabled').focus();
        
    });

});

