public class Movie {
    private int movie_id,publication_year,duration;
    private String title,description,cover_image,URL,movie_genre,movie_cast,movie_directors;

    public Movie(int movie_id,String title,String description,String cover_image){

        this(movie_id,title,description,cover_image,0,0,null);
    }

    public Movie(int movie_id,String title,String description,String cover_image,int publication_year,int duration,String URL){
        this(movie_id,title,description,cover_image,publication_year,duration,URL,null,null,null);
    }



    public Movie(int movie_id, String title, String description, String cover_image, int publication_year, int duration, String URL, String movie_genre, String movie_directors, String movie_cast){
        this.movie_id=movie_id;
        this.title=title;
        this.description=description;
        this.cover_image=cover_image;
        this.publication_year=publication_year;
        this.duration=duration;
        this.URL=URL;
        this.movie_genre=movie_genre;
        this.movie_cast=movie_cast;
        this.movie_directors=movie_directors;

    }
    public int getMovie_id() {
        return movie_id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCover_image() {
        return cover_image;
    }

    private int getDuration() {
        return duration;
    }

    public String getDurationTime(){
        int totalMinutes = getDuration();
        int hours = totalMinutes/60;
        int minutes = totalMinutes%60;
        String durationTime = hours + "h" + " " +minutes+ "m";
        return durationTime;
    }

    public int getPublication_year() {
        return publication_year;
    }

    public String getURL() {
        return URL;
    }

    public String getMovie_genre() {
        return movie_genre;
    }

    public String getMovie_cast() {
        return movie_cast;
    }

    public String getMovie_directors() {
        return movie_directors;
    }
}
