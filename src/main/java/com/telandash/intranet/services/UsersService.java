package com.telandash.intranet.services;

import com.telandash.intranet.models.UsersModel;
import com.telandash.intranet.repositories.UsersRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    @Autowired
    UsersRepository usersRepository;

    /**
     * Retrieves user information by searching for the user with the given username.
     *
     * @param username The username of the user to retrieve.
     * @return Optional containing the UserModel if found, otherwise empty.
     */
    public Optional<UsersModel> findUserByUsername(String username) {
        return usersRepository.findByUsername(username);
    }

    /**
     * Retrieves a paginated list of all users in the system.
     *
     * @return Page of UserModel objects.
     */
    public List<UsersModel> getAll() {
        return usersRepository.findAll();
    }

    /**
     * Retrieves a specific user by its ID.
     *
     * @param id The ID of the user to retrieve.
     * @return Optional containing the UserModel if found, otherwise empty.
     */
    public Optional<UsersModel> getById(Long id) {
        return usersRepository.findById(id);
    }

    /**
     * Creates a new user record in the system.
     *
     * @param user The UserModel object representing the new user.
     * @return The created UserModel.
     */
    public UsersModel createUser(UsersModel user) {
        return usersRepository.save(user);
    }

    public UsersModel updateUser(Long id, UsersModel user) {
        return usersRepository.findById(id)
                .map(existing -> {
                    existing.setEmail(user.getEmail());
                    existing.setDni(user.getDni());
                    return usersRepository.save(existing);
                })
                .orElse(null);


    }

    /**
     * Deletes a user record from the system by its ID.
     *
     * @param id The ID of the user to delete.
     */
    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }

}
