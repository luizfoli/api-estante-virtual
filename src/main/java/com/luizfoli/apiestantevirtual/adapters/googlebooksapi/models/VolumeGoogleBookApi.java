package com.luizfoli.apiestantevirtual.adapters.googlebooksapi.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VolumeGoogleBookApi {

    public String id;
    public String title;
    public String[] authors;
    public String publisher;
    public String publishedDate;
    public String description;
    public int pageCount;
    public int averageRating;
    public int ratingCount;
    public String imageLink;
}