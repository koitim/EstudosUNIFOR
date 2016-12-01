package br.com.koitim.estudosunifor.repository;

import android.content.ContentValues;

import java.util.ArrayList;
import java.util.List;

import br.com.koitim.estudosunifor.model.User;

/**
 * Created by koitim on 26/11/2016.
 */

public class UserRepository extends  GenericRepository<User>{

    private static UserRepository instance = null;

    private List<User> users;

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    private UserRepository() {
        users = new ArrayList<>();
        User u = new User("Coutinho", "koitim", "amesma");
        users.add(u);
    }

    @Override
    public ContentValues getContentVaslues(User obj) {
        //TODO: Fazer quando trabalhar com BD
        return null;
    }
}
