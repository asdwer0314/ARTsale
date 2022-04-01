package ru.sfedu.api;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.Constants;
import ru.sfedu.model.*;

import java.io.*;
import java.util.List;
import java.util.Optional;

public class DataProviderCSV implements IDataProvider {

    private static final Logger log = LogManager.getLogger(DataProviderCSV.class.getName());
    public DataProviderCSV() {}


    private <T> void saveFile(List <T> list){
        Writer writer = null;
        try {
            writer = new FileWriter(findPath(list));
        } catch (IOException e) {
            log.error(e);
        }
        StatefulBeanToCsv sbc = new StatefulBeanToCsvBuilder(writer)
                .withSeparator(',')
                .build();
        try{
            sbc.write(list);
        } catch (CsvRequiredFieldEmptyException e) {
            log.error(e);
        } catch (CsvDataTypeMismatchException e) {
            log.error(e);
        }
        try {
            writer.close();
        } catch (IOException e) {
            log.error(e);
        }
    }

    private static <T> String findPath(List <T> bean) {
        switch (bean.get(0).getClass().getSimpleName()){
            case "User":
                return Constants.CSV_PATH;
        }
        return Constants.CSV_PATH;
    }

    private <T> String findPath(T bean) {
        switch (bean.getClass().getSimpleName()){
            case "User":
                return Constants.CSV_PATH;
        }
        return "it's ok";
    }

    private <T> List <T> loadBeans(T bean){
        List list = null;
        try {
            list = new CsvToBeanBuilder(new FileReader(findPath(bean)))
                    .withType(bean.getClass())
                    .build()
                    .parse();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }







//
//    @Override
//    public List<User> selectUser() {
//        User user = new User();
//        return loadBeans(user);
//    }
//
//    @Override
//    public Optional<User> getUserById(long userId) {
//        User list = selectUser().stream()
//                .filter(beans->(beans).getUserById() == userId)
//                .findFirst().orElse(null);
//        return list;
//    }
//
//    @Override
//    public void insertUser(User User) {
//        List<User> user = loadBeans(User);
//        user.add(User);
//        saveFile(user);
//    }
//
//    @Override
//    public void deleteUserById(long userId) {
//        List<User> list = selectUser();
//        list.removeIf(beans -> (beans).getUserById()==userId);
//        saveFile(list);
//    }
//
//    @Override
//    public void updateUserById(long userId, User User) {
//        List<User> list = selectUser();
//        int index = list.indexOf(getUserById(userId));
//        list.set(index, User);
//        saveFile(list);
//    }
//
//    @Override
//    public void useCase1() {
//
//    }
//
//    public CharSequence getEmail(User user) {
//        return null;
//    }
}
