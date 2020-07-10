package fr.seedle.pandora.launcher;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.seedle.pandora.dto.MembreDto;

public class ApplicationLauncher {

	public static void main(String[] args) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(new ArrayList<MembreDto>());
		System.out.println("json resultat : " + json);
	}

}
