package nl.han.dea.marc.dto;

import nl.han.dea.marc.datasource.TracksDAO;
import nl.han.dea.marc.model.Track;

public class TracksDTO {
    public Track[] tracks;

    public TracksDTO(int id){
        if(id == 1){
            tracks = new TracksDAO().getHitzone1Tracks();
        }//todo
    }
}
