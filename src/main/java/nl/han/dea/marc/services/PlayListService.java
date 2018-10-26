package nl.han.dea.marc.services;

import nl.han.dea.marc.datasources.PlaylistsDAO;
import nl.han.dea.marc.dtos.PlaylistDTO;
import nl.han.dea.marc.dtos.PlaylistsDTO;

import javax.inject.Inject;
import java.util.List;

public class PlayListService {

    PlaylistsDAO playlistsDAO;

    public PlaylistsDTO getPlaylists() {
        List<PlaylistDTO> playlists = playlistsDAO.getPlaylists();
        PlaylistsDTO playlistsDTO = new PlaylistsDTO();
        playlistsDTO.setPlaylists(playlists);
        playlistsDTO.setLength(4000);
        return playlistsDTO;
    }

    @Inject
    public void setPlaylistsDAO(PlaylistsDAO playlistsDAO) {this.playlistsDAO = playlistsDAO;}
}

//public return playlistsDTO
//wordt uit de DAO gehaald
//wordt de DAO geinjecteerd
//deze klasse wordt in controllers geinjecteerd