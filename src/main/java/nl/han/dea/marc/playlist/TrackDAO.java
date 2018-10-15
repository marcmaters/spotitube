package nl.han.dea.marc.playlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class TrackDAO implements Dao<Track> {

    private List<Track> hitzone1 = new ArrayList<>();

    public TrackDAO() {
        hitzone1.add(new Track("No woman no cry", "Bob Marley", "Album1", 3.41));
        hitzone1.add(new Track("Three little birds", "Bob Marley", "Album2", 3.04));
        hitzone1.add(new Track("No woman no cry", "Bob Marley", "Album1", 3.41));
        hitzone1.add(new Track("Three little birds", "Bob Marley", "Album2", 3.04));
        hitzone1.add(new Track("No woman no cry", "Bob Marley", "Album1", 3.41));
        hitzone1.add(new Track("Three little birds", "Bob Marley", "Album2", 3.04));
        hitzone1.add(new Track("No woman no cry", "Bob Marley", "Album1", 3.41));
        hitzone1.add(new Track("Three little birds", "Bob Marley", "Album2", 3.04));
        hitzone1.add(new Track("No woman no cry", "Bob Marley", "Album1", 3.41));
        hitzone1.add(new Track("Three little birds", "Bob Marley", "Album2", 3.04));
        hitzone1.add(new Track("No woman no cry", "Bob Marley", "Album1", 3.41));
        hitzone1.add(new Track("Three little birds", "Bob Marley", "Album2", 3.04));
    }

    @Override
    public Optional<Track> get(long id) {
        return Optional.ofNullable(hitzone1.get((int) id));
    }

    @Override
    public List<Track> getAll() {
        return hitzone1;
    }

    @Override
    public void save(Track track) {
        hitzone1.add(track);
    }

    @Override
    public void update(Track track, String[] params) {
        track.setName(Objects.requireNonNull(
                params[0], "Name cannot be null"));
        track.setArtist(Objects.requireNonNull(
                params[1], "Artist cannot be null"));
        track.setAlbum(Objects.requireNonNull(
                params[2], "Album cannot be null"));
//        track.setLength(Objects.requireNonNull(
//                params[3], "Lenght cannot be null"));

        hitzone1.add(track);
    }

    @Override
    public void delete(Track track) {
        hitzone1.remove(track);

    }

    public Track[] getHitzone1() {
        return hitzone1.toArray(new Track[0]);
    }

    public void setHitzone1(List<Track> hitzone1) {
        this.hitzone1 = hitzone1;
    }
}
