package nl.han.dea.marc.playlist.dto;

import nl.han.dea.marc.playlist.datasource.TracksDAO;
import nl.han.dea.marc.playlist.model.Track;

public class TracksDTO {
    public Track[] tracks;

    public TracksDTO(int id){
        if(id == 1){
            tracks = new TracksDAO().getHitzone1Tracks();
        }//todo
    }
}
