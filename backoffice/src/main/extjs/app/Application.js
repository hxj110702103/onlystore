/**
 * The main application class. An instance of this class is created by app.js when it
 * calls Ext.application(). This is the ideal place to handle application launch and
 * initialization details.
 */
Ext.define('OnlyStore.Application', {
    extend: 'Ext.app.Application',
    
    name: 'OnlyStore',

    stores: [
        // TODO: add global / shared stores here
    ],
    
    launch: function () {
        var me = this;
        // TODO - Launch the application
        Ext.direct.Manager.addProvider(Ext.app.REMOTING_API);

        securityAction.getLoginedUser(function(user) {
            if(user) {
                me.fireEvent("signedIn", me);
            }else {
                me.fireEvent("noSignedIn", me);
            }
        })
    }

    //onAppUpdate: function () {
    //    Ext.Msg.confirm('Application Update', 'This application has an update, reload?',
    //        function (choice) {
    //            if (choice === 'yes') {
    //                window.location.reload();
    //            }
    //        }
    //    );
    //}
});
