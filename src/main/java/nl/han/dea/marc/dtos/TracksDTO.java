package nl.han.dea.marc.dtos;

import java.util.ArrayList;
import java.util.List;

public class TracksDTO {

    List<TrackDTO> tracks = new ArrayList<>();

    public void setTracks(List<TrackDTO> tracks) {
        this.tracks = tracks;
    }

    public List<TrackDTO> getTracks() {
        return tracks;
    }

}
