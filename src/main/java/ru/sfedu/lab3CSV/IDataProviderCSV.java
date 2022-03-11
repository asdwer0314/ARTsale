package ru.sfedu.lab3CSV;

import java.util.List;

public interface IDataProviderCSV {

    List<Users> selectUsers();
    Users getById(long userId);
    void insertUsers(Users Users);
    void deleteUsersById(long userId);
    void updateUsersById(long userId, Users Users);
}
