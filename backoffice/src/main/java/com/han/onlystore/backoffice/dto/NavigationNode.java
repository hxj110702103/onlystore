package com.han.onlystore.backoffice.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import java.util.*;

/**
 * Created by Amy on 2017/3/10.
 */
@XStreamAlias("menu")
public class NavigationNode {

    @XStreamAsAttribute
    @XStreamAlias("text")
    private String text;

    @XStreamAsAttribute
    @XStreamAlias("view")
    private String view;

    @XStreamAsAttribute
    @XStreamAlias("routeId")
    private String routeId;

    @XStreamAsAttribute
    @XStreamAlias("iconCls")
    private String iconCls;

    @XStreamAlias("children")
    private final List<NavigationNode> children = new ArrayList<>();

    @XStreamAlias("leaf")
    @XStreamAsAttribute
    private boolean leaf = false;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public List<NavigationNode> getChildren() {
        return children;
    }

    public boolean getLeaf() {
        if(this.getChildren() == null) {
            return true;
        }

        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }
}
