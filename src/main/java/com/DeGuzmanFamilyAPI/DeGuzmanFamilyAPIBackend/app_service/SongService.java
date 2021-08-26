package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models.Song;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_repository.SongRepository;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_service_interface.SongServiceInterface;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.exception.ResourceNotFoundException;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.exception.TitleException;

@Service
public class SongService implements SongServiceInterface {

	@Autowired
	private SongRepository songRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(SongService.class);
	
	@Override
	public List<Song> findAllSongInformation() {
		List<Song> songList = songRepository.findAll();

		if (songList.size() == 0 || songList.isEmpty()) {
			LOGGER.warn("List is Empty");
		}

		return songRepository.findAll();
	}
	
	@Cacheable(value = "songList")
	public ResponseEntity<Map<String,Object>> getAllMusicPage(@RequestParam(required = false) String title,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		try {
			List<Song> songs = songRepository.findAll();
			Pageable paging = PageRequest.of(page, size);
			
			Page<Song> pageSongs;
			
			if (title == null) {
				pageSongs = songRepository.findAll(paging);
			} else {
				pageSongs = songRepository.findByTitleContaining(title, paging);
			}
			
			songs = pageSongs.getContent();
			
			Map<String,Object> response = new HashMap<>();
			response.put("songs", songs);
			response.put("currentPage", pageSongs.getNumber());
			response.put("totalItems", pageSongs.getTotalElements());
			response.put("totalPages", pageSongs.getTotalPages());
			
			return new ResponseEntity<>(response, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public boolean checkSongName(String name) {
		
		List<Song> songsList = songRepository.findAll();
		List<String> namesList;
		boolean result = false;
		
		namesList = songsList.stream().map(Song::getTitle).collect(Collectors.toList());
		
		if (namesList.contains(name.trim())) {
			result = true;
		}
		
		return result;
	}
	
	@Override
	@Cacheable(value = "songById", key = "#songId")
	public ResponseEntity<Song> findSongById(@PathVariable int song_id) throws ResourceNotFoundException {

		Song song = null;

		song = songRepository.findById(song_id)
				.orElseThrow(() -> new ResourceNotFoundException("Cannot find resource with ID: " + song_id));

		if (song_id == 0) {
			LOGGER.error("Cannot find resource with ID:" + " " + song_id);
		}

		else {
			LOGGER.info("Song: " + song.title + " has been added");
		}

		return ResponseEntity.ok().body(song);
	}

	@Override
	@CachePut(value = "songList")
	public ResponseEntity<Song> findSongByTitle(@PathVariable String title) {
		Song song = null;
		song = songRepository.findByTitle(title);

		if (title == "" || title == null) {
			LOGGER.warn("Music Title is blank");
		} else {
			LOGGER.info("Music title: " + title);
		}

//		if (artist == "" || artist == null) {
//			MusicLogger.musicLogger.warning("Artist is blank/null");
//		}
//		
		return ResponseEntity.ok().body(song);
	}

	@Override
	public List<Song> findSongByArtist(String artist) {

		List<Song> song = null;

		song = songRepository.findSongsByArtist(artist);

		if (artist == "" || artist == null) {
			LOGGER.warn("Artist is blank/null");
		} else {
			LOGGER.info("Song retrieved with artist: " + artist);
		}

		return song;
	}

	@Override
	public Song addSongInformation(@Valid @RequestBody Song song) throws TitleException {
		if (song.title == "" || song.title == null) {
			LOGGER.warn("Music Title is blank");
		} else {
			
			if (checkSongName(song.getTitle())) {
				throw new TitleException("Title Already Exists");
			}
			
			LOGGER.info("Music title: " + song.title);
		}
		
		System.out.println(song);
		
		return songRepository.save(song);
	}

	@Override
	public ResponseEntity<Song> updateSongInformation(@PathVariable int song_id, @RequestBody @Valid Song songDetails) {
		Song song = null;
		try {
			song = songRepository.findById(song_id)
					.orElseThrow(() -> new ResourceNotFoundException("Cannot find resource with ID: " + song_id));
			
			if (songDetails.artist == "" || songDetails.artist == null) {
				LOGGER.warn("Artist is blank/null");
			}
			song.setArtist(songDetails.getArtist());
			song.setGenre(songDetails.getGenre());
			
			if (song.title == "" || song.title == null) {
				LOGGER.warn("Music Title is blank");
			} else {
				LOGGER.info("Music title: " + song.title);
			}

			song.setTitle(songDetails.getTitle());
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
		}

		final Song updatedSongInformation = songRepository.save(songDetails);

		return ResponseEntity.ok().body(updatedSongInformation);
	}

	@Override
	public Map<String, Boolean> deleteSongInformation(int song_id) {
		songRepository.deleteById(song_id);
		
		if (song_id == 0) {
			LOGGER.error("Cannot find resource with ID:" + " " + song_id);
		}

		else {
			LOGGER.info("Song has been added with ID: " + song_id);
		}
		
		Map<String, Boolean> response = new HashMap<>();
		Optional<Song> song = songRepository.findById(song_id);
		response.put("Song has been removed from list", Boolean.TRUE);

		return response;
	}
}
