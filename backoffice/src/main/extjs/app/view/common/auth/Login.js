/**
 * Created by Auser on 2017/3/2.
 */
Ext.define('OnlyStore.view.common.auth.Login', {
    extend: 'OnlyStore.view.common.base.LockingWindow',

    xtype: 'login',
    title: '登录',
    controller: {
        xclass: 'OnlyStore.view.common.auth.AuthController'
    },

    items: [
        {
            xtype: 'authdialog',
            autoComplete: true,
            bodyPadding: '20 20',
            width: 415,
            layout: {
                type:'vbox',
                align: 'stretch'
            },
            defaults: {
                margin: '5 0'
            },
            url: OnlyStore.Util.getUrl('/login'),
            items: [
                {
                    xtype: 'label',
                    text: '登录到您的账号'
                },
                {
                    xtype: 'textfield',
                    name: 'username',
                    emptyText: '输入您的登录名',
                    allowBlank: false,
                    height: 55
                },
                {
                    xtype: 'textfield',
                    name: 'password',
                    inputType: 'password',
                    emptyText: '输入密码',
                    allowBlank: false,
                    height: 55
                },
                {
                    xtype: 'button',
                    text: '登录',
                    ui: 'soft-green',
                    iconCls: 'x-fa fa-angle-right',
                    iconAlign: 'right',
                    scale: 'large',
                    formBind: true,
                    handler: 'onLoginClick'
                }
            ]
        }
    ]
});