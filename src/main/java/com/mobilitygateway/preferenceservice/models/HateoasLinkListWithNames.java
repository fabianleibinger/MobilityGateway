package com.mobilitygateway.preferenceservice.models;

import java.util.List;

public class HateoasLinkListWithNames {
    private List<Link> links;
    private List<String> names;

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }
}
