Ext.define('OnlyStore.view.common.auth.AuthController', {
    extend: 'Ext.app.ViewController',

    onLoginClick: function (btn) {
        var me = this,
            form = btn.up('form');
        form.submit({
            waitMsg: '登录中...',
            clientValidation: true,
            success: function (form, action) {
                if(action.result.success) {
                    me.fireEvent('signedIn', null);
                }
            }
        })

    }

});