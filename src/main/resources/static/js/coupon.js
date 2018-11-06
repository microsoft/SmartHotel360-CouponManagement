;
HotelCoupon = window.HotelCoupon || {};
HotelCoupon.CouponFn= function(){
    var coupon = this;
    coupon.$printPopupTriggerSel = ".print-btn.popup,.coupon-item";
    coupon.$printPopupPreviewSel = ".print-btn.preview";
    coupon.$printPopupSel = ".coupon-item-detail.modal";
    coupon.$printDetailSel = ".coupon-item-detail";
    coupon.$contentSel = ".coupon.content";
    coupon.$contentCloseModalSel = ".coupon-item-detail .modal-content .close-modal";
    coupon.$printPopupAttr = "value";
    coupon.$modalHidden = "hidden";
    coupon.$logoClickableSel = ".banner .logo-left-clickable, .banner .logo-content";
    coupon.getPopupDetail = function($coupon){
        var couponId = $coupon.attr(coupon.$printPopupAttr);
        var $targetCouponPopup = $(coupon.$printPopupSel).filter(function(){
            return $(this).attr(coupon.$printPopupAttr)===couponId;
        });
        return $targetCouponPopup;
    }
    coupon.popupDetail = function($couponPopup,ifShow){
        $(coupon.$printDetailSel).addClass(coupon.$modalHidden);
        if(ifShow===true)
            $couponPopup.removeClass(coupon.$modalHidden);
    };
    coupon.print = function($couponPopup){
        $(".coupon.content").append($couponPopup.clone());
        setTimeout(function(){
            window.print();
            $(coupon.$contentSel).children().last().remove();
        });
    };
    coupon.init = function(){
        $(coupon.$printPopupTriggerSel).click(function(){
            var $targetCouponPopup = coupon.getPopupDetail($(this));
            coupon.popupDetail($targetCouponPopup,true);
            return false;
        });
        $(coupon.$printPopupPreviewSel).click(function(){
            var $targetCouponPopup = coupon.getPopupDetail($(this));
            coupon.print($targetCouponPopup);
        });
        $(coupon.$contentCloseModalSel).click(function(){
            var $targetCouponPopup = coupon.getPopupDetail($(this));
            coupon.popupDetail($targetCouponPopup,false);
            return false;
        });
        $(coupon.$logoClickableSel).click(function(){
            window.location.href="/guest";
        });
    };
};
$(function(){
    var coupon = new HotelCoupon.CouponFn();
    coupon.init();
});

