package nl.han.dea.marc.playlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PlaylistDAO implements Dao<Playlist> {

    private List<Playlist> playlists = new ArrayList<>();

    public PlaylistDAO() {
        playlists.add(new Playlist("Best hits ever"));
        playlists.add(new Playlist("Baddest songs ever"));
        playlists.add(new Playlist("Sick music list 1.0"));
        playlists.add(new Playlist("Jan Smit de wereld rond"));

    }

    @Override
    public Optional<Playlist> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Playlist> getAll() {
        return null;
    }

    @Override
    public void save(Playlist playlist) {

    }

    @Override
    public void update(Playlist playlist, String[] params) {

    }

    @Override
    public void delete(Playlist playlist) {

    }


//Aanmaken playlists
}
