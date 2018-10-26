package nl.han.dea.marc.dtos;

import java.util.ArrayList;
import java.util.List;

public class PlaylistsDTO {

    public void setPlaylists(List<PlaylistDTO> playlists) {
        this.playlists = playlists;
    }

    List<PlaylistDTO> playlists = new ArrayList<>();
    private int length;

    public List<PlaylistDTO> getPlaylists() {
        return playlists;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

}
