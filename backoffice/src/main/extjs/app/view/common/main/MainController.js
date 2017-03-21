/**
 * This class is the controller for the main view for the application. It is specified as
 * the "controller" of the Main view class.
 *
 * TODO - Replace this content of this view to suite the needs of your application.
 */
Ext.define('OnlyStore.view.common.main.MainController', {
    extend: 'Ext.app.ViewController',

    alias: 'controller.main',

    // # = application
    // * = any controller
    listen: {
        controller: {
            '*': {
                'signedIn': 'onSignedIn',
                'noSignedIn': 'onNoSignedIn'
            }
        }
    },
    routes: {
        'common.auth.Login': {
            action: 'onLoginRouteChange'
        },
        ':node': {
            action: 'onRouteChange',
            conditions: {
                ':node': '(?!common)(?!image)([a-z\\.]+)'
            }
        }
    },

    onRouteChange: function(id) {
        this.setCurrentView(id);
    },

    onLoginRouteChange: function() {
        this.setCurrentView("common.auth.Login", true)
    },
    /**
     * 跳转页面
     * @param hashTag
     */
    setCurrentView: function(hashTag, isLogin) {
        var me = this,
            viewModel = me.getViewModel(),
            refs = me.getReferences(),
            mainCard = refs.mainCardPanel,
            mainLayout = mainCard.getLayout(),
            navigationList = refs.navigationTreeList,
            store = viewModel.getStore('navigationTree'),
            lastView = me.lastView,
            existingItem, view, newView;
        if(!isLogin) {
            hashTag = (hashTag || '').toLowerCase();
           var node = store.findNode('routeId', hashTag);
           view = (node && node.get('view'));
            existingItem = mainCard.child('component[routeId=' + hashTag + ']');
        } else {
            view=hashTag;
        }
        // Kill any previously routed window
        if (lastView && lastView.isWindow) {
            lastView.destroy();
        }

        lastView = mainLayout.getActiveItem();

        if (!existingItem) {
            newView = Ext.create("OnlyStore.view."+view, {
                //xtype: view,
                routeId: hashTag,  // for existingItem search later
                hideMode: 'offsets'
            });
        }
        if (!newView || !newView.isWindow) {
            // !newView means we have an existing view, but if the newView isWindow
            // we don't add it to the card layout.
            if (existingItem) {
                // We don't have a newView, so activate the existing view.
                if (existingItem !== lastView) {
                    mainLayout.setActiveItem(existingItem);
                }
                newView = existingItem;
            }
            else {
                // newView is set (did not exist already), so add it and make it the
                // activeItem.
                Ext.suspendLayouts();
                mainLayout.setActiveItem(mainCard.add(newView));
                Ext.resumeLayouts(true);
            }
        }

        navigationList.setSelection(node);

        if (newView.isFocusable(true)) {
            newView.focus();
        }

        me.lastView = newView;
    },

    onItemSelected: function (sender, record) {
        Ext.Msg.confirm('Confirm', 'Are you sure?', 'onConfirm', this);
    },

    onConfirm: function (choice) {
        if (choice === 'yes') {
            //
        }
    },

    /**
     * 设置隐藏还是显示菜单目录
     */
    onToggleNavigationSize: function () {
        var me = this,
            refs = me.getReferences(),
            navigationList = refs.navigationTreeList,
            wrapContainer = refs.mainContainerWrap,
            collapsing = !navigationList.getMicro(),
            new_width = collapsing ? 64 : 250;

        if (Ext.isIE9m || !Ext.os.is.Desktop) {
            Ext.suspendLayouts();

            refs.senchaLogo.setWidth(new_width);

            navigationList.setWidth(new_width);
            navigationList.setMicro(collapsing);

            Ext.resumeLayouts(); // do not flush the layout here...

            // No animation for IE9 or lower...
            wrapContainer.layout.animatePolicy = wrapContainer.layout.animate = null;
            wrapContainer.updateLayout();  // ... since this will flush them
        }
        else {
            if (!collapsing) {
                // If we are leaving micro mode (expanding), we do that first so that the
                // text of the items in the navlist will be revealed by the animation.
                navigationList.setMicro(false);
            }

            // Start this layout first since it does not require a layout
            refs.senchaLogo.animate({dynamic: true, to: {width: new_width}});

            // Directly adjust the width config and then run the main wrap container layout
            // as the root layout (it and its chidren). This will cause the adjusted size to
            // be flushed to the element and animate to that new size.
            navigationList.width = new_width;
            wrapContainer.updateLayout({isRoot: true});
            navigationList.el.addCls('nav-tree-animating');

            // We need to switch to micro mode on the navlist *after* the animation (this
            // allows the "sweep" to leave the item text in place until it is no longer
            // visible.
            if (collapsing) {
                navigationList.on({
                    afterlayoutanimation: function () {
                        navigationList.setMicro(true);
                        navigationList.el.removeCls('nav-tree-animating');
                    },
                    single: true
                });
            }
        }
    },

    onNavigationTreeSelectionChange: function(tree, node) {
        if(node && node.get('routeId')) {
            this.redirectTo(node.get('routeId'));
        }
    },

    onSignedIn: function(event, param) {
        this.redirectTo('account.member.index');
    },

    onNoSignedIn: function() {
        this.redirectTo('common.auth.Login');
    }
});
