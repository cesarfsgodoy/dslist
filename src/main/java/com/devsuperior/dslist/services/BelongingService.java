package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.entities.Belonging;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.BelongingRepository;
import com.devsuperior.dslist.repositories.GameListRepository;
import com.devsuperior.dslist.repositories.GameRepository;

@Service
public class BelongingService {
	@Autowired
	private BelongingRepository belongingRepository;
	
	@Autowired
    private GameRepository gameRepository;


    @Autowired
    private GameListRepository gameListRepository;
	
	public void addGameToList(long gameId, long listId) {
		Game game = gameRepository.findById(gameId).get();
		GameList list = gameListRepository.findById(listId).get();
		
		List<GameMinProjection> games = gameRepository.searchByList(list.getId());
		
		var pos = games.size();
		
		Belonging belonging = new Belonging(game, list, pos);
		belongingRepository.save(belonging);
		
		
	}
}
