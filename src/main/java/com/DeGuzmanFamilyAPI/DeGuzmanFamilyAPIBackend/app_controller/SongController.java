package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models.Song;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_repository.SongRepository;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_service.SongService;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.exception.ResourceNotFoundException;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.exception.TitleException;

@RestController
@CrossOrigin
@RequestMapping("/app/music")
public class SongController {

	@Autowired
	private SongService songService;
	
	@Autowired
	private SongRepository songRepository;
	
	@GetMapping("/all")
	public List<Song> findAllSongInformation() {
		return songService.findAllSongInformation();
	}
	
	@GetMapping("/all-music")
	public ResponseEntity<Map<String,Object>> getAllMusicPage(@RequestParam(required = false) String title,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		return songService.getAllMusicPage(title, page, size);
	}

	@GetMapping("/song/{song_id}")
	public ResponseEntity<Song> findSongById(@PathVariable int song_id) throws ResourceNotFoundException {
		return songService.findSongById(song_id);
	}

	@GetMapping("/song/title/{title}")
	public ResponseEntity<Song> findSongByTitle(@PathVariable String title) {
		return songService.findSongByTitle(title);
	}

	@GetMapping("song/artist/{artist}")
	public List<Song> findSongByArtist(String artist) {
		return songService.findSongByArtist(artist);
	}

	@PostMapping("/add-music")
	public Song addSongInformation(@Valid @RequestBody Song song) throws TitleException {
		return songService.addSongInformation(song);
	}

	@PutMapping("/song/{song_id}")
	public ResponseEntity<Song> updateSongInformation(@PathVariable int song_id, @RequestBody @Valid Song songDetails) {
		return songService.updateSongInformation(song_id, songDetails);
	}

	@DeleteMapping("/song/{song_id}")
	public Map<String, Boolean> deleteSongInformation(int song_id) {
		return songService.deleteSongInformation(song_id);
	}
}
