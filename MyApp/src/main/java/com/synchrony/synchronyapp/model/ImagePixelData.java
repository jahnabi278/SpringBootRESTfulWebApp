package com.synchrony.synchronyapp.model;

import java.util.List;

import lombok.Data;

@Data
public class ImagePixelData {
	private String id;
	private String deletehash;
	private String account_id;
	private String account_url;
	private Integer ad_type;
	private String ad_url;
	private String title;
	private String description;
	private String name;
	private String type;
	private int width;
	private int height;
	private int size;
	private int views;
	private String section;
	private String vote;
	private long bandwidth;
	private boolean animated;
	private boolean favorite;
	private boolean in_gallery;
	private boolean in_most_viral;
	private boolean has_sound;
	private boolean is_ad;
	private Boolean nsfw;
	private String link;
	private List<String> tags;
	private long datetime;
	private String mp4;
	private String hls;

}
