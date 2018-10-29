package nl.han.dea.marc.playlist;


import nl.han.dea.marc.controllers.PlaylistController;
import nl.han.dea.marc.dtos.PlaylistDTO;
import nl.han.dea.marc.dtos.PlaylistsDTO;
import nl.han.dea.marc.services.PlayListService;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class PlayListControllerTest {

    @Test
    public void testIfPlayListsAreLoaded() {
        PlaylistController playlistController = new PlaylistController();

        PlayListService playListService = Mockito.mock(PlayListService.class);
        playlistController.setPlayListService(playListService);

        List<PlaylistDTO> playLists = new ArrayList<>();
        playLists.add(new PlaylistDTO());
        PlaylistsDTO playlistsDTO = new PlaylistsDTO();
        Mockito.when(playListService.getPlaylists(String.valueOf(Mockito.anyInt()))).thenReturn(playlistsDTO);

        PlaylistsDTO collectionDTO = (PlaylistsDTO) playlistController.getPlaylists("1234").getEntity();
        Assert.assertEquals(playlistsDTO.getPlaylists().size(), collectionDTO.getPlaylists().size());
    }
}
