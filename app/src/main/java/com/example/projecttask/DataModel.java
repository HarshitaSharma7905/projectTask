package com.example.projecttask;

import android.media.Image;

public class DataModel {
    private String id;
    private String url;
    private String name;
    private String type;
    private String language;
    private String status;
    private String runtime;
    private String averageRuntime;
    private String premiered;
    private String ended;
    private String officialSite;
    private APIImage image;

    public DataModel(String id, String url, String name, String type, String language, String status, String runtime, String averageRuntime, String premiered, String ended, String officialSite) {
        this.id = id;
        this.url = url;
        this.name = name;
        this.type = type;
        this.language = language;
        this.status = status;
        this.runtime = runtime;
        this.averageRuntime = averageRuntime;
        this.premiered = premiered;
        this.ended = ended;
        this.officialSite = officialSite;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getLanguage() {
        return language;
    }

    public String getStatus() {
        return status;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getAverageRuntime() {
        return averageRuntime;
    }

    public String getPremiered() {
        return premiered;
    }

    public String getEnded() {
        return ended;
    }

    public String getOfficialSite() {
        return officialSite;
    }

    public APIImage getImage() {
        return image;
    }

    public class APIImage{
        private String medium;

        public String getMedium() {
            return medium;
        }
    }
}