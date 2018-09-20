$(function () {
    $(".validate-code a").bind('click',refreshValidateCode);
    $(".validate-code img").bind('click',refreshValidateCode);
    
    function refreshValidateCode() {
        $(".validate-code img").attr('src','/captcha?r=' +Math.random());
    }
});