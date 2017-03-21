/**
 * Created by Auser on 2017/3/2.
 */
Ext.define('OnlyStore.store.main.NavigationTree', {
    extend: 'Ext.data.TreeStore',
    storeId: 'NavigationTree',

    autoLoad: true,
    fields: [{
        name: 'text'
    }],

    root: {
        expanded: true,
        children: [
            //{
            //    text: 'Dashboard',
            //    iconCls: 'x-fa fa-desktop',
            //    routeId: 'mainlist', // routeId defaults to viewType
            //    viewType: 'mainlist',
            //    view: 'OnlyStore.view.common.main.List',
            //    leaf: true
            //},
            //{
            //    text: 'Email',
            //    iconCls: 'x-fa fa-send',
            //    leaf: true
            //},
            //{
            //    text: 'Profile',
            //    iconCls: 'x-fa fa-user',
            //    leaf: true
            //},
            //{
            //    text: 'Search results',
            //    iconCls: 'x-fa fa-search',
            //    leaf: true
            //},
            //{
            //    text: 'Pages',
            //    iconCls: 'x-fa fa-leanpub',
            //    expanded: false,
            //    selectable: false,
            //    //routeId: 'pages-parent',
            //    //id: 'pages-parent',
            //
            //    children: [
            //        {
            //            text: 'Login',
            //            iconCls: 'x-fa fa-check',
            //            viewType: 'login',
            //            leaf: true
            //        }
            //    ]
            //}
        ]
    },

    proxy: {
        type: 'direct',
        directFn: 'navigationAction.getNavigation'
    }
});