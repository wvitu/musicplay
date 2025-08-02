package br.com.vitor.musicplay.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LastFmArtistResponse {

    @JsonProperty("artist")
    private Artist artist;

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Artist {
        private String name;

        @JsonProperty("country")
        private String country;

        @JsonProperty("tags")
        private Tags tags;

        @JsonProperty("bio")
        private Bio bio;

        // Getters e Setters

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Tags getTags() {
            return tags;
        }

        public void setTags(Tags tags) {
            this.tags = tags;
        }

        public Bio getBio() {
            return bio;
        }

        public void setBio(Bio bio) {
            this.bio = bio;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Tags {
        @JsonProperty("tag")
        private Tag[] tag;

        public Tag[] getTag() {
            return tag;
        }

        public void setTag(Tag[] tag) {
            this.tag = tag;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Tag {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Bio {
        private String summary;

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }
    }
}
