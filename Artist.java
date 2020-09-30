package Question2;

import java.util.ArrayList;
import java.util.Arrays;

public class Artist {

    private String singer;
    private Length length;

    public Artist(String singer, Length length) {
        this.singer = singer;
        this.length = length;
    }

    public void setLength(Length length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return  singer + " " + length;
    }

    public static ArrayList<Artist> accumulate(ArrayList<Song> songs){

        ArrayList<Artist> allArtists = new ArrayList<>();

        for(int i=0; i< songs.size(); i++){

            String singer = songs.get(i).getSinger();
            Length length = songs.get(i).getLength();
            Artist newArtist = new Artist(singer, length);
            allArtists.add(newArtist);

        }

        for(int i=0; i<allArtists.size(); i++){

            Artist temp = allArtists.get(i);
            String singer = allArtists.get(i).singer;
            Length l1 = allArtists.get(i).length;

            for(int j=i+1; j<allArtists.size(); j++){
                if(singer.equals(allArtists.get(j).singer)){
                    l1.add(allArtists.get(j).length);
                    temp.setLength(l1);
                    allArtists.set(i,temp);
                    allArtists.remove(i);
                }
            }
        }

        return allArtists;

    }

    public static void main(String[] args) {

        Song s1 = new Song("Adele", "Skyfall", new Length(4,49));
        Song s2 = new Song("Macklemore", "Ain't gonna die", new Length(3,34));
        Song s3 = new Song("Adele", "Rolling in the Deep", new Length(3,53));
        Song s4 = new Song("Adele", "Set fire to the rain", new Length(4,02));

        ArrayList<Song> songs = new ArrayList<>(Arrays.asList(new Song[]{s1,s2,s3,s4}));

        System.out.println(accumulate(songs));

    }

    public static class Song {

        private String singer;

        private String title;

        private Length length;

        public Song(String singer, String title, Length length) {
            this.singer = singer;
            this.title = title;
            this.length = length;
        }

        public String getSinger() {
            return singer;
        }

        public Length getLength(){
            return length;
        }

        public void setLength(Length length) {
            this.length = length;
        }

        @Override
        public String toString() {
            return "singer='" + singer + '\'' +
                    ", title='" + title + '\'' +
                    ", length=" + length;
        }
    }
}

