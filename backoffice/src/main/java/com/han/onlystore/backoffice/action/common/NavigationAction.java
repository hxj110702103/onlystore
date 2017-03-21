package com.han.onlystore.backoffice.action.common;

import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;
import ch.ralscha.extdirectspring.annotation.ExtDirectMethodType;
import com.han.onlystore.backoffice.dto.NavigationNode;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amy on 2017/3/10.
 */
@Component
public class NavigationAction {
    private static final String SITEMAP = "sitemap/sitemap.xml";

    @ExtDirectMethod(ExtDirectMethodType.TREE_LOAD)
    public List<NavigationNode> getNavigation() {
        List<NavigationNode> navigationList = new ArrayList<>();
        navigationList.addAll(this.generateNavigations().getChildren());

        return navigationList;
    }

    public NavigationNode generateNavigations() {
        ClassPathResource pathResource = new ClassPathResource(SITEMAP);
        String xml;
        try{
            xml = StreamUtils.copyToString(pathResource.getInputStream(), StandardCharsets.UTF_8);
        }catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("failed to generateNodes", e);
        }

        XStream xStream = new XStream(new DomDriver());
        xStream.processAnnotations(NavigationNode.class);

        return (NavigationNode)xStream.fromXML(xml);

    }
}
