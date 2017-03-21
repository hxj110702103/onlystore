/**
 * This class is the view model for the Main view of the application.
 */
Ext.define('OnlyStore.view.common.main.MainModel', {
    extend: 'Ext.app.ViewModel',

    alias: 'viewmodel.main',

    data: {
        name: 'OnlyStore',

        loremIpsum: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'
    },
    stores: {
        members: {
            model: 'OnlyStore.model.account.Member',
            autoLoad: true,
            remoteFilter: true,
            remoteSorter: true
        },
        navigationTree: {
            xclass: 'OnlyStore.store.main.NavigationTree'
        }
    }

    //TODO - add data, formulas and/or methods to support your view
});
