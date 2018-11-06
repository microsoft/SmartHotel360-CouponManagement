;
HotelCoupon = window.HotelCoupon || {};
HotelCoupon.LoginFn = function(){
    var login = this;
    login.$formSel = "form";
    login.$submitBtnSel = "form .submit";
    login.$usernameSel = "form #inputUsername";
    login.$passwordSel = "form #inputPassword";
    login.submitLogin = function(){
        $(login.$formSel).submit();
    };
    login.init = function(){
        $(login.$submitBtnSel).click(function(){
            login.submitLogin();
        });
        $(login.$usernameSel).on('keyup', function (e) {
            if (e.keyCode == 13) {
                $(login.$passwordSel).get(0).focus();
            }
        });
    };
};
$(function(){
    var login = new HotelCoupon.LoginFn();
    login.init();
});