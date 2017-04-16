require("/components/jquery/jquery.js")

module.exports = function(nav) {
    var $nav = $(nav);
    var mobileCode = "";
    var nameRex=/^.{2,}$/;
    var mobileRex = /^1[3|4|5|7|8][0-9]{9}$/;
    var emailRex = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
    var addressRex = /^.{5,}$/
    var inviteCodeRex = /^[a-zA-Z0-9]{8,10}&/;
    var addressRex = /^.{5,}$/;
    var inviteCodeRex = /^[a-zA-Z0-9]{8,10}&/;

    //切换tab
    $('.navbar .navbar__item[data-type=type]').click(function () {
        $('.navbar .navbar__item').removeClass('bar__item_on');
        $(this).addClass('bar__item_on');
        $('.info_content').hide();
        $('.info_content[data-type='+$(this).data('type')+']').show();
    });

    //切换类型
    $('.select_type .info_item').click(function() {
        $('.select_type .info_item').removeClass('selected');
        $(this).addClass('selected');

        $('.info_content .info_data').hide();
        $('.info_content .info_data[data-type='+$(this).data('type')+']').show();

        //显示资料完善信息
        $('.navbar .navbar__item').removeClass('bar__item_on');
        $('.navbar .navbar__item[data-type=info]').addClass('bar__item_on');
        $('.info_content').hide();
        $('.info_content[data-type=info]').show();
    });
};