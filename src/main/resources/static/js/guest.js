;
HotelCoupon = window.HotelCoupon || {};
HotelCoupon.GuestFn= function(){
    var guest = this;
    guest.$searchSel = "div.search-box span.search-click";
    guest.$searchInputSel = "div.search-box input";
    guest.$couponBtnSel = ".guest-list .coupon-btn";
    guest.$guestRowSel = ".guest-list .guest-row";
    guest.$logoClickableSel = ".banner .logo-left-clickable, .banner .logo-content";
    guest.search = function(){
        var searchKey = $(guest.$searchInputSel).val().toLowerCase().trim();
        console.log($(guest.$guestRowSel));
        $(guest.$guestRowSel).each(function(){
            var currentFirstName = $($(this).find("ul>li")[0]).html().toLowerCase();
            var currentLastName = $($(this).find("ul>li")[1]).html().toLowerCase();
            if(currentFirstName.indexOf(searchKey)<0 && currentLastName.indexOf(searchKey)<0){
                $(this).removeClass("hidden").addClass("hidden");
            }else{
                $(this).removeClass("hidden");
            }
        });
    };
    guest.generateCoupon = function(guestId){
        location.href="/coupon?guestId="+guestId;
    };
    guest.init = function(){
        $(guest.$searchSel).click(function(){
            guest.search();
        });
        $(guest.$searchInputSel).on('keyup', function (e) {
            if (e.keyCode == 13) {
                guest.search();
            }
        });
        $(guest.$couponBtnSel).click(function(){
            var guestId = $(this).prev().val();
            guest.generateCoupon(guestId);
        });
        $(guest.$logoClickableSel).click(function(){
            window.location.reload();
        });
    };
};
$(function(){
    var guest = new HotelCoupon.GuestFn();
    guest.init();
});