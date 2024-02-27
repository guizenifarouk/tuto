package com.talan.pfemanager.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talan.pfemanager.dto.UserDTO;
import com.talan.pfemanager.helper.UserHelper;
import com.talan.pfemanager.repository.UserRepository;
import com.talan.pfemanager.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDTO register(UserDTO userDTO) {
		return UserHelper.entityToDto(userRepository.save(UserHelper.dtoToEntity(userDTO)));
	}
	
	@Override
	public List<UserDTO> getUsers() {
		List<UserDTO> allUsersDTO = new ArrayList<UserDTO>();
		userRepository.findAll().forEach((user) -> allUsersDTO.add(UserHelper.entityToDto(user)));
		return allUsersDTO ;
	}

	@Override
	public UserDTO getUser(int id) {
		return UserHelper.entityToDto(userRepository.findById(id).get()) ;
	}

	@Override
	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}
	
	@Override
	public void deleteAllUsers() {
		userRepository.deleteAll();
	}

	@Override
	public UserDTO updateUser(int id, UserDTO updatedUser) throws Exception {
		UserDTO userDTO;
		userDTO= getUser(id);
		if (userDTO !=null) {
			updatedUser.setId(id);		
			return UserHelper.entityToDto(userRepository.save(UserHelper.dtoToEntity(updatedUser)));
		}
		throw new Exception("could not find user id = " + id);
		
	}

}
