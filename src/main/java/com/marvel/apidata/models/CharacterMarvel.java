package com.marvel.apidata.models;

import java.util.Date;

public class CharacterMarvel {

    private int id;
    private String name;
    private String description;
    private Date modified;
    private String resourceURI;
    private String[] urls;
    private Object thumbnail; // Crear modelo tipo imagen 
    private Object comics; //  ResourceList
    private Object stories;
    private Object events;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Date getModified() {
        return modified;
    }
    public void setModified(Date modified) {
        this.modified = modified;
    }
    public String getResourceURI() {
        return resourceURI;
    }
    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }
    public String[] getUrls() {
        return urls;
    }
    public void setUrls(String[] urls) {
        this.urls = urls;
    }
    public Object getThumbnail() {
        return thumbnail;
    }
    public void setThumbnail(Object thumbnail) {
        this.thumbnail = thumbnail;
    }
    public Object getComics() {
        return comics;
    }
    public void setComics(Object comics) {
        this.comics = comics;
    }
    public Object getStories() {
        return stories;
    }
    public void setStories(Object stories) {
        this.stories = stories;
    }
    public Object getEvents() {
        return events;
    }
    public void setEvents(Object events) {
        this.events = events;
    }    
}
