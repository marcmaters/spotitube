package nl.han.dea.marc.services;

import nl.han.dea.marc.datasources.PlaylistsDAO;
import nl.han.dea.marc.dtos.PlaylistsDTO;
import nl.han.dea.marc.dtos.TrackDTO;
import nl.han.dea.marc.dtos.TracksDTO;

import javax.inject.Inject;
import java.sql.SQLException;

public class PlayListService {

    PlaylistsDAO playlistsDAO;

    public PlaylistsDTO getPlaylists() {
        PlaylistsDTO playlistsDTO = new PlaylistsDTO();
        playlistsDTO.setPlaylists(playlistsDAO.getPlaylists());
        playlistsDTO.setLength(playlistsDAO.getLengthFromPlaylists());
        return playlistsDTO;
    }

    public void updatePlaylist(int playListId, String newPlaylistName) {
        playlistsDAO.updatePlaylists(playListId, newPlaylistName);
    }

    public void addPlaylist(String playlistName) {
        playlistsDAO.setPlaylist(playlistName);
    }

    public void deletePlaylist(int playListId) {
        playlistsDAO.deletePlaylists(playListId);
    }

    public void addTrackToPlaylist(int playlistId, TrackDTO selectedTrack, TrackService tracksService) throws SQLException {
        TracksDTO tracksDTO = tracksService.getTracks(playlistId);
        boolean alreadyExists = false;
        for(TrackDTO track : tracksDTO.getTracks()){
            if(selectedTrack.getId() == track.getId()){
                alreadyExists = true;
                return;
            }
        }
        if(!alreadyExists){
            playlistsDAO.addTrackToPlaylist(playlistId, selectedTrack);
        }
    }

    @Inject
    public void setPlaylistsDAO(PlaylistsDAO playlistsDAO) {this.playlistsDAO = playlistsDAO;}

}

//public return playlistsDTO
//wordt uit de DAO gehaald
//wordt de DAO geinjecteerd
//deze klasse wordt in controllers geinjecteerd