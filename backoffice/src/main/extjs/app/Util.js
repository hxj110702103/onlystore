/**
 * Created by Auser on 2017/3/6.
 */
Ext.define('OnlyStore.Util', {
    singleton: true,

    requires: ['Ext.window.Toast'],

    getUrl: function(url) {
        url = "http://localhost:8081" + url;

        return url;
    }
});