package tomerbu.edu.songdbhelper.models;


public class Song {
    private String title;
    private String id;
    private String artist;
    private String duration;
    private String imageURI;

    public Song() {
    }

    public Song(String title, String id, String artist, String duration, String imageURI) {
        this.title = title;
        this.id = id;
        this.artist = artist;
        this.duration = duration;
        this.imageURI = imageURI;
    }

    public Song(String title, String artist, String duration, String imageURI) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.imageURI = imageURI;
    }

    public String getImageURI() {
        return imageURI;
    }

    public void setImageURI(String imageURI) {
        this.imageURI = imageURI;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", id='" + id + '\'' +
                ", artist='" + artist + '\'' +
                ", duration='" + duration + '\'' +
                ", imageURI='" + imageURI + '\'' +
                '}';
    }
}
