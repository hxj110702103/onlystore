/**
 * Created by Auser on 2017/3/2.
 */
Ext.define('OnlyStore.view.common.base.LockingWindow', {
    extend: 'Ext.window.Window',

    requires: [
        'Ext.layout.container.VBox',
        'Ext.window.Window'
    ],

    cls: 'auth-locked-window',
    closable: false,
    resizable: false,
    autoShow: true,
    titleAlign: 'center',
    maximized: true,
    modal: true,

    layout: {
        type: 'vbox',
        align: 'center',
        pack: 'center'
    }
});