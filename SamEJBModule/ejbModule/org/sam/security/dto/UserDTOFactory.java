package org.sam.security.dto;

import org.sam.security.entities.User;

public class UserDTOFactory {

	public static UserDTO buildUserDTO(User user) {
		UserDTO dto = null;
		if (user != null) {
			dto = new UserDTO();
			dto.setLogin(user.getLogin());
			dto.setRoles(user.getRoles());
			if (user.getStudent() != null) {
				dto.setLegajo(user.getStudent().getLegajo());
			}

		}

		return dto;
	}

	public static User buildUser(UserDTO userDTO) {
		User user = null;
		if (userDTO != null) {
			user = new User();
			user.setLogin(userDTO.getLogin());
			user.setPassword(userDTO.getPassword());
			user.setRoles(userDTO.getRoles());
		}
		return user;
	}
}
