package ru.sfedu.lab3CSV;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.Constants;

import java.io.*;
import java.util.List;

public class DataProviderCSV implements IDataProvider {

    private static final Logger log = LogManager.getLogger(DataProviderCSV.class.getName());

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

    private <T> String findPath(T bean) {
        switch (bean.getClass().getSimpleName()){
            case "Users":
                return Constants.CSV_PATH;
        }
        return "haha1";
    }

    private static <T> String findPath(List <T> bean) {
        switch (bean.get(0).getClass().getSimpleName()){
            case "Users":
                return Constants.CSV_PATH;
        }
        return Constants.CSV_PATH_LIST;
    }

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





    @Override
    public List<Users> selectUsers() {
        Users users = new Users();
        return loadBeans(users);
    }

    @Override
    public Users getById(long userId) {
        Users list = selectUsers().stream()
                .filter(beans->(beans).getUserId() == userId)
                .findFirst().orElse(null);
        return list;
    }

    @Override
    public void insertUsers(Users Users) {
    List<Users> users = loadBeans(Users);
    users.add(Users);
    saveFile(users);
    }

    @Override
    public void deleteUsersById(long userId) {
        List<Users> list = selectUsers();
        list.removeIf(beans -> (beans).getUserId()==userId);
        saveFile(list);

    }

    @Override
    public void updateUsersById(long userId, Users Users) {
        List<Users> list = selectUsers();
        int index = list.indexOf(getById(userId));
        list.set(index, Users);
        saveFile(list);
    }
}
