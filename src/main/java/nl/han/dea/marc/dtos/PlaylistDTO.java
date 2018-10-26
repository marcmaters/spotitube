package nl.han.dea.marc.dtos;

import java.util.ArrayList;

import static javax.swing.JOptionPane.showMessageDialog;

public class PlaylistDTO {

    private int id;
    private String name;
    private boolean owner;
    private ArrayList<TrackDTO> tracks;

    public PlaylistDTO(int id, String name, boolean owner, ArrayList<TrackDTO> tracks) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.tracks = tracks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOwner() {
        return owner;
    }

    public void setOwner(boolean owner) {
        this.owner = owner;
    }

    public ArrayList<TrackDTO> getTracks() {
        return tracks;
    }

    public void setTracks(ArrayList<TrackDTO> tracks) {
        this.tracks = tracks;
    }

}
