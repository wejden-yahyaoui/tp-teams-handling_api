package fr.sorbonne.paris.nord.university.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.sorbonne.paris.nord.university.api.Entity.PlayerEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
	public class TeamDTO {

		private long id;
		private String name;
		private String slogan;
		private List<PlayerDTO> players = new ArrayList<>();

}


